package org.usfirst.frc.team3461.robot.commands;

import org.usfirst.frc.team3461.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveCommand extends Command {

    public DriveCommand() {
        // Use requires() here to declare subsystem dependencies
       requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.LDrive(Robot.oi.GamePad1.getRawAxis(1) + Robot.oi.GamePad1.getRawAxis(0));
    	Robot.drivetrain.RDrive(Robot.oi.GamePad1.getRawAxis(1) - Robot.oi.GamePad1.getRawAxis(0));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.LDrive(0);
    	Robot.drivetrain.RDrive(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drivetrain.LDrive(0);
    	Robot.drivetrain.RDrive(0);
    }
}
