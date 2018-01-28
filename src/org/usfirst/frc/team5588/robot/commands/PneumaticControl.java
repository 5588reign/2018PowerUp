package org.usfirst.frc.team5588.robot.commands;

import org.usfirst.frc.team5588.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PneumaticControl extends Command {
	
	Value value = DoubleSolenoid.Value.kOff;
	Compressor c;
	DoubleSolenoid.Value reading;
	int port = -1;

    public PneumaticControl(DoubleSolenoid.Value v, int p) {
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	value = v;
    	c = new Compressor(0);
    	//port is the lower of the two port numbers the pneumatic uses in the PCM
    	port = p;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	c.setClosedLoopControl(true);
    	if(port == 0)
    	{
    		RobotMap.unrollRampPneumatic.set(value);
    	}
    	else if(port == 2)
    	{
    		RobotMap.liftRampPneumatic.set(value);
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

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
