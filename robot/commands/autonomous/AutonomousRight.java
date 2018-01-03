package org.usfirst.frc.team5298.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousRight extends CommandGroup {
	
	public AutonomousRight() {
		addSequential(new AutoDrive(3, -1));
		addSequential(new Wait(10));
	}

}
