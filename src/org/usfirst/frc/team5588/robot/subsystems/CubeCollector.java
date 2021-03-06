package org.usfirst.frc.team5588.robot.subsystems;

import org.usfirst.frc.team5588.robot.RobotMap;
import org.usfirst.frc.team5588.robot.commands.ArmControl;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CubeCollector extends Subsystem {

	private final PWMVictorSPX leftArm = RobotMap.armLeft;
	private final PWMVictorSPX rightArm = RobotMap.armRight;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void setSpeed(double lspeed, double rspeed)
	{
		leftArm.set(lspeed);
		rightArm.set(-rspeed);
	}

    public void initDefaultCommand() 
    {
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

