package org.usfirst.frc.team5298.robot.subsystems;



import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5298.robot.commands.DriveTrainCommands;
import org.usfirst.frc.team5298.robot.Gamepad;
import org.usfirst.frc.team5298.robot.OI;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 *
 */	
public class Drivetrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private TalonSRX frontRight;
	private TalonSRX frontLeft;
	private TalonSRX rearRight;
	private TalonSRX rearLeft;
	public RobotDrive drive;
	public Gamepad driverPad;

	public void DriveTrain() {
		frontRight = new TalonSRX(1);
		frontLeft = new TalonSRX(2);
		rearRight = new TalonSRX(3);
		rearLeft = new TalonSRX(4);
		drive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
	}

	public void Mecanum(double magnitude, double direction, double rotation) {
	drive.mecanumDrive_Polar(driverPad.getLeftY(), driverPad.getRightY(), driverPad.getRightX()); }
		
		 public void initDefaultCommand() {
		        // Set the default command for a subsystem here.
			 setDefaultCommand(new DriveTrainCommands());
	}
		 
		private void setDefaultCommand() {
			// TODO Auto-generated method stub
			}
	
}