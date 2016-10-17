package org.usfirst.frc.team3461.robot.subsystems;

import org.usfirst.frc.team3461.robot.RobotMap;
import org.usfirst.frc.team3461.robot.commands.ArmCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BunnyEars extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	VictorSP RightArmTalon = new VictorSP(RobotMap.RightArmPort);
	VictorSP LeftArmTalon = new VictorSP(RobotMap.LeftArmPort);
	
	DigitalInput LS3 = new DigitalInput(RobotMap.LS3Port), //down right
				 LS4 = new DigitalInput(RobotMap.LS4Port), //up right
				 LS5 = new DigitalInput(RobotMap.LS5Port), //down left
				 LS6 = new DigitalInput(RobotMap.LS6Port); //up left
	//positive is down


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ArmCommand());
    }
    
    public void ArmControl(double speed)
    {
    	if(LS3.get() == true) RightArmTalon.set(-1);
    	if(LS4.get() == true) RightArmTalon.set(1);
    	if(LS5.get() == true) LeftArmTalon.set(-1);
    	if(LS6.get() == true) LeftArmTalon.set(1);
    	else{
    		RightArmTalon.set(speed);
    		LeftArmTalon.set(speed);
    	}
    }
}

