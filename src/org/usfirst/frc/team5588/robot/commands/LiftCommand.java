package org.usfirst.frc.team5588.robot.commands;

import org.usfirst.frc.team5588.robot.Robot;
import org.usfirst.frc.team5588.robot.subsystems.LiftingMachine;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftCommand extends Command {
	
	double leftTrigRead = 0;
	double rightTrigRead = 0;
	int readPOV = -1;

    public LiftCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(LiftingMachine.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("starting LiftCommand");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	leftTrigRead = Robot.oi.manipulatorJoystick.getRawAxis(2);
    	rightTrigRead = Robot.oi.manipulatorJoystick.getRawAxis(3);
    	readPOV = Robot.oi.manipulatorJoystick.getPOV(0);
    	
    	if(leftTrigRead >= .9)
    	{
    		//DO STUFF (move the lift to 4 feet)
    		System.out.println("move the lift to 4 feet");
    	}
    	if(rightTrigRead >= -.9)
    	{
    		//DO STUFF (move the lift to 6 feet)
    		System.out.println("move the lift to 6 feet");
    	}
    	if(readPOV >= 315 || readPOV <= 45)
    	{
    		//DO STUFF (moving up 6 inches with the talon srx motor)
    		System.out.println("moving up 6 inches with the talon srx motor");
    	}
    	if(readPOV >= 135 && readPOV <= 225)
    	{
    		//DO STUFF (moving down 6 inches with the talon srx motor)
    		System.out.println("moving down 6 inches with the talon srx motor");
    	}
    	
    	
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
