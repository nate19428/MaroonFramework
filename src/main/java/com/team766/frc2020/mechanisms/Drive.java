package com.team766.frc2020.mechanisms;

import com.team766.framework.Mechanism;
import com.team766.hal.RobotProvider;
import com.team766.hal.SpeedController;

public class Drive extends Mechanism {
	private SpeedController m_leftMotor; //Java runs through the contstructor and all the variables not in functions
	private SpeedController m_rightMotor;

	public Drive() {
		m_leftMotor = RobotProvider.instance.getMotor("drive.leftMotor");
		m_rightMotor = RobotProvider.instance.getMotor("drive.rightMotor");
	}
	public void setDrivePower(double leftPower, double rightPower){
		checkContextOwnership(); // makes sure it takes over 
		m_leftMotor.set(leftPower);
		m_rightMotor.set(rightPower);
	}
	public void setArcadeDrivePower(double forward, double turn){
		double leftMotorPower = forward + turn;
		double rightMotorPower = forward - turn;
		setDrivePower(leftMotorPower, rightMotorPower);
	}
}