package org.usfirst.frc.team1984.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DigitalInput;
/**
 * 
 * @author matt
 *
 */
public class Intake {
	private final int SPARK_PORT = 4;
	private final int SWITCHY_PORT = 0;
	private Spark intakeSpark;
	private DigitalInput switchy;
	private boolean triggered;
	private boolean readyToFire = false;
	/**
	 * @param intakeMotor
	 * @param limit
	 */
	public Intake() {
		switchy     = new DigitalInput(SWITCHY_PORT);
    	intakeSpark = new Spark(SPARK_PORT);
	}
	/**
	 * @return triggered the current state of the limit switch.
	 */
	public boolean isTriggered() {
		triggered = !switchy.get();
		return triggered;
	}
	/**
	 * Sets speed of intake motor.
	 * @param speed  Value of intake motor, from -1.0 to 1.0.
	 */
	public void setIntakeMotor(double speed) {
		intakeSpark.set(speed);
	}
	/**
	 * @param readyToFire the readyToFire to set
	 */
	public void setReadyToFire(boolean readyToFire) {
		this.readyToFire = readyToFire;
	}
	/**
	 * Initiates the process to intake a ball. 
	 * <p>
	 * Use in conjunction with isReadyToFire() to control pickup in main loop.
	 */
	public void collect() {
		if(this.isTriggered()){
			this.setIntakeMotor(0);
			readyToFire = true;
		} else {
			this.setIntakeMotor(1);
			readyToFire = false;
		}
	}
	/**
	 * @return readyToFire whether the ball is ready to be fired.
	 */
	public boolean isReadyToFire() {
		return readyToFire;
	}



}
