package org.usfirst.frc.team3461.robot.subsystems;

import org.usfirst.frc.team3461.robot.RobotMap;
import org.usfirst.frc.team3461.robot.commands.ManualAimCommand;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class ShooterAngle extends PIDSubsystem {
	
	public static  final double Kp = 180,
								Ki = 0.03,
								Kd = 0.003,
								max = 230,
								min = 137;
	public static double networkAngle = 200;
	public Victor AngleTalon1 = new Victor(RobotMap.ShooterAnglePort1);
			 
	
	AnalogPotentiometer Pot1 = new AnalogPotentiometer(RobotMap.Pot1Port);
	
	DigitalInput LS1 = new DigitalInput(RobotMap.LS1Port);

	public void updateVariables(){
		//networkAngle = Robot.visionprocessing.table.getNumber("ANGLE", 0);
	}
	
    // Initialize your subsystem here
    public ShooterAngle() {
    	
    	super("ShooterAngle", Kp, Ki, Kd);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ManualAimCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return (Pot1.get() * 135 + 135);	// -1 to 1 to 0 270
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	//positive is up
    	double angle = (Pot1.get()*135)+135;
    	if(angle > max){
    		AngleTalon1.set(-.25);
    		return;
    	}
    	else if(angle < min){
    		AngleTalon1.set(.25);
    		return;
    	}
//    	if(LS1.get() == true){
//    		AngleTalon1.set(-1);
//    	}
//    	if(LS2.get() == true){
//    		AngleTalon1.set(1);
//    		AngleTalon2.set(1);
//    	}
    	else{
    		AngleTalon1.set(output);
    	}
    }
}
