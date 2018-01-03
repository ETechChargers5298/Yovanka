package org.usfirst.frc.team5298.robot;


import org.usfirst.frc.team5298.robot.subsystems.Winch;
import org.usfirst.frc.team5298.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5298.robot.commands.autonomous.AutonomousMiddle;
import org.usfirst.frc.team5298.robot.commands.autonomous.AutonomousRight;
import org.usfirst.frc.team5298.robot.commands.autonomous.AutonomousLeft;

import edu.wpi.first.wpilibj.DriverStation;
//import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	/**
	UsbCamera gearCamera;
	
	
	private static final int IMG_WIDTH = 320;
	private static final int IMG_HEIGHT = 240;
	private static final int FPS = 30;
	*/

	private Command autonomous;
    private SendableChooser<Command> autonomousOverride;
	
	public static OI oi;
	public static Gamepad driverPad;
	public static Winch winch;
	public static DriveTrain drivetrain;

	
	private double autonStartTime;
	
	/**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	
	public void smartDashboardOutputs() {
		SmartDashboard.putNumber("Angle of Gyro", Robot.drivetrain.gyroAngle());
		SmartDashboard.putNumber("Rate of Rotation", Robot.drivetrain.getRotation());
		SmartDashboard.putNumber("Autonomous", (double) station);
	}
	
    public void robotInit() {
		
    	//Gamepad Initialized Here
    	oi = new OI();
		driverPad = new Gamepad(0);
		
		
		//Vision Code Here
		// gearCamera = CameraServer.getInstance().startAutomaticCapture();
		 //gearCamera.setResolution(IMG_WIDTH, IMG_HEIGHT);
		 //gearCamera.setFPS(FPS);
		 
		/* liftCamera = CameraServer.getInstance().startAutomaticCapture();
		 liftCamera.setResolution(IMG_WIDTH, IMG_HEIGHT);
		 liftCamera.setFPS(FPS);
		 */
		 
		//Subsystems Initialized Here
		drivetrain = new DriveTrain();
	    winch = new Winch();
	
	    /*
	    gyro = new ADXRS450_Gyro();
        gyro.reset();
	    */
        autonomousOverride = new SendableChooser<Command>();
	    autonomousOverride.addObject("Right", new AutonomousRight());
	    autonomousOverride.addObject("Left", new AutonomousLeft());
	    autonomousOverride.addObject("Middle", new AutonomousMiddle());		
	    SmartDashboard.putData("Autonomous Command", autonomousOverride);
    }
	    
/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit() {
    	
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	
	

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
    	if((Command) autonomousOverride.getSelected() != null)
			autonomous = (Command) autonomousOverride.getSelected();
		
		else {
			switch(DriverStation.getInstance().getLocation()) {
				case 1:
					autonomous = new AutonomousRight();
					break;
				case 2:
					autonomous = new AutonomousMiddle();
					break;
				case 3:
					autonomous = new AutonomousLeft();
					break;
			}
		}
        
    	autonomous.start();
    	autonStartTime = Timer.getFPGATimestamp();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	Scheduler.getInstance().run();//keep this one if you dont want a spammed error message on driver station.
    	if (Timer.getFPGATimestamp() - autonStartTime >= 15) {
    		autonomous.cancel();
    	}
    }

    public void teleopInit() {
    	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
    	if(autonomous != null)
    		autonomous.cancel();
    } 
    
    public void teleopPeriodic() {
    	Scheduler.getInstance().run();
	    smartDashboardOutputs();
	    
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}