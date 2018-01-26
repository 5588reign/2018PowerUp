package org.usfirst.frc.team5588.robot.subsystems;

import org.usfirst.frc.team5588.robot.RobotMap;
import org.usfirst.frc.team5588.robot.commands.TurnByGyro;

//import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 *
 */
public class Gyroscope extends Subsystem
{

	private final Gyro gyro = RobotMap.gyro;

        // Put methods for controlling this subsystem
    	// here. Call these from Commands.
	public void calibrate()
	{
		gyro.calibrate();
	}
	
	public double getAngle()
	{
		return gyro.getAngle();
	}
	
	public void reset()
	{
		gyro.reset();
	}
    public void initDefaultCommand() 
    {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
private static Gyroscope instance = new Gyroscope();
    
    public static Gyroscope getInstance()
    {
    	return instance;
    }
}

