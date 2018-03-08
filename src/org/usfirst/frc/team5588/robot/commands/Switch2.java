package org.usfirst.frc.team5588.robot.commands;

import org.usfirst.frc.team5588.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Switch2 extends CommandGroup {
	
    public Switch2() {
    	
    	
       
    }
    @Override
    protected void initialize()
    {
    	String gameData = Robot.getGameString();
    	if(!gameData.equals("") && gameData.substring(0,1).equalsIgnoreCase("L"))
    	{
    		new LeftSwitchFromCenter().start();
    	}
    	else if(!gameData.equals("") && gameData.substring(0,1).equalsIgnoreCase("R"))
    	{
    		new RightSwitchFromCenter().start();
    	}
    	else
    	{
    		new GoLeftSwitchNoDrop().start();
    	}
    }
}

//Add Commands in public Switch2():
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
