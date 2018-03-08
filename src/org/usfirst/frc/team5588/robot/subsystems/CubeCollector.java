package org.usfirst.frc.team5588.robot.subsystems;

import org.usfirst.frc.team5588.robot.RobotMap;
import org.usfirst.frc.team5588.robot.commands.ArmControl;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CubeCollector extends Subsystem {

	private final WPI_VictorSPX leftArm = RobotMap.armLeft;
	private final WPI_VictorSPX rightArm = RobotMap.armRight;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void setSpeed(double speed)
	{
		leftArm.set(speed);
		rightArm.set(ControlMode.Follower, leftArm.getDeviceID());
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new ArmControl());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    private static CubeCollector instance = new CubeCollector();
    
    public static CubeCollector getInstance()
    {
    	return instance;
    }
}

