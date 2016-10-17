package org.usfirst.frc.team3461.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	public static final double 
		//Pot Positions
		AngleUp = .82,
		AngleDown = .008,
		AngleShoot = .65,
		AngleFloat = .07,
		PotBuffer = 0,
		
		//Shooter Wheel Speeds
		LowSpeed = .15,
		HighSpeed = 1,
		IntakeSpeed = -.16,
		
		//Shooter angle buffer
		Buffer = 3;
	
	public static final int
		//CAN ID's & PWM
		//can - talon srx, pwm - victor sp
		LDrivePort1 = 3, // and 4 can
		RDrivePort1 = 1, //and 2 can
		LDrivePort2 = 4,
		RDrivePort2 = 2,
		
		RightArmPort = 6, // pwm
		LeftArmPort = 7, //pwm
		
		ShooterWheelsPort1 = 5, //and 6 can
		ShooterWheelsPort2 = 6,
		
		ShooterAnglePort1 = 4, //and 5 pwm
		ShooterAnglePort2 = 5,
		
		//D I/O
		LS1Port = 1, //shootert up
		LS2Port = 2, // shooter down
		LS3Port = 4, // ears down right
		LS4Port = 5, // ears up right
		LS5Port = 12, // ears down left
		LS6Port = 13, // ears up left
		
		//PCM
		PuncherCHA = 0,
		PuncherCHB = 1,
		
		//Analog
		Pot1Port = 1;
}
