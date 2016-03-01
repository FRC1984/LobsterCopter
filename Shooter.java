package org.usfirst.frc.team1984.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.*;
import edu.wpi.first.wpilibj.Timer;
/**
 * 
 * @author matt
 *
 */
public class Shooter {
	private final int SHTR_CAN_TAL_PORT = 1;
	private CANTalon shooter;
	private int shotSpeed;
	/**
	 * 
	 */
	public Shooter(){
		shotSpeed = 0;
		shooter = new CANTalon(SHTR_CAN_TAL_PORT);
		shooter.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
	}
	/**
	 * 
	 */
	public void shoot(DriveBase base, Intake intake){
		base.stop();
		shooter.set(shotSpeed);
		Timer.delay(2);
		//while !align(); WOOO VISION jk
		intake.setIntakeMotor(1);
		Timer.delay(.5);
		shooter.set(0);
		intake.setIntakeMotor(0);
		intake.setReadyToFire(false);
		
	}
	public void setShotSpeed(int shotSpeed) {
		this.shotSpeed = shotSpeed;
	}
}
