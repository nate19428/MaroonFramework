package com.team766.frc2020.mechanisms;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import com.team766.framework.Mechanism;

public class LimeLight extends Mechanism{
	private NetworkTable table;
	private final double mountAngle = 10;
	private final double mountHeightfromGround = 10;
	private final double targetHeightfromGround = 40;

	public LimeLight(){
		table = NetworkTableInstance.getDefault().getTable("limelight");
	}

	public boolean areTargets(){
		if (table.getEntry("tv").getDouble(0) == 0){
			return false;
		}
		return true;
	}

	public double horizontalOffset(){ //left = neg, right = pos; gives us angle that target is from robot
		return table.getEntry("tx").getDouble(0);
	}

	public double verticalOffset(){ //down = neg, up = pos; gives us angle that target is from robot
		return table.getEntry("ty").getDouble(0);
	}

	public double targetArea(){ //percentage of total area target is
		return table.getEntry("ta").getDouble(0);
	}

	public double rotation(){ //between -90 and 0
		return table.getEntry("ts").getDouble(0);
	}

	public double targetLength(){//in pixels the length of the target
		return table.getEntry("thor").getDouble(0);
	}

	public double targetHeight(){//in pixels the height of the target
		return table.getEntry("tvert").getDouble(0);
	}

	public double distanceFromTarget(){
		double angle = Math.abs(Math.toRadians(mountAngle+verticalOffset()));
		double height = Math.abs(targetHeightfromGround-mountHeightfromGround);
		return height/Math.tan(angle);
	}
}