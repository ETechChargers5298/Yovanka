package org.usfirst.frc.team5298.robot;

import org.usfirst.frc.team5298.robot.commands.ClimbDown;
import org.usfirst.frc.team5298.robot.commands.ClimbStop;
import org.usfirst.frc.team5298.robot.commands.ClimbUp;

import org.usfirst.frc.team5298.robot.commands.getCalibration;
import org.usfirst.frc.team5298.robot.subsystems.Winch;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5298.robot.Gamepad;





/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */	
public class OI {
	
	
	
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joysti ck.
	// You create one by telling it which joystick it's on and which button
    public Gamepad driverPad;
    public Gamepad operatorPad;
     
    public OI() {
    	driverPad = new Gamepad(0);
    	operatorPad = new Gamepad(1);
    	 
    	// Winch Buttons
    	driverPad.getRightTrigger().whileHeld(new ClimbUp());
    	driverPad.getRightTrigger().whenReleased(new ClimbStop());

    	 
    	//Gyro??
    	driverPad.getLeftBumper().whenPressed(new getCalibration());
    	
    	
    	 
    	//Rotate
    	//driverPad.getLeftTrigger().whileHeld(new Rotate(35));
    	//driverPad.getRightTrigger().whileHeld(new Rotate(-35));
    	 
    	
    	 
	// Button button = new JoystickButton(stick, buttonNumber);
	
	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
     }
}