package org.usfirst.frc.team5588.robot.subsystems;

import org.usfirst.frc.team5588.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gyroscope extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void calibrate(){
		RobotMap.gyro.calibrate();
	}
	
	public double getAngle()
	{
		return RobotMap.gyro.getAngle();
	}
	
	public void reset()
	{
		RobotMap.gyro.reset();
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

