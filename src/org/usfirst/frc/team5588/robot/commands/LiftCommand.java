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

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	/*double leftTrigRead = 0;
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
    	
    	leftTrigRead = Robot.oi.manipulatorJoystick.getRawAxis(2);
    	rightTrigRead = Robot.oi.manipulatorJoystick.getRawAxis(3);
    	//position = RobotMap.sensor.getQuadraturePosition();
    	System.out.println("Position is reading " + position);
    	//Robot.lift.setPower(readfSpeed);
    	
    	//if(readfSpeed >= 0.2)
    	//{
    	//	Robot.lift.setPower(.4);
    	//}
    	//else if(readfSpeed <-.2)
    	//{
    	//	Robot.lift.setPower(-.4);
    	//}
    	//else if(input == 1)
    	//{
    	//	RobotMap.raisingMotor.set(ControlMode.PercentOutput, 0.4);
    
    	//}
    	
    	
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
    	
    	
    	
    }
    
    private double deadzone(double in){
    	if(Math.abs(in)<0.1)
    		return 0.0;
    	else if(Math.abs(in)>.8)
    		return .8;
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
    }*/
}
