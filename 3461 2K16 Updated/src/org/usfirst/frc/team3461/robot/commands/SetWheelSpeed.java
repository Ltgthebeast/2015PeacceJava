package org.usfirst.frc.team3461.robot.commands;

import org.usfirst.frc.team3461.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetWheelSpeed extends Command {
	double speed;
	
    public SetWheelSpeed(double input) {
    	speed = input;
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.shooterwheels);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
		Robot.shooterwheels.SetSpeed(-speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooterwheels.SetSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.shooterwheels.SetSpeed(0);
    }
}
