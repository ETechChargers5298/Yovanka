package org.usfirst.frc.team5298.robot.commands.autonomous;

//import org.usfirst.frc.team5298.robot.commands.getCalibration;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousMiddle extends CommandGroup {
	
	public AutonomousMiddle() {
		addSequential(new AutoDrive(3, -0.5));
		addSequential(new Wait(10));		
	}
}