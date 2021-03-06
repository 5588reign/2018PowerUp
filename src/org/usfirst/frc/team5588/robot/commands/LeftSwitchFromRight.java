package org.usfirst.frc.team5588.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftSwitchFromRight extends CommandGroup {

    public LeftSwitchFromRight() {
    	/*addSequential(new DriveForRotations(0.5, 246));
    	addSequential(new TurnByGyro(0.15, -90));
    	addSequential(new DriveForRotations(0.5, 219.06));
    	addSequential(new TurnByGyro(0.15, -90));
    	addSequential(new DriveForRotations(0.5, 74));
    	addSequential(new TurnByGyro(0.15, -90));
    	addSequential(new DriveForRotations(0.5, 38));*/ 
    	
    	addSequential(new DriveForRotations(0.3, 4)); //change if it goes too far or too little
    	addSequential(new TurnByGyro(0.2, -90));
    	addSequential(new DriveForRotations(0.3, 258.56));
    	addSequential(new ArmAutoOpen(-.7));
    	addSequential(new TurnByGyro(0.2, 90));
    	addSequential(new DriveForRotations(.3, 90.25));
    	addSequential(new TurnByGyro(0.2, 90));
    	addSequential(new LiftByTime(2));
    	addSequential(new DriveForRotations(.3, 4)); //fix num
    	addSequential(new ArmAutoOpen(.5));
    }
}

//Add Commands in LeftSwitchFromRight():
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
