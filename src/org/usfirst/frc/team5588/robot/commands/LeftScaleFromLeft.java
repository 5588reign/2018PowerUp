package org.usfirst.frc.team5588.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftScaleFromLeft extends CommandGroup {

    public LeftScaleFromLeft() {
    	addSequential(new DriveForRotations(0.5, 289.75));
    	addSequential(new TurnByGyro(.2, 90));
    	addSequential(new ArmAutoOpen(-.7));
    	addSequential(new LiftByTime(5));
    	addSequential(new DriveForRotations(0.1, 48));
    	addSequential(new ArmAutoOpen(.5));
    	
    	//addSequential(new DriveForRotations(0.5, 38));
    	//addSequential(new DriveForRotations(.1,10));
        
    }
}

//Add Commands in public LeftScaleFromLeft():
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
