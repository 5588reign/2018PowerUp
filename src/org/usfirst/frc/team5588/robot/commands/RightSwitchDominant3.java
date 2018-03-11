package org.usfirst.frc.team5588.robot.commands;

import org.usfirst.frc.team5588.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightSwitchDominant3 extends CommandGroup {

    public RightSwitchDominant3() {
        
    }
    
    @Override 
    protected void initialize() 
    {
    	String gameData = Robot.getGameString();
    	if(!gameData.equals("") && gameData.charAt(0) == 'R')
    	{
    		new RightSwitchFromRight().start();
    	}
    	else if(!gameData.equals("") && gameData.charAt(1) == 'R')
    	{
    		new RightScaleFromRight().start();
    	}
    	else
    	{
    		new Baseline().start();
    	}
    }
}
