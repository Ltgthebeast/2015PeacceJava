package org.usfirst.frc.team3461.robot.subsystems;

import org.usfirst.frc.team3461.robot.RobotMap;
import org.usfirst.frc.team3461.robot.commands.SetWheelSpeed;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterWheels extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	VictorSP WheelsTalon1 = new VictorSP(RobotMap.ShooterWheelsPort1),
			 WheelsTalon2 = new VictorSP(RobotMap.ShooterWheelsPort2);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new SetWheelSpeed(0));
    }
    public void SetSpeed(double speed)
    {
    	WheelsTalon1.set(speed);
    	WheelsTalon2.set(speed);
    }
}

