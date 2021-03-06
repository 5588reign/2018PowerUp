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
	private double lspeed = 0;
	private double rspeed = 0;
	private double endingAngle;
	private double speed = 0; // Used for deadzone calculation and isFinished method
	Gyroscope gyro = Gyroscope.getInstance();
	
    public TurnByGyro(double oneSpeed, double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Gyroscope.getInstance());
    	requires(Drive.getInstance());
   
    
    	speed = oneSpeed;
    	//If you want to go left enter a negative angle value
    	if(angle < 0)
    	{
    		endingAngle = angle;
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
    	System.out.println("gyro is reset to: " + gyro.getAngle());
    }

   
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	readAngle = gyro.getAngle();
    	
    	System.out.println("the gyro is reading " + readAngle);
    	Drive.getInstance().setSpeed(lspeed, rspeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    // choosing dead zone based on speed 
    protected boolean isFinished() {
    	double diff = 1;
    	if(speed == .1)
    	{
    		diff = .5;
    	}
    	else if(speed == .15)
    	{
    		diff = .8;
    	}
    	else if(speed == .2)
    	{
    		diff = 1;
    	}
    	else if(speed == .5)
    	{
    		diff = 5;  //can stop at 1.5, changing this to larger number for accuracy of second catch
    	}
    	boolean done = Math.abs(endingAngle - readAngle) < diff;
    	return done;
    	/*if(speed == .5 && done == true)
    	{
    		speed = .2;
    		lspeed = .2;
    		rspeed = .2;
    	}
    	else if(speed ==.2 && done == true)
    	{
    		speed = .5;
    		lspeed = .5;
    		rspeed = .5;
    		return true;
    	}
    	else
    	{
    		return done;
    	}*/
        
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
