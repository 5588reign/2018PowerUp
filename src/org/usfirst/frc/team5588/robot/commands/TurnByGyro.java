package org.usfirst.frc.team5588.robot.commands;

import org.usfirst.frc.team5588.robot.Robot;
import org.usfirst.frc.team5588.robot.subsystems.Drive;
import org.usfirst.frc.team5588.robot.subsystems.Gyroscope;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnByGyro extends Command 
{
	
	private double readAngle;
	private double lspeed;
	private double rspeed;
	private double endingAngle;
	Gyroscope gyro = Gyroscope.getInstance();
	
    public TurnByGyro(double oneSpeed, double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Gyroscope.getInstance());
    	requires(Drive.getInstance());
   
    	if(angle > 180 && angle < 360)
    	{
    		endingAngle = 360 - angle;
    		lspeed = -oneSpeed;
    		rspeed = -oneSpeed;
    		
    	}
    	else
    	{
    		endingAngle = angle;
    		lspeed = oneSpeed;
    		rspeed = oneSpeed;
    	}
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	gyro.reset();
    	gyro.reset();
    	System.out.println("gyro is reset to: " + gyro.getAngle());
    }

   
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	readAngle = gyro.getAngle();
    	
    	System.out.println("the gyro is reading " + readAngle);
    	Drive.getInstance().setSpeed(lspeed, rspeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return(Math.abs(endingAngle - readAngle)<3);
        
    }

    // Called once after isFinished returns true
    protected void end() {
    	Drive.getInstance().stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Drive.getInstance().stop();
    }
}
