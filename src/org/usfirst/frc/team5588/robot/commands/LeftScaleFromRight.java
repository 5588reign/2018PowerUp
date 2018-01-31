package org.usfirst.frc.team5588.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftScaleFromRight extends CommandGroup {

    public LeftScaleFromRight() {
    	addSequential(new DriveForRotations(0.5, 246));
        addSequential(new TurnByGyro(0.15, -90));
        addSequential(new DriveForRotations(0.5, 274.31));
        addSequential(new TurnByGyro(0.15, 90));
        addSequential(new DriveForRotations(0.5, 77.69));
        addSequential(new TurnByGyro(0.15, 90));
        addSequential(new DriveForRotations(0.5, 51.57));
        
    }
}

//Add Commands in public LeftScaleFromRight():
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
