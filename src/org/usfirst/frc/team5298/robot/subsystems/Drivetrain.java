package org.usfirst.frc.team5298.robot.subsystems;



import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team5298.robot.commands.MecanumDefaultCode;



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
	private RobotDrive drive;

	public Drivetrain() {
		frontRight = new TalonSRX(1);
		frontLeft = new TalonSRX(2);
		rearRight = new TalonSRX(3);
		rearLeft = new TalonSRX(4);
		drive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
	}

	public void Mecanum(double leftSpeed, double rightSpeed) {
	drive.mecanumDrive_Cartesian(leftSpeed, rightSpeed, rightSpeed, rightSpeed); }
		
		 public void initDefaultCommand() {
		        // Set the default command for a subsystem here.
		        setDefaultCommand(new MecanumDefaultCode());
	}
		 
		private void setDefaultCommand(MecanumDefaultCode mecanumDefaultCode) {
			// TODO Auto-generated method stub
			
		}
	
}

