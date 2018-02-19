/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5588.robot;

import org.usfirst.frc.team5588.robot.commands.DriveForRotations;
import org.usfirst.frc.team5588.robot.commands.LiftCommand;
import org.usfirst.frc.team5588.robot.commands.PneumaticControl;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *This class is the glue that binds the controls on the physical operator 
 *interface to the commands and command groups that allow control of the robot.
 **/
public class OI {
	public Joystick driverJoystick;
    public XboxController manipulatorJoystick;
    public JoystickButton switchHeight;
    public Trigger scale4;
    public Trigger scale6;
    public JoystickButton backDown;
    public JoystickButton openCloseBox;
    public JoystickButton closeBox;
    public JoystickButton unrollRamp;
    public JoystickButton liftRamp;
    public JoystickButton testTalon;

    public OI() {
        manipulatorJoystick = new XboxController(1);
        driverJoystick = new Joystick(0);
        switchHeight = new JoystickButton(manipulatorJoystick, 2);
        //scale4 = new 
        //scale6 = new Trigger(manipulatorJoystick, 12);
        backDown = new JoystickButton(manipulatorJoystick, 1);
        openCloseBox = new JoystickButton(manipulatorJoystick, 3);
        closeBox = new JoystickButton(manipulatorJoystick, 4);
        unrollRamp = new JoystickButton(manipulatorJoystick, 5);
        liftRamp = new JoystickButton(manipulatorJoystick, 6);
        testTalon = new JoystickButton(driverJoystick, 2);
        
        //switchHeight.whenPressed(new LiftCommand());
        //scale4.whenPressed(new DriveForRotations(0.1, 10));
        //scale6.whenPressed(new DriveForRotations(0.1, 15));
        //backDown.whenPressed(new DriveForRotations(0.2, 4));
        //openCloseBox.whenPressed(new PneumaticControl(2));
        //closeBox.whenPressed(new PneumaticControl(DoubleSolenoid.Value.kReverse, 2));
        //unrollRamp.whenPressed(new PneumaticControl(DoubleSolenoid.Value.kForward, 0));
        //liftRamp.whenPressed(new PneumaticControl(0));
        
        //testTalon.whileHeld(new LiftCommand());
       
        
        /*System.out.println("The POV is " + manipulatorJoystick.getPOV(0));
        
        if(manipulatorJoystick.getPOV(0)>= 135 && manipulatorJoystick.getPOV(0) <=225)
        {
        	Scheduler.getInstance().add(new DriveForRotations(-0.1, 4));
        } 
        if(manipulatorJoystick.getPOV(0)>= 315 || manipulatorJoystick.getPOV(0) <=45)
        {
        	Scheduler.getInstance().add(new DriveForRotations(-0.1, 4));
        } 
        if(manipulatorJoystick.getTriggerAxis(Hand.kLeft)>.1)
        {
        	//move up 6
        }*/
        
        
    } 

    public Joystick getDriverJoystick() {
        return driverJoystick;
    }

    public XboxController getManipulatorJoystick() {
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

