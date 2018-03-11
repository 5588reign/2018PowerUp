package org.usfirst.frc.team5588.robot.commands;

import org.usfirst.frc.team5588.robot.Robot;
import org.usfirst.frc.team5588.robot.subsystems.CubeCollector;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmControl extends Command {

    public ArmControl() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(CubeCollector.getInstance());
    	requires(Robot.cubeyCollector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.oi.manipulatorJoystick.getXButton())
    	{
    		Robot.cubeyCollector.setSpeed(-1);
    	}
    	else if(Robot.oi.manipulatorJoystick.getYButton())
    	{
    		Robot.cubeyCollector.setSpeed(.5);
    	}
    	else
    	{
    		Robot.cubeyCollector.setSpeed(0);
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
