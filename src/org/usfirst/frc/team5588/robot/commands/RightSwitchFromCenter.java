package org.usfirst.frc.team5588.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightSwitchFromCenter extends CommandGroup {

    public RightSwitchFromCenter() {
    	
    	addSequential(new DriveForRotations(0.35, 10));
    	addSequential(new TurnByGyro(0.2, 74.4023));
    	addSequential(new DriveForRotations(0.35, 48));
    	addSequential(new ArmAutoOpen(-.7));
    	addSequential(new TurnByGyro(0.2, -74.4023));
    	addSequential(new LiftByTime(2));
    	addSequential(new DriveForRotations(.3, 67));
    	addSequential(new ArmAutoOpen(.5));
    	/*addSequential(new DriveForRotations(0.5, 43.75));
    	addSequential(new TurnByGyro(0.15, 90));
    	addSequential(new DriveForRotations(0.5, 46.25));
    	addSequential(new TurnByGyro(0.15, -90));
    	//addSequential(new UltrasonicCommand(0.2, 30));
    	//move up arm up to switch height
    	addSequential(new DriveForRotations(0.2, 30));
    	//pneumatics drop*/
    }
}

//Add Commands in public RightSwitchFromCenter():
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
