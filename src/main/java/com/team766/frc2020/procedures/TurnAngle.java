package com.team766.frc2020.procedures;

import com.team766.framework.Procedure;
import com.team766.frc2020.Robot;
import com.team766.framework.Context;

public class TurnAngle extends Procedure{
	public void run(Context context){
		Robot.drive.resetGyro();
		Robot.drive.setDrivePower(0.25,0);
		while (Robot.drive.getGyroAngle()>=-90){
			context.yield();
		}
		Robot.drive.setDrivePower(0,0);
	}
}