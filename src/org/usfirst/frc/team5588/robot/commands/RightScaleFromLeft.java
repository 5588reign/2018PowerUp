package org.usfirst.frc.team5588.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightScaleFromLeft extends CommandGroup {

    public RightScaleFromLeft() {
        addSequential(new DriveForRotations(0.5, 211.75));
        addSequential(new TurnByGyro(0.2, 90));
        addSequential(new DriveForRotations(0.5, 240.31));
        addSequential(new TurnByGyro(0.2, -91));
        addSequential(new DriveForRotations(0.5, 64.69));
        addSequential(new TurnByGyro(0.2, -91));
        //addSequential(new DriveForRotations(0.5, 51.57));
        
    }
}

//Add Commands in public RightScaleFromLeft():
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
