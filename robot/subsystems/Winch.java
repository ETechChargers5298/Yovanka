package org.usfirst.frc.team5298.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Winch extends Subsystem {
	
	private Talon Yamany;
	private Talon Yovanka;
	
	public Winch() {
		//EASTER EGGS :DDDDD
		Yamany = new Talon(6);
		Yovanka = new Talon(7);
		
		// Motor Saftey
	    Yamany.setSafetyEnabled(false);
	    Yovanka.setSafetyEnabled(false);
	   
	    //Motor Saftey Expiration
	    Yamany.setExpiration(1);
	    Yovanka.setExpiration(1);
	 }
	
	public void Ascending(double speed) {
		Yamany.set(speed);
		Yovanka.set(-speed);
	}
	
	public void Descending(double speed) {
		Yamany.set(-speed);
		Yovanka.set(speed);
	}
	
	public void End(double speed) {
		Yamany.set(speed);
		Yovanka.set(speed);
	}

	protected void initDefaultCommand() {
		
		// TODO Auto-generated method stub
	}
}