/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5588.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.interfaces.Gyro;

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
    public static ADXRS450_Gyro gyro;
    public static TalonSRX raisingMotor;
    public static DoubleSolenoid unrollRampPneumatic;
    public static DoubleSolenoid liftRampPneumatic;
    
    //public static final int CAMERA_FORWARDS = 1;

    public static void init() {
        
        driveLeftDrive = new Victor(2);
        driveRightDrive = new Victor(0);
        
        leftEncoder = new Encoder(2, 3);
        rightEncoder = new Encoder(0,1);
        
        gyro = new ADXRS450_Gyro();
        
        raisingMotor = new TalonSRX(0);
        
        unrollRampPneumatic = new DoubleSolenoid(0, 1);
        liftRampPneumatic = new DoubleSolenoid(2, 3);
        
    }
}
        
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
   