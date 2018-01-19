/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5588.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static SpeedController driveLeftDrive;
    public static SpeedController driveRightDrive;
    public static SpeedController climberMotor;
    public static Encoder leftEncoder;
    public static Encoder rightEncoder;
    public static AnalogGyro gyro;
    
    //public static AnalogGyro gyroscope = new AnalogGyro(0);
    //public static final int CAMERA_FORWARDS = 1;


    public static void init() {
        
        driveLeftDrive = new Victor(2);
        
        driveRightDrive = new Victor(0);
        
        //When using the competition bot (Victoria), use the talon climber motor.
        climberMotor = new Talon(4);
        
        //When using the backup bot (Feodora), use the victor climber motor.
        //climberMotor = new Victor(4);
        
        leftEncoder = new Encoder(2, 3);
        
        rightEncoder = new Encoder(0,1);
        
        gyro = new AnalogGyro(1);
        
        
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
    }
}