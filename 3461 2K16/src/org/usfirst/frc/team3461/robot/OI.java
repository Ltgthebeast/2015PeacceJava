package org.usfirst.frc.team3461.robot;

import org.usfirst.frc.team3461.robot.commands.AutoAimCommand;
import org.usfirst.frc.team3461.robot.commands.DriveCommand;
import org.usfirst.frc.team3461.robot.commands.SetWheelSpeed;
import org.usfirst.frc.team3461.robot.commands.ShootCommand;
import org.usfirst.frc.team3461.robot.subsystems.ShooterAngle;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public Joystick 
	GamePad1  = new Joystick(0), //driver
	GamePad2  = new Joystick(1); //operator

public JoystickButton
	Low = new JoystickButton(GamePad2, 4),
	High = new JoystickButton(GamePad2, 1),
	Intake = new JoystickButton(GamePad2, 2),
	Shoot = new JoystickButton(GamePad2, 6),
	Aim = new JoystickButton(GamePad2, 3),
	Drive = new JoystickButton(GamePad1, 1);
	
public OI()
{
	Low.whileHeld(new SetWheelSpeed(RobotMap.LowSpeed));
	High.whileHeld(new SetWheelSpeed(RobotMap.HighSpeed));
	Intake.whileHeld(new SetWheelSpeed(RobotMap.IntakeSpeed));
	Shoot.whenPressed(new ShootCommand());
	Aim.toggleWhenPressed(new AutoAimCommand(ShooterAngle.networkAngle));
	Drive.whenPressed(new DriveCommand());
}
	
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

