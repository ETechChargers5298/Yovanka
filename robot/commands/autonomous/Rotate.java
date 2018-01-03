package org.usfirst.frc.team5298.robot.commands.autonomous;

import org.usfirst.frc.team5298.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class Rotate extends Command {
	
	public double desiredAngle;
	private boolean finished;
	public boolean complete = false;
	
	public Rotate(double angle){
		//requires(Robot.drivetrain);
		desiredAngle = angle;
	}
	
	public void initialize(){
		complete = Robot.drivetrain.rotate(desiredAngle);
	}
	
	public void execute(){
		Robot.drivetrain.rotate(desiredAngle);
	}
	
	@Override
	protected boolean isFinished(){
		// TODO Auto-generated method stub
		if(complete = true){
			finished = true;
		}
		
		else if(complete = false){
			finished = false;
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