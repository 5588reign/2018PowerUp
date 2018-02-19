package org.usfirst.frc.team5588.robot.commands;

import org.usfirst.frc.team5588.robot.Robot;
import org.usfirst.frc.team5588.robot.subsystems.LiftingMachine;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftToHeight extends Command {

	double height = 0;
	double speed = 0;
    public LiftToHeight(double h) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(LiftingMachine.getInstance());
    	//requires(Robot.lift);
    	
    	
    	height = h;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(height> Robot.positionOfLiftMachine)
    	{
    		speed = 0.5;
    	}
    	else
    	{
    		speed = -0.5;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.positionOfLiftMachine = -Robot.lift.getCounts();
    	System.out.println("Position is reading " + Robot.positionOfLiftMachine);
    	Robot.lift.setPower(speed);
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Math.abs(height-Robot.positionOfLiftMachine)<100)
        {
        	return true;
        }
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	if(height == 0)
    	{
    		Robot.lift.resetZero();
    		Robot.positionOfLiftMachine = 0;
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
