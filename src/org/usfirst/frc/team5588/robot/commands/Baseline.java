package org.usfirst.frc.team5588.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Baseline extends CommandGroup {

    public Baseline() {
    	//addSequential(new DriveForRotations(.5, 168)); //Should be 168 for distance
    	addSequential(new TurnByGyro(0.5, 90));
    	addSequential(new TurnByGyro(.2, 90));
    	//testing for fudge factor & breaking distance (change speed for calculations needed):
    	//addSequential(new DriveForRotations(.3, 12));
    	//addSequential(new DriveForRotations(.3, 60));
    	//addSequential(new DriveForRotations(.3, 120));
    	//addSequential(new DriveForRotations(.3, 180));
    	//addSequential(new DriveForRotations(.3, 240));
    	
    	//addSequential(new LiftByTime(2));
    	//addSequential(new PneumaticControl(2));
    	
    }
}

//Add Commands in public BaseLine():
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
