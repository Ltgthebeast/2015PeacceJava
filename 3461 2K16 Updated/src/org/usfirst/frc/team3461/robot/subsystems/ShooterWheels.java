package org.usfirst.frc.team3461.robot.subsystems;

import org.usfirst.frc.team3461.robot.RobotMap;
import org.usfirst.frc.team3461.robot.commands.SetWheelSpeed;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterWheels extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	CANTalon WheelsTalon1 = new CANTalon(RobotMap.ShooterWheelsPort1),
			 WheelsTalon2 = new CANTalon(RobotMap.ShooterWheelsPort2);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new SetWheelSpeed(0));
    }
    public void SetSpeed(double speed)
    {
    	WheelsTalon1.set(-speed);
    	WheelsTalon2.set(-speed);
    }
}

