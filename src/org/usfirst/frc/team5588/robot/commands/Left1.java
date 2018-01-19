package org.usfirst.frc.team5588.robot.commands;

import org.usfirst.frc.team5588.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Left1 extends CommandGroup {

	
	String gameData = Robot.getGameString();
	
    public Left1() {
    	System.out.println("In left1 gameData is now " + gameData);
    	if(gameData.charAt(1) == 'L')
    	{
    		addSequential(new LeftScaleFromLeft());
    		System.out.println("running left scale from left");
    	}
    	else if(gameData.charAt(0) == 'L')
    	{
    		addSequential(new LeftSwitchFromLeft());
    		System.out.println("running left switch from left");
    	}
    	else
    	{
    		addSequential(new RightSwitchFromLeft());
    		System.out.println("running right switch from left");
    	}
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
