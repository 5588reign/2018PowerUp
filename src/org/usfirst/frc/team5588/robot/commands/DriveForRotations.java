package org.usfirst.frc.team5588.robot.commands;

import org.usfirst.frc.team5588.robot.RobotMap;
import org.usfirst.frc.team5588.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForRotations extends Command {
	
	private double leftSpeed;
	private double rightSpeed;
	private double distance;
	private double leftDistanceTraveled;
	private double rightDistanceTraveled;

    public DriveForRotations(double oneSpeed, double distance) {
    	
    	requires(Drive.getInstance());
        
        this.leftSpeed = oneSpeed;
        this.rightSpeed = -1 * oneSpeed;
        this.distance = distance;
        // distance per pulse = PI * wheel diameter in inches / pulse per revolution * fudge factor;
        //change this
        final double distancePerPulse = (Math.PI * 5.90625)/ 256 * 1;  //converts pulses to inches
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
    	
    	
    	//change
    	if(leftDistanceTraveled - rightDistanceTraveled > 0.05)
    		correctingRight = -0.1;
    	//change
    	if(rightDistanceTraveled - leftDistanceTraveled > 0.05)
    		correctingLeft = 0.10;
    	
    	Drive.getInstance().setSpeed(this.leftSpeed + correctingLeft, this.rightSpeed + correctingRight); 
    	
    	//Use this to TEST if your encoder correcting is working properly
    	System.out.println("The right encoder is at " + rightDistanceTraveled);
    	System.out.println("The left encoder is at " + leftDistanceTraveled);
    	//System.out.println("The encoder counts is " + RobotMap.rightEncoder.get());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//run this when you want to stop, when your encoder count goes over your distance
        return (leftDistanceTraveled>= distance && rightDistanceTraveled>= distance);
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
