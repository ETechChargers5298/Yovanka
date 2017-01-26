package org.usfirst.frc.team5298.robot.commands;

import org.usfirst.frc.team5298.robot.Robot;
import org.usfirst.frc.team5298.robot.Gamepad;
import org.usfirst.frc.team5298.robot.subsystems.Drivetrain;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;


public class DriveTrainCommands extends Command {
	
	public DriveTrainCommands() {
	
	}
	
	   protected void initialize() {
	   
	   }

	    // Called repeatedly when this Command is scheduled to run
	    protected  void execute() {	
	    	double x = Robot.oi.driverPad.getLeftX();
	    	double y = Robot.oi.driverPad.getLeftY();
	    	double rotation = Robot.oi.driverPad.getRightX()/2;
	    	double gyro = 0;
	    	Robot.drivetrain.mecanumDrive_Cartesian(x, y, rotation, gyro);
	  }

	    // Make this return true when this Command no longer needs to run execute()
	    protected boolean isFinished() {
	        return true;
	    }

	    // Called once after isFinished returns true
	    protected void end() {
	    }

	    // Called when another command which requires one or more of the same
	    // subsystems is scheduled to run
	    protected void interrupted() {
	    }
}