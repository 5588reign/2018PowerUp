package org.usfirst.frc.team5588.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightSwitchFromLeft extends CommandGroup {

    public RightSwitchFromLeft() {
    	/*addSequential(new DriveForRotations(1, 211.75));
    	addSequential(new TurnByGyro(0.2, 91));
    	addSequential(new DriveForRotations(1, 219.06));
    	addSequential(new TurnByGyro(0.2, 91));
    	addSequential(new DriveForRotations(1, 74));
    	addSequential(new TurnByGyro(0.2, 91));
    	addSequential(new DriveForRotations(1, 8)); //fix num*/
    	
    	addSequential(new DriveForRotations(0.3, 4)); //change if it goes too far or too little
    	addSequential(new TurnByGyro(0.2, 90));
    	addSequential(new DriveForRotations(0.3, 258.56));
    	addSequential(new TurnByGyro(0.2, -90));
    	addSequential(new DriveForRotations(.3, 90.25));
    	addSequential(new TurnByGyro(0.2, -90));
    	addSequential(new DriveForRotations(.3, 4)); //fix num
    	
    	
        
    }
}

//Add Commands in public RightSwitchFromLeft():
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
