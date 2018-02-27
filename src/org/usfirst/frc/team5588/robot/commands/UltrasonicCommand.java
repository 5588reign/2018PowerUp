package org.usfirst.frc.team5588.robot.commands;

import org.usfirst.frc.team5588.robot.RobotMap;
import org.usfirst.frc.team5588.robot.subsystems.Drive;
//import org.usfirst.frc.team5588.robot.subsystems.UltrasonicSensor;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UltrasonicCommand extends Command {

	
	AnalogInput input = RobotMap.ai;
	double distance = 100;
	double prevDist = 100;
	double inches;
	double volts;
	private double leftSpeed;
	private double rightSpeed;
	private double leftDistanceTraveled;
	private double rightDistanceTraveled;
	

    public UltrasonicCommand(double oneSpeed, double i) {
    	//requires(UltrasonicSensor.getInstance());    	
    	requires(Drive.getInstance());
        
    	inches = i;
        this.leftSpeed = oneSpeed;
        this.rightSpeed = -1 * oneSpeed;
        // distance per pulse = PI * wheel diameter in inches / pulse per revolution * fudge factor;
        //change this
        final double distancePerPulse = (Math.PI * 5.85)/ 265 * 1;  //converts pulses to inches
    	RobotMap.rightEncoder.setDistancePerPulse(distancePerPulse);
    	RobotMap.leftEncoder.setDistancePerPulse(distancePerPulse);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.leftEncoder.reset();
    	RobotMap.rightEncoder.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	prevDist = distance;
    	volts = input.getVoltage();
    	distance = volts * 40.2969077;
    	System.out.println("Current distance: " + distance + "\nPrevious Distance: " + prevDist);
    	
    	double correctingRight = 0.0;
    	double correctingLeft = 0.0;
    	
    	leftDistanceTraveled = -1.0 * RobotMap.leftEncoder.getDistance();
    	rightDistanceTraveled = RobotMap.rightEncoder.getDistance();
    	
    	if(leftDistanceTraveled - rightDistanceTraveled > 0.05)
    		correctingRight = -0.15;
    	//change
    	if(rightDistanceTraveled - leftDistanceTraveled > 0.05)
    		correctingLeft = 0.10;
    	
    	Drive.getInstance().setSpeed(this.leftSpeed + correctingLeft, this.rightSpeed + correctingRight); 
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return(distance <= inches && prevDist <= inches && distance > 25);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Drive.getInstance().stop();
    	System.out.println("Ultrasonic command has stopped");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
