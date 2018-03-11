package org.usfirst.frc.team5588.robot.commands;

import org.usfirst.frc.team5588.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftSwitchDominant1 extends CommandGroup {

    public LeftSwitchDominant1() {
        
    }
    @Override
    protected void initialize()
    {
    	String gameData = Robot.getGameString();
    	if(!gameData.equals("") && gameData.charAt(0) == 'L')
    	{
    		new LeftSwitchFromLeft().start();
    		
    	}
    	else if(!gameData.equals("") && gameData.charAt(1) == 'L')
    	{
    		new LeftScaleFromLeft().start();
    		
    	}
    	else
    	{
    		new Baseline().start();
    	
    	}
    }
}
