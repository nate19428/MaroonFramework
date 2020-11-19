package com.team766.frc2020.procedures;

import com.team766.framework.Procedure;
import com.team766.frc2020.Robot;
import com.team766.framework.Context;
import com.team766.logging.Category;

public class DriveSquare extends Procedure {
	DriveStraight Drive_Straight = new DriveStraight(); //Can declare here because we are creating this variable
	TurnRight Turn_Right = new TurnRight();
	public DriveSquare(){
		loggerCategory = Category.AUTONOMOUS; //Delcare here since we aren't creating it, just changing its value
	}

	public void run(Context context){ //Contexts allow procedures to run at the same time, each under a different context (2 contexts in one function useless as it goes in the function order)
		for (int i=1;i<5;++i){
		Drive_Straight.run(context);
		log(i+" side complete");
		Turn_Right.run(context);
		log(i+" corner complete");
		}
	}
}