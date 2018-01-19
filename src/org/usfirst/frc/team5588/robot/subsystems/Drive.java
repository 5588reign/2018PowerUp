package org.usfirst.frc.team5588.robot.subsystems;


import org.usfirst.frc.team5588.robot.RobotMap;
import org.usfirst.frc.team5588.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {
	
	 private final SpeedController leftDrive = RobotMap.driveLeftDrive;
	 private final SpeedController rightDrive = RobotMap.driveRightDrive;


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	 public void setSpeed(double lSpeed,double rSpeed){
	    	leftDrive.set(lSpeed);
	    	rightDrive.set(rSpeed);
	 }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveCommand());
    }
    
private static Drive instance = new Drive();
    
    public static Drive getInstance()
    {
    	return instance;
    }
    
    public void stop()
    {
    	leftDrive.set(0);
    	rightDrive.set(0);
    }
}

