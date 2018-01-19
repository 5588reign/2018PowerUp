package org.usfirst.frc.team5588.robot.commands;


import org.usfirst.frc.team5588.robot.Robot;
import org.usfirst.frc.team5588.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveCommand extends Command {

    public DriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
        requires(Drive.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//"Squared" driving means that the read from the joystick is squared, making it go really fast, but have fine movements when it is slow
    	double fSpeed;
    	double readfSpeed = deadzone(Robot.oi.driverJoystick.getRawAxis(0));
    	//if the joystick is moving backwards, then the read needs to be squared and * by -1
    	if(readfSpeed >= 0)
    		fSpeed = readfSpeed * readfSpeed;
    	else
    		fSpeed = -1 * (readfSpeed * readfSpeed);
    	
    	
    	double sSpeed = -deadzone(Robot.oi.driverJoystick.getRawAxis(1));
    	double lSpeed = (fSpeed + sSpeed);
    	double rSpeed = (fSpeed - sSpeed);
    	Robot.drive.setSpeed(lSpeed, rSpeed);
    }

    private double deadzone(double in){
    	if(Math.abs(in)<0.1)
    		return 0.0;
    	return in;
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
