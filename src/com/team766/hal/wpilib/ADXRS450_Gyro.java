package com.team766.hal.wpilib;

import com.team766.hal.GyroReader;

import edu.wpi.first.wpilibj.SPI;

public class ADXRS450_Gyro extends edu.wpi.first.wpilibj.ADXRS450_Gyro implements GyroReader {
	public ADXRS450_Gyro(SPI.Port port) {
		super(port);
	}
}
