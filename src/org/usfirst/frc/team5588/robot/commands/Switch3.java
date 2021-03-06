package org.usfirst.frc.team5588.robot.commands;

import org.usfirst.frc.team5588.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Switch3 extends CommandGroup {

	
    public Switch3() {
       
    } 
    
    @Override
    protected void initialize()
    {
    	String gameData = Robot.getGameString();
    	if(!gameData.equals("") && gameData.charAt(0) == 'L')
    	{
    		new Baseline().start();
    	} 
    	else if(!gameData.equals(""))
    	{
    		new RightSwitchFromRight().start();;
    	}
    }
}

//Add Commands in public Switch3():
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
