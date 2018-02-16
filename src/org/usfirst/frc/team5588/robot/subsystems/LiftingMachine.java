package org.usfirst.frc.team5588.robot.subsystems;

import org.usfirst.frc.team5588.robot.RobotMap;
import org.usfirst.frc.team5588.robot.commands.LiftCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
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
		//lift.set(ControlMode.Position, lift.getDeviceID());
	}
	public void setInverted()
	{
		//lift.setInverted(true);
	}
	public void setPower(double speed)
	{
		//lift.set(ControlMode.Position, speed);
	}

	private LiftingMachine(){
		RobotMap.raisingMotor.getDeviceID();
		RobotMap.raisingMotor.setInverted(true); 
		//if it spins the wrong way change this to true 
    	RobotMap.raisingMotor.setSensorPhase(false); 
    	RobotMap.raisingMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
    	RobotMap.raisingMotor.setSelectedSensorPosition(0, 0, 0);
    	RobotMap.raisingMotor.setNeutralMode(NeutralMode.Brake);

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

