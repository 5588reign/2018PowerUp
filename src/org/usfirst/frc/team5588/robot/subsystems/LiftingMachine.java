package org.usfirst.frc.team5588.robot.subsystems;

import org.usfirst.frc.team5588.robot.RobotMap;
import org.usfirst.frc.team5588.robot.commands.LiftCommand;

import com.ctre.phoenix.ParamEnum;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LiftingMachine extends Subsystem {

	private final TalonSRX lift = RobotMap.raisingMotor;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private LiftingMachine(){
		lift.getDeviceID();
		lift.setInverted(true); 
		//if it spins the wrong way change this to true 
    	lift.setSensorPhase(false); 
    	lift.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
    	
    	
    	
    	//lift.setSelectedSensorPosition(0, 0, 0);
    
    	lift.setNeutralMode(NeutralMode.Brake);
    	lift.selectProfileSlot(0, 0);
    	
    	//lift.config_kP(0, 3, 0);
    	//lift.config_kI(0, 0.02, 0);
    	//lift.config_kD(0, 30, 0);
    	//lift.config_kF(0, .2481, 0);
    	//lift.config_IntegralZone(0, 50, 0);
    	
    	
    	/*lift.configSetParameter(ParamEnum.eClearPositionOnQuadIdx, 1, 0x00, 0x00, 10);
    	lift.configSetParameter(ParamEnum.eClearPositionOnLimitF, 1, 0x00, 0x00, 10);
    	lift.configSetParameter(ParamEnum.eClearPositionOnLimitR, 1, 0x00, 0x00, 10);
    	lift.configMotionCruiseVelocity(3092, 0);
    	lift.configMotionAcceleration(3092, 0);*/
	}
	
	
	public void setControlMode(boolean mode, double speed) //true is motionMagic, false is PercentOutput
	{
		if(mode)
		{
			//lift.set(ControlMode.MotionMagic, speed);
		}
		else
		{
			lift.set(ControlMode.PercentOutput, speed);
		}
	}
	
	
	public double getCounts()
	{
		return lift.getSelectedSensorPosition(0);
		//return lift.getSensorCollection().getQuadraturePosition();
	}
	public void resetZero()
	{
		//lift.setSelectedSensorPosition(0,0, 0);
	}

	public void set(ControlMode m, double speed)
	{
		lift.set(ControlMode.PercentOutput, speed);
	}
	
	public void printRiseToRise()
	{
		System.out.println("Rise to rise: " + lift.getSensorCollection().getPulseWidthRiseToRiseUs());
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

