/*----------------------------------------------------------------------------*/

/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5588.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.awt.Image;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

import org.usfirst.frc.team5588.robot.subsystems.*;
import org.usfirst.frc.team5588.robot.commands.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */


public class Robot extends IterativeRobot {
    

	public static String gamedata = 
			
			
			
			"";
	
	Command autonomousCommand;

	public static OI oi;
	public static Drive drive;
	public static Gyroscope gyro;
	public static LiftingMachine lift;
	public static CubeCollector cubeyCollector;
	public static Climber climber;
	SendableChooser<Command> chooser = new SendableChooser<>();
	SendableChooser<Command> fmsfallback = new SendableChooser<>();
	
	public static boolean armPneumaticValue = true;
	//public static boolean rampPneumaticValue = false; 
	//public static double positionOfLiftMachine = -1;

	//int session;
    //Image frame;
    //CameraServer server;
	static UsbCamera targetcam;
    static UsbCamera targetcam2;
    //int imaqError;
    
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		
		RobotMap.init();
        
        drive = Drive.getInstance();
		oi = new OI();
		gyro = Gyroscope.getInstance();
		lift = LiftingMachine.getInstance();
		cubeyCollector = CubeCollector.getInstance();
		climber = Climber.getInstance();
		//positionOfLiftMachine = -lift.getCounts();
		RobotMap.gyro.calibrate();
		
			
		chooser.addDefault("Baseline", new Baseline());
		/*chooser.addDefault("Test left switch from center", new LeftSwitchFromCenter());
		chooser.addDefault("Test right switch from center", new RightSwitchFromCenter());
		chooser.addDefault("Test right switch from right", new RightSwitchFromRight());
		chooser.addDefault("test left sw from left", new LeftSwitchFromLeft());
		chooser.addDefault("Test left from left", new LeftSwitchFromLeft());*/
		//chooser.addObject("Scale1", new Scale1());
		//chooser.addObject("Scale2", new Scale2());
		//chooser.addObject("Scale3", new Scale3());
		chooser.addObject("Switch1", new Switch1());
		chooser.addObject("Switch2", new Switch2());
		chooser.addObject("Switch3", new Switch3());
		//chooser.addObject("Left1", new Left1());
		//chooser.addObject("Right3", new Right3());
		
		fmsfallback.addDefault("do nothing", new InstantCommand(){});
		fmsfallback.addObject("baseline", new Baseline());
		fmsfallback.addObject("left switch no drop", new GoLeftSwitchNoDrop());
		
		//chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto modez", chooser);
		SmartDashboard.putData("fallback", fmsfallback);
		
		//server = CameraServer.getInstance();   
        
        targetcam = CameraServer.getInstance().startAutomaticCapture("camera low", 0); 
        targetcam.setBrightness(1);
       
        
        //currently camera not working
        targetcam2 = CameraServer.getInstance().startAutomaticCapture("camera high", 1);
        targetcam2.setBrightness(1);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		Instant startTime = Instant.now();
		boolean FMSfailure = false;
		DriverStation.reportWarning("fms reads before " + gamedata, false);
		while(gamedata.equals(""))
		{
			if(startTime.until(Instant.now(), ChronoUnit.SECONDS) >=5)
			{
				DriverStation.reportError("did not receive game data from fms", false);
				FMSfailure = true;
				break;
			}
			gamedata = DriverStation.getInstance().getGameSpecificMessage();
		}
		DriverStation.reportWarning("fms reads after " + gamedata, false);
		
		
		
		autonomousCommand = (Command)chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */
    	
    	RobotMap.leftEncoder.reset();
    	RobotMap.rightEncoder.reset();
    	RobotMap.gyro.reset();
    	
    	
		// schedule the autonomous command (example)
		if (autonomousCommand != null) {
			if(FMSfailure && (autonomousCommand instanceof Baseline))
			{
				autonomousCommand.start();
			}
			else if(!FMSfailure)
			{
				autonomousCommand.start();
			}
			else 
			{
				DriverStation.reportError("unable to run selected auto due to fms failure. using fallback", false);
				((Command)fmsfallback.getSelected()).start();;
			}
		}
	}

	public static String getGameString()
	{
		return gamedata;
	}
	
	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();	
		
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}

}
