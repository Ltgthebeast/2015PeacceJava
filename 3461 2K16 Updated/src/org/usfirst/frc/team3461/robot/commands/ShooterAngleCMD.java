package org.usfirst.frc.team3461.robot.commands;

import org.usfirst.frc.team3461.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShooterAngleCMD extends Command {

	public int direction;
	
    public ShooterAngleCMD(int direction) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooterangle);
    	this.direction = direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(direction == 0){
    		// no move
    		Robot.shooterangle.AngleTalon1.set(0);
    	}else if(direction == 1){
    		// up
    		Robot.shooterangle.AngleTalon1.set(.5);
    	}else if(direction == 2){
    		// down
    		Robot.shooterangle.AngleTalon1.set(-.5);
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
