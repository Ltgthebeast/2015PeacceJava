package org.usfirst.frc.team3461.robot.commands;

import org.usfirst.frc.team3461.robot.Robot;
import org.usfirst.frc.team3461.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoAimCommand extends Command {

	double setpoint;
	
    public AutoAimCommand(double input) {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.shooterangle);
    	setpoint = input;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooterangle.setSetpoint(setpoint);
    	Robot.shooterangle.enable();
    	SmartDashboard.putBoolean("On Target", false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(Robot.shooterangle.getPosition() - Robot.shooterangle.getSetpoint()) < RobotMap.Buffer;
    }

    // Called once after isFinished returns true
    protected void end() {
    	SmartDashboard.putBoolean("On Target", true);
    	Robot.shooterangle.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	SmartDashboard.putBoolean("On Target", false);
    	Robot.shooterangle.disable();
    }
}
