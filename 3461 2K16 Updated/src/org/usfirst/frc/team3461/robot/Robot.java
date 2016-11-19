
package org.usfirst.frc.team3461.robot;

import org.usfirst.frc.team3461.robot.commands.ShooterAngleCMD;
import org.usfirst.frc.team3461.robot.subsystems.BunnyEars;
import org.usfirst.frc.team3461.robot.subsystems.DriveTrain;
import org.usfirst.frc.team3461.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team3461.robot.subsystems.ShooterAngle;
import org.usfirst.frc.team3461.robot.subsystems.ShooterPuncher;
import org.usfirst.frc.team3461.robot.subsystems.ShooterWheels;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	public static final DriveTrain drivetrain = new DriveTrain();
	public static final BunnyEars arms = new BunnyEars();
	public static final ShooterAngle shooterangle = new ShooterAngle();
	public static final ShooterWheels shooterwheels = new ShooterWheels();
	public static final ShooterPuncher shooterpuncher = new ShooterPuncher();
	//public static final VisionProcessing visionprocessing = new VisionProcessing();
    Command autonomousCommand;
    SendableChooser chooser;
    
   // CameraServer cam;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();

    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
     
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public ShooterAngleCMD shootControl;
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        //visionProcessing.updateVariable();
      //  visionProcessing.fixLeftRight();
//        for(int i = 0; i < 10; i++){
//        	SmartDashboard.putBoolean(String.valueOf(i), new DigitalInput(i).get());
//        }
        if(oi.GamePad2.getPOV() == 0){
        	shootControl = new ShooterAngleCMD(1);
        	shootControl.start();
        }else if(oi.GamePad2.getPOV() == 180){
        	shootControl = new ShooterAngleCMD(2);
        	shootControl.start();
        }else{
        	shootControl = new ShooterAngleCMD(0);
        	shootControl.start();
        }
       if(shootControl != null){
    	   shootControl.cancel();
       }
        
        
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
