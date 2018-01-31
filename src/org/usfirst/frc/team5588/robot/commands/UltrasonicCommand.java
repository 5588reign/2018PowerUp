package org.usfirst.frc.team5588.robot.commands;

import org.usfirst.frc.team5588.robot.RobotMap;
import org.usfirst.frc.team5588.robot.subsystems.Drive;
import org.usfirst.frc.team5588.robot.subsystems.UltrasonicSensor;

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
	

    public UltrasonicCommand(double i) {
    	requires(UltrasonicSensor.getInstance());
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	inches = i;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	prevDist = distance;
    	volts = input.getVoltage();
    	distance = volts * 40.2969077;
    	System.out.println("Current distance: " + distance + "\nPrevious Distance: " + prevDist);
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
