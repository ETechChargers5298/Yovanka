package org.usfirst.frc.team5298.robot.commands.autonomous;

import org.usfirst.frc.team5298.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;


public class AutoDrive extends Command {
	
	public double startTime;
	public double maxTime;
	public double motion;
	private boolean finished;
	
	public AutoDrive(double time, double speed) {
		requires(Robot.drivetrain);
		maxTime = time;
		motion = speed*0.70;
		}
	
	public void initialize() {
		//DriveTrain.gyro.reset();
		startTime = Timer.getFPGATimestamp();
	}
	// || is "or"
	
	public void execute() {
    	Robot.drivetrain.move(motion)
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		if (Timer.getFPGATimestamp() - startTime >= maxTime) {
			finished = true;
		}
		return finished;
	}

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }	
}