package com.team766.frc2020.procedures;

public class Launch {
	
	public void run(){
		Robot.launcher.setPusher(true);
		context.wait(0.25);
		Robot.launcher.setPusher(false);
	}
}