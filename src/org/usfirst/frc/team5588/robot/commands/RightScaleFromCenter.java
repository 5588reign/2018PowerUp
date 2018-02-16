package org.usfirst.frc.team5588.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightScaleFromCenter extends CommandGroup {

    public RightScaleFromCenter() {
    	addSequential(new DriveForRotations(0.2,40));
    	addSequential(new TurnByGyro(0.2, 90));
    	addSequential(new DriveForRotations(0.2, 130.44));
    	addSequential(new TurnByGyro(0.2, -90));
    	addSequential(new DriveForRotations(0.2, 221));
    	addSequential(new TurnByGyro(0.2, -90));
    	addSequential(new DriveForRotations(0.2, 60));
    	addSequential(new TurnByGyro(0.2, 90));
    	addSequential(new UltrasonicCommand(0.2, 30));
    }
}

// Add Commands in public RightScaleFromCenter():
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