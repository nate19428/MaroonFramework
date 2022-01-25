package com.team766.frc2020.procedures;

import com.team766.framework.Procedure;
import com.team766.framework.Scheduler;
import com.team766.frc2020.Robot;
import com.team766.hal.MyRobot;
import com.team766.hal.RobotProvider;
import com.team766.hal.mock.TestRobotProvider;
import com.team766.EntryPoint;
import com.team766.config.ConfigFileReader;
import com.team766.framework.Context;
import com.team766.logging.Category;

public class LimelightTest extends Procedure{
	public LimelightTest(){
		loggerCategory = Category.AUTONOMOUS; //Delcare here since we aren't creating it, just changing its value
	}

	public void run(Context context){ //Contexts allow procedures to run at the same time, each under a different context (2 contexts in one function useless as it goes in the function order)
		context.takeOwnership(Robot.limelight);
		log(""+Robot.limelight.distanceFromTarget());
		context.waitForSeconds(1);
	}



	// Code for testing locally

	public static void main(String[] args) throws Exception {
		ConfigFileReader.instance = new ConfigFileReader("simConfig.txt");
		RobotProvider.instance = new TestRobotProvider();
		
		Scheduler.getInstance().reset();
		
		MyRobot robot = EntryPoint.createRobot();
			
		robot.robotInit();
		
		robot.autonomousInit();

		while (true) {
			robot.autonomousPeriodic();
			Scheduler.getInstance().run();
		}
	}
}
