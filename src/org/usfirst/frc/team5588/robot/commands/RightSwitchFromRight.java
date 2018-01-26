package org.usfirst.frc.team5588.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightSwitchFromRight extends CommandGroup {

    public RightSwitchFromRight() {
    	addSequential(new DriveForRotations(0.5,168));
    	addSequential(new TurnByGyro(0.15, -90));
    	//driving to the switch fast at first, then slows down as it nears impact in order to avoid accidental
    	//dislodge of cube
    	addSequential(new DriveForRotations(0.5, 50));
    	addSequential(new DriveForRotations(0.1, 10));
    }
}

//Add Commands in public RightSwitchFromRight():
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
