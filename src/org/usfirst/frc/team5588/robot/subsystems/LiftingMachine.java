package org.usfirst.frc.team5588.robot.subsystems;

import org.usfirst.frc.team5588.robot.RobotMap;
import org.usfirst.frc.team5588.robot.commands.LiftCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LiftingMachine extends Subsystem {

	private final TalonSRX lift = RobotMap.raisingMotor;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void setControlMode(double distance)
	{
		lift.set(ControlMode.Position, lift.getDeviceID());
	}
	public void setInverted()
	{
		lift.setInverted(true);
	}
	public void setPower(double speed)
	{
		lift.set(ControlMode.Position, speed);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new LiftCommand());
    }
    
    private static LiftingMachine instance = new LiftingMachine();
    
    public static LiftingMachine getInstance()
    {
    	return instance;
    }
}

