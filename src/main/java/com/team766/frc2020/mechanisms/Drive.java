package com.team766.frc2020.mechanisms;

import com.team766.framework.Mechanism;
import com.team766.hal.RobotProvider;
import com.team766.hal.SpeedController;
import com.team766.hal.EncoderReader;
import com.team766.hal.GyroReader;
import com.team766.logging.Category;

public class Drive extends Mechanism {
	private SpeedController m_leftMotor; //Java runs through the contstructor and all the variables not in functions
	private SpeedController m_rightMotor;
	private EncoderReader m_leftEncoder;
	private EncoderReader m_rightEncoder;
	private GyroReader m_gyro;

	public Drive() {
		m_leftMotor = RobotProvider.instance.getMotor("drive.leftMotor");
		m_rightMotor = RobotProvider.instance.getMotor("drive.rightMotor");
		m_leftEncoder = RobotProvider.instance.getEncoder("drive.leftEncoder");
		m_rightEncoder = RobotProvider.instance.getEncoder("drive.rightEncoder");
		m_gyro = RobotProvider.instance.getGyro("drive.gyro");
		loggerCategory = Category.DRIVE;
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
	public double getEncoderDistance(){
		checkContextOwnership();
		log("Left: "+m_leftEncoder.getDistance()+" Right: "+m_rightEncoder.getDistance());
		return((m_leftEncoder.getDistance()+m_rightEncoder.getDistance())/2);
	}
	public void resetEncoders(){
		checkContextOwnership();
		m_leftEncoder.reset();
		m_rightEncoder.reset();
	}
	public double getGyroAngle(){
		checkContextOwnership();
		log("Gryo "+ m_gyro.getAngle());
		return(m_gyro.getAngle());
	}
	public void resetGyro(){
		checkContextOwnership();
		m_gyro.reset();
	}
}