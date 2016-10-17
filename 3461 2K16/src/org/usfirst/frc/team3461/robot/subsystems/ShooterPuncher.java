package org.usfirst.frc.team3461.robot.subsystems;

import org.usfirst.frc.team3461.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterPuncher extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	DoubleSolenoid Piston1 = new DoubleSolenoid(RobotMap.PuncherCHA, RobotMap.PuncherCHB);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //etDefaultCommand(new MySpecialCommand());
    }
    
    public void Extend()
    {
    	Piston1.set(DoubleSolenoid.Value.kForward);
    }
    public void Retract()
    {
    	Piston1.set(DoubleSolenoid.Value.kReverse);
    }
    
}

