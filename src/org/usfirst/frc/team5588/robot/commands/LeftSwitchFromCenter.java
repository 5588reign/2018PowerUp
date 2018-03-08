package org.usfirst.frc.team5588.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftSwitchFromCenter extends CommandGroup {

    public LeftSwitchFromCenter() {
    	addSequential(new DriveForRotations(0.35, 10));
    	addSequential(new TurnByGyro(.2, -71.4614));
    	addSequential(new DriveForRotations(0.35, 67));
    	addSequential(new TurnByGyro(.2, 71.4614));
    	addSequential(new LiftByTime(2));
    	addSequential(new DriveForRotations(0.35, 58));
    	addSequential(new ArmAutoOpen());
    	//addSequential(new DriveForRotations(.1, 13));
    	
    	//addSequential(new DriveForRotations(0.3, 48));
    	/*addSequential(new DriveForRotations(0.5, 43.75));
    	addSequential(new TurnByGyro(0.15, -90));
    	addSequential(new DriveForRotations(0.5, 22.25));
    	addSequential(new TurnByGyro(0.15, 90));*/
    	
    	//move up arm up to switch height
    	//addSequential(new DriveForRotations(0.2, 30));
    	//pneumatics drop
    	
    	
    }
}

//Add Commands in LeftSwitchFromCenter():
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
