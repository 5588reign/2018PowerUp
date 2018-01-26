/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5588.robot;

import org.usfirst.frc.team5588.robot.commands.DriveForRotations;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *This class is the glue that binds the controls on the physical operator 
 *interface to the commands and command groups that allow control of the robot.
 **/
public class OI {
	public Joystick driverJoystick;
    public Joystick manipulatorJoystick;
    public JoystickButton switchHeight;
    public JoystickButton scale4;
    public JoystickButton scale6;
    public JoystickButton backDown;
    public JoystickButton openBox;
    public JoystickButton closeBox;
    public JoystickButton unrollRamp;
    public JoystickButton liftRamp;

    public OI() {
        manipulatorJoystick = new Joystick(1);
        driverJoystick = new Joystick(0);
        switchHeight = new JoystickButton(manipulatorJoystick, 2);
        //scale4 = new JoystickButton(manipulatorJoystick, 11);
        //scale6 = new JoystickButton(manipulatorJoystick, 12);
        backDown = new JoystickButton(manipulatorJoystick, 1);
        openBox = new JoystickButton(manipulatorJoystick, 3);
        closeBox = new JoystickButton(manipulatorJoystick, 4);
        unrollRamp = new JoystickButton(manipulatorJoystick, 5);
        liftRamp = new JoystickButton(manipulatorJoystick, 6);
        
        switchHeight.whenPressed(new DriveForRotations(0.1, 4));
        //scale4.whenPressed(new DriveForRotations(0.1, 10));
        //scale6.whenPressed(new DriveForRotations(0.1, 15));
        backDown.whenPressed(new DriveForRotations(0.2, 4));
        openBox.whenPressed(new DriveForRotations(0.2, 10));
        closeBox.whenPressed(new DriveForRotations(0.2, 15));
        unrollRamp.whenPressed(new DriveForRotations(0.3, 4));
        liftRamp.whenPressed(new DriveForRotations(0.3, 15));
        
        System.out.println("The POV is " + manipulatorJoystick.getPOV(0));
        
        if(manipulatorJoystick.getPOV(0)>= 135 && manipulatorJoystick.getPOV(0) <=225)
        {
        	
        	Scheduler.getInstance().add(new DriveForRotations(-0.1, 4));
        } 
        
        
        
        
        
    } 

    public Joystick getDriverJoystick() {
        return driverJoystick;
    }

    public Joystick getManipulatorJoystick() {
        return manipulatorJoystick;
    }
}

	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
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

