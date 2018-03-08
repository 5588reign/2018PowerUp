package org.usfirst.frc.team5588.robot.subsystems;

import org.usfirst.frc.team5588.robot.RobotMap;
import org.usfirst.frc.team5588.robot.commands.ClimbCommand;


import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private final WPI_VictorSPX climber = RobotMap.climbMotor;
	
	public void setSpeed(double speed){
		climber.set(speed);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ClimbCommand());
    }
    
    private static Climber instance = new Climber();
    
    public static Climber getInstance()
    {
    	return instance;
    }
}

