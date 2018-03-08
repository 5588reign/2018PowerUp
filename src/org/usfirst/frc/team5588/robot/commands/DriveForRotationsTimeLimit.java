package org.usfirst.frc.team5588.robot.commands;

import org.usfirst.frc.team5588.robot.RobotMap;
import org.usfirst.frc.team5588.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForRotationsTimeLimit extends Command {

	private double leftSpeed;
	private double rightSpeed;

	private double leftDistanceTraveled;
	private double rightDistanceTraveled;
	private double speed;
	
    public DriveForRotationsTimeLimit(double oneSpeed, double endTime) {
      
    	super(endTime);
    	requires(Drive.getInstance());
        speed = oneSpeed;
        this.leftSpeed = oneSpeed;
        this.rightSpeed = -1 * oneSpeed;
        // distance per pulse = PI * wheel diameter in inches / pulse per revolution * fudge factor;
        //change this
        //for zelda's fudge factor:
        final double distancePerPulse = (Math.PI * 5.90625)/ 256 * 1;  //converts pulses to inches
        //for peach's fudge factor:
        //final double distancePerPulse = (Math.PI * 5.90625)/ 256 * .984;
    	RobotMap.rightEncoder.setDistancePerPulse(distancePerPulse);
    	RobotMap.leftEncoder.setDistancePerPulse(distancePerPulse);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.leftEncoder.reset();
    	RobotMap.rightEncoder.reset();
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//this is encoders correcting themselves! Its confusing, use trial and error
    	double correctingRight = 0.0;
    	double correctingLeft = 0.0;
    	
    	leftDistanceTraveled = -1.0 * RobotMap.leftEncoder.getDistance();
    	rightDistanceTraveled = RobotMap.rightEncoder.getDistance();
    	
    	//for peach's right distance:
    	//rightDistanceTraveled = -1.0 * RobotMap.rightEncoder.getDistance();
    	
    	
    	//change
    	if(leftDistanceTraveled - rightDistanceTraveled > 0.05)
    		//zelda's correcting right:
    		correctingRight = -0.3;
    		//peach's correcting right:
    		//correctingRight = -.01;
    	//change
    	if(rightDistanceTraveled - leftDistanceTraveled > 0.05)
    		//zelda's correcting left:
    		correctingLeft = 0.1;
    		//peach's correcting left: 
    		//correctingLeft = .1;
    	
    	Drive.getInstance().setSpeed(this.leftSpeed + correctingLeft, this.rightSpeed + correctingRight); 
    	
    	//Use this to TEST if your encoder correcting is working properly
    	//System.out.println("The right encoder is at " + rightDistanceTraveled);
    	//System.out.println("The left encoder is at " + leftDistanceTraveled);
    	
    	//System.out.println("The encoder counts is " + RobotMap.rightEncoder.get());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	 return isTimedOut();
    	
    }

    // Called once after isFinished returns true
    protected void end() {
    	Drive.getInstance().stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
