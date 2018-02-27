package org.usfirst.frc.team5588.robot.commands;

import org.usfirst.frc.team5588.robot.Robot;
import org.usfirst.frc.team5588.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PneumaticControl extends Command {

	//Value value = DoubleSolenoid.Value.kOff;
	Compressor c;
	DoubleSolenoid.Value reading;
	int port = -1;
	Timer time = new Timer();

    public PneumaticControl(int p) {
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	c = new Compressor(0);
    	//port is the lower of the two port numbers the pneumatic uses in the PCM
    	port = p;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	c.setClosedLoopControl(true);
    	if(port == 0)
    	{
    		if(Robot.rampPneumaticValue)
    		{
    			RobotMap.liftRampPneumatic.set(DoubleSolenoid.Value.kForward);
    		}
    		else
    		{
    			RobotMap.liftRampPneumatic.set(DoubleSolenoid.Value.kReverse);
    		}
    	}
    	else if(port == 2)
    	{
    		if(Robot.armPneumaticValue)
    		{
    			RobotMap.armPneumatic.set(DoubleSolenoid.Value.kForward);
    		}
    		else 
    		{
    			RobotMap.armPneumatic.set(DoubleSolenoid.Value.kReverse);
    		}
    	}
    	else if(port == 4)
    	{
    		RobotMap.pinRelease.set(DoubleSolenoid.Value.kReverse);
    		Timer.delay(1);
    		RobotMap.releaseRamp.set(DoubleSolenoid.Value.kReverse);
    		Timer.delay(2);
    		RobotMap.releaseRamp.set(DoubleSolenoid.Value.kForward);
    		RobotMap.pinRelease.set(DoubleSolenoid.Value.kForward);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return(true);
        
    }

    // Called once after isFinished returns true
    protected void end() {
    	if(port == 0)
    	{
    		if(Robot.rampPneumaticValue)
    		{
    			Robot.rampPneumaticValue = false;
    		}
    		else
    		{
    			Robot.rampPneumaticValue = true;
    		}
    	}
    	else 
    	{
    		if(Robot.armPneumaticValue)
    		{
    			Robot.armPneumaticValue = false;
    		}
    		else 
    		{
    			Robot.armPneumaticValue = true;
    		}
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
