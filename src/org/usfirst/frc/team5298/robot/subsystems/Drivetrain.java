package org.usfirst.frc.team5298.robot.subsystems;



import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5298.robot.commands.DriveTrainCommands;
import org.usfirst.frc.team5298.robot.Gamepad;

import edu.wpi.first.wpilibj.RobotDrive;

/**
 *
 */	
public class Drivetrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private Talon frontRight;
	private Talon frontLeft;
	private Talon rearRight;
	private Talon rearLeft;
	public RobotDrive drive;
	public Gamepad driverPad;

	public void DriveTrain() {
		frontRight = new Talon(1);
		frontLeft = new Talon(2);
		rearRight = new Talon(3);
		rearLeft = new Talon(4);
		drive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
	}

	public void Mecanum(double x, double y, double rotation, double gyroAngle) {
	drive.mecanumDrive_Cartesian(driverPad.getLeftX(), driverPad.getLeftY(), driverPad.getRightX(), 0); }
		
		 public void initDefaultCommand() {
		        // Set the default command for a subsystem here.
			// setDefaultCommand(new DriveTrainCommands());
	}
		 
		
	
}