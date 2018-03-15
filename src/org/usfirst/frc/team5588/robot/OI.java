/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5588.robot;

import org.usfirst.frc.team5588.robot.commands.DriveForRotations;
import org.usfirst.frc.team5588.robot.commands.LiftCommand;
import org.usfirst.frc.team5588.robot.commands.LiftToHeight;
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
    //public JoystickButton switchHeight;
    //public Trigger scale4;
    //public Trigger scale6;
    //public JoystickButton backDown;
    //public JoystickButton openCloseBox;
    //public JoystickButton unrollRamp;
    //public JoystickButton liftRamp;
    public JoystickButton testTalon;

    public OI() {
        manipulatorJoystick = new XboxController(1);
        driverJoystick = new Joystick(0);
        //switchHeight = new JoystickButton(manipulatorJoystick, 2);
        //scale4 = new 
        //scale6 = new Trigger(manipulatorJoystick, 12);
        //backDown = new JoystickButton(manipulatorJoystick, 1);
        //openCloseBox = new JoystickButton(manipulatorJoystick, 3);
        //closeBox = new JoystickButton(manipulatorJoystick, 4);
        //unrollRamp = new JoystickButton(manipulatorJoystick, 8);
        //liftRamp = new JoystickButton(manipulatorJoystick, 6);
        testTalon = new JoystickButton(driverJoystick, 2);
        
        //switchHeight.whenPressed(new LiftToHeight(400));
        //scale4.whenPressed(new DriveForRotations(0.1, 10));
        //scale6.whenPressed(new DriveForRotations(0.1, 15));
        //backDown.whenPressed(new DriveForRotations(0.2, 4));
        //openCloseBox.whenPressed(new PneumaticControl(2));
        //if(driverJoystick.getRawButton(5))
        //{
        //unrollRamp.whenPressed(new PneumaticControl(4));
    	//}
        //liftRamp.whenPressed(new PneumaticControl(0));
        //01 - ramp
        //23 - arms 
        //45 - pin 
        //67 - release ramp 
        
        testTalon.whileHeld(new LiftCommand());
       
        
       
        
        
    } 

    public Joystick getDriverJoystick() {
        return driverJoystick;
    }

    public XboxController getManipulatorJoystick() {
        return manipulatorJoystick;
    }
}

	