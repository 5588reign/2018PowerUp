package org.usfirst.frc.team5588.robot.commands;

import org.usfirst.frc.team5588.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Scale2 extends CommandGroup {
	//put the robot with the side bumper lines up with the exchange zone
	
	/*Robot robot = Robot.getInstance();
	String gameData = robot.getGameString();

    public Scale2() {
    	
    	if(gameData.charAt(1) == 'L')
    	{
    		addSequential(new LeftScaleFromCenter());
    	}
    	else
    	{
    		addSequential(new RightScaleFromCenter());
    	}
        
    }*/
}

//Add Commands in public Scale2():
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
