package org.usfirst.frc.team5588.robot.commands;

import org.usfirst.frc.team5588.robot.Robot;
import org.usfirst.frc.team5588.robot.RobotMap;
import org.usfirst.frc.team5588.robot.subsystems.LiftingMachine;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftCommand extends Command {

	double leftTrigRead = 0;
	double rightTrigRead = 0;
	int readPOV = -1;
	int position = 0;
	int input = 0;
	

    public LiftCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(LiftingMachine.getInstance());
    	//requires(Robot.lift);
    	//input = i;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("starting LiftCommand");
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double readfSpeed = -deadzone(Robot.oi.manipulatorJoystick.getRawAxis(1));
    	Robot.positionOfLiftMachine = -Robot.lift.getCounts();
    	Robot.lift.set(ControlMode.PercentOutput, readfSpeed);
    	//System.out.println("Position is reading " + Robot.positionOfLiftMachine);
    	//Robot.lift.printRiseToRise();
    	//System.out.println(Robot.lift.getCounts());
    	/*
    	leftTrigRead = Robot.oi.manipulatorJoystick.getRawAxis(2);
    	rightTrigRead = Robot.oi.manipulatorJoystick.getRawAxis(3);
    	if(leftTrigRead >= .9)
    	{
    		//DO STUFF (move the lift to 4 feet)
    		System.out.println("move the lift to 4 feet");
    	}
    	else if(rightTrigRead >= .9)
    	{
    		//DO STUFF (move the lift to 6 feet)
    		System.out.println("move the lift to 6 feet");
    	}
    	/*else if(button to 5 lt and rt? necessary?)
    	{
    
    	}
    	else if(Robot.oi.manipulatorJoystick.getBButtonPressed())//button to switch 22.25 inches - button b)
    	{
    		Robot.lift.setControlMode(true, 10000);
    	}
    	else if(Robot.oi.manipulatorJoystick.getAButtonPressed()) //button to ground
    	{
    		//Robot.lift.setControlMode(true, 0);
    		//System.out.println("a is pressed");
    	}
    	
    		
    	
    	
    	

    	if(Robot.oi.manipulatorJoystick.getStartButtonPressed())
    	{
    		//Robot.lift.resetZero();
    	}
    	*/
    	
    }
    
    private double deadzone(double in){
    	if(Math.abs(in)<0.1)
    		return 0.0;
    	else if(in > .8)
    		return .8;
    	else if(in < -.8)
    		return -.8;
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
