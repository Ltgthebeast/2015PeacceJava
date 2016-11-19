package org.usfirst.frc.team3461.robot.subsystems;



import org.usfirst.frc.team3461.robot.RobotMap;
import org.usfirst.frc.team3461.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	CANTalon LDriveTalon1 = new CANTalon(RobotMap.LDrivePort1),
			 RDriveTalon1 = new CANTalon(RobotMap.RDrivePort1),
			 LDriveTalon2 = new CANTalon(RobotMap.RDrivePort2),
			 RDriveTalon2 = new CANTalon(RobotMap.RDrivePort2);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveCommand());
    }
    
    public void LDrive(double speed)
    {
    	LDriveTalon1.set(speed);
    	LDriveTalon2.set(speed);
    }
    public void RDrive(double speed)
    {
    	RDriveTalon1.set(-speed);
    	RDriveTalon2.set(-speed);
    }
    
    public void rotate(double speed){
    	LDrive(speed);
    	RDrive(speed);
    }
    
    public void stop(){
    	LDrive(0);
    	RDrive(0);
    }
    
    public void leftDrive(double speed){
    	LDrive(speed);
    }
    
    public void rightDrive(double speed){
    	RDrive(speed);
    }
}