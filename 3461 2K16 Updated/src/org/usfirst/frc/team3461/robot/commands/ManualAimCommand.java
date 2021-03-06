package org.usfirst.frc.team3461.robot.commands;

import org.usfirst.frc.team3461.robot.Robot;
import org.usfirst.frc.team3461.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ManualAimCommand extends CommandGroup {
    
    public  ManualAimCommand() {
    	this.requires(Robot.shooterangle);
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	if(Robot.oi.GamePad2.getPOV() == 0){
    		addSequential(new AutoAimCommand(RobotMap.AngleUp));
    	}
    	else if(Robot.oi.GamePad2.getPOV() == 270){
    		addSequential(new AutoAimCommand(RobotMap.AngleShoot));
    	}
    	else if(Robot.oi.GamePad2.getPOV() == 180){
    		addSequential(new AutoAimCommand(RobotMap.AngleDown));
    	}
    	else if(Robot.oi.GamePad2.getPOV() == 90){
    		addSequential(new AutoAimCommand(RobotMap.AngleFloat));
    	}
    
    }
}
