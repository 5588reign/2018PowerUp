package org.usfirst.frc.team5588.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftSwitchFromLeft extends CommandGroup {

    public LeftSwitchFromLeft() {
    	addSequential(new DriveForRotations(0.35,142));
    	addSequential(new TurnByGyro(0.2, 90));
    	addSequential(new ArmAutoOpen(-.7));
    	addSequential(new LiftByTime(2));
    	addSequential(new DriveForRotationsTimeLimit(.2, 3));
    	addSequential(new ArmAutoOpen(.5));
    }
}

//Add Commands in public LeftSwitchFromLeft():
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
