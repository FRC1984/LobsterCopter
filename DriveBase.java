package org.usfirst.frc.team1984.robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.*;
/**
 * 
 * @author matt
 * 
 */
public class DriveBase {
	//Set Talon ports
	private int TAL_LEFT1_PORT  = 0;
	private int TAL_LEFT2_PORT  = 1;
	private int TAL_RIGHT1_PORT = 2;
	private int TAL_RIGHT2_PORT = 3;
	//Create Talon objects
	private Talon TAL_LEFT1;
	private Talon TAL_LEFT2;
	private Talon TAL_RIGHT1;
	private Talon TAL_RIGHT2;
	//Controlling Joystick
	private Joystick input;
	//Uses RobotDrive to handle joystick shit
	private RobotDrive base;
	//Handles the switching of direction
	private boolean isReversed = false;
	/**
	 * 
	 * @param input
	 */
	public DriveBase(Joystick input) {
		this.input = input;
		initTalons(TAL_LEFT1_PORT, TAL_LEFT2_PORT, TAL_RIGHT1_PORT, TAL_RIGHT2_PORT);
		base = new RobotDrive(TAL_LEFT1, TAL_LEFT2, TAL_RIGHT1, TAL_RIGHT2);
		base.setInvertedMotor(MotorType.kFrontRight, true);
		base.setInvertedMotor(MotorType.kRearRight, true);
	}
	/**
	 * 
	 * @param l1
	 * @param l2
	 * @param r1
	 * @param r2
	 */
	private void initTalons(int l1, int l2, int r1, int r2) {
		TAL_LEFT1  = new Talon(TAL_LEFT1_PORT);
		TAL_LEFT2  = new Talon(TAL_LEFT2_PORT);
		TAL_RIGHT1 = new Talon(TAL_RIGHT1_PORT);
		TAL_RIGHT2 = new Talon(TAL_RIGHT2_PORT);
	}
	/**
	 * 
	 * @return
	 */
	public boolean isReversed() {
		return isReversed;
	}
	/**
	 * 
	 * @param isReversed
	 */
	public void setReversed(boolean isReversed) {
		this.isReversed = isReversed;
	}
	/**
	 * Handles the reversing function.
	 */
	public void updateDrive() {
		if (isReversed){
			base.arcadeDrive(input.getY(), -input.getX(), true);
		}else {
			base.arcadeDrive(-input.getY(), -input.getX(), true);
		}
	}
	/**
	 * Stops the robot.
	 */
	public void stop() {
		base.arcadeDrive(0, 0, true);
	}
}
