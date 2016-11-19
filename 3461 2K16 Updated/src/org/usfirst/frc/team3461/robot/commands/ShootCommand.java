package org.usfirst.frc.team3461.robot.commands;


import org.usfirst.frc.team3461.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ShootCommand extends Command {

	public ShootCommand(){
		requires(Robot.shooterpuncher);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.shooterwheels.SetSpeed(-1);
		Robot.shooterpuncher.Retract();
		
		Timer.delay(1.5);
		Robot.shooterpuncher.Extend();
		Robot.shooterwheels.SetSpeed(0);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
    
    
}
