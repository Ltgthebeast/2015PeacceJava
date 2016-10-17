package org.usfirst.frc.team3461.robot.subsystems;

import org.usfirst.frc.team3461.robot.Robot;
import org.usfirst.frc.team3461.robot.commands.AutoAimCommand;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class VisionProcessing extends Subsystem {

	
	// How I communicate with the computer to the robot
	public NetworkTable table;
	
	// values grabbed from the network table
	public double cogx, cogSize, left, right;

	// variables needed by the program
	public double imageWidth = 640, midx = 320, rangeX = 50, sensitivity = .75;

	// driveTrain
	public DriveTrain drive = Robot.drivetrain;
	
	// booleans for step by step
	public boolean scanned = false, centered = false, found = false, driveable = false, aim = false, shoot = false, once = true, shootDone = false;
	
	public void initTable(){
		scanned = false;
		found = false;
		driveable = false;		
		centered = false;
		table = NetworkTable.getTable("SmartDashboard/camera");
	}

	/*
	 * Vision goes in steps
	 *  1, scan for the target
	 *  2. center the robot on the target
	 *  3. follow the target
	 */
	public void visionDriving(){
		table.putBoolean("scanned", scanned);
		table.putBoolean("found", found);
		table.putBoolean("cenetered", centered);
		table.putBoolean("driveable", driveable);
		// scan for the target
		if(!scanned){

			scanForTarget();
		}
		// center on the target (how im doing it, it will center itself while following the target
		if(found && scanned && !aim){
			drive();
		}
		if(aim && !shoot){
			AutoAimCommand autoAim = null;
			if(once){
				once = false;
				autoAim = new AutoAimCommand(Robot.shooterangle.networkAngle);
				autoAim.start();
				
			}
			shoot = autoAim.isRunning();
			if(shoot){
				autoAim.cancel();
			}
		}
		if(shoot){
			Robot.shooterpuncher.Extend();
			shootDone = true;
			return;
		}
		
				
	}

	public void centerRobot(){
		double delay = .25;
		// cogx means the center of gravity x value of the thing the robot is tracking
		if(cogx < (midx-rangeX)){
			// it is checking if the object it is tracking is too far right of the robot
			// needs to turn right
			drive.rotate(-.25);
			Timer.delay(delay);
			drive.stop();
			return;
		}
		if(cogx > (midx + rangeX)){
			// it checks if the object is too far left from the robot and adjusts
			drive.rotate(.25);
			Timer.delay(delay);
			drive.stop();
			return;
		}
		// once it is centered and passes through both of those if statements it will be able to drive
		driveable = true;
		centered = true;

	}

	public void drive(){
		table.putNumber("left", left);
		table.putNumber("right", right);
		// retrieves variables from networktables
		updateVariable();
		// converts them from a low of 450 and a high of -450 to a low of -1 to a high of 1
		fixLeftRight();
		// starts to drive
		drive.leftDrive(left); 
		drive.rightDrive(right);
		if(left > -.1 && left < .1 && right > -.1 && right < .1){
			// shoot now
			aim = true;
		}
	}

	public void scanForTarget(){
		double speed = .25, delay = .25;
		// rotate the robot until you see the object and keep rotating until the object is in the center of the screen
		if(cogSize == 0){
			drive.rotate(speed);
			Timer.delay(delay);
			drive.stop();
		}else{
			scanned = true;
			found = true;
		}		
	}

	public void fixLeftRight(){
		double low = -300, high = 300;		
		left = map(constrain(left, low, high), low, high, -1, 1);
		right = map(constrain(right, low, high), low, high, -1, 1);
		left *= sensitivity;
		right *= sensitivity;
	}
	// converts a variable in a certain range to a variable in another range
	public double map(double inVal, double oldMin, double oldMax, double newMin, double newMax){
		double oldRange = (oldMin-oldMax), newRange = (newMin-newMax);
		return (((inVal - oldMin) * newRange) / oldRange)+newMin;		
	}
	// restricts a given variable within a certain range
	public double constrain(double inVal, double low, double high){
		if(inVal > high){ return high; }
		else if(inVal < low){ return low; }
		else { return inVal; }
	}

	/*
	 * Network tables is the framework of the smartdashboard 
	 * it allows variables to be passed over a wifi network
	 * it allows roborealm to send variables to the robot 
	 * and it allows the robot to send variables over to the smartdashboard
	 * it is a way of communicating
	 */
	
	public void updateVariable(){		
		cogx = table.getNumber("COG_X", 0);
		cogSize = table.getNumber("COG_BOX_SIZE", 0);
		left = table.getNumber("LEFT_MOTOR", 0);
		right = table.getNumber("RIGHT_MOTOR", 0);		
	}

	public void initDefaultCommand() {
		this.initTable();

	}
}

