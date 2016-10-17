package org.usfirst.frc.team3461.robot.commands;

import org.usfirst.frc.team3461.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class VisionDriving extends Command {

    public VisionDriving() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.stop();
    	Robot.visionprocessing.initTable();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.visionprocessing.visionDriving();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
        return Robot.visionprocessing.shootDone;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stop();
    	Robot.visionprocessing.initTable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drivetrain.stop();
    	Robot.visionprocessing.initTable();
    }
}
