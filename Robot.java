package org.usfirst.frc.team1984.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 * 
 * @author matt
 *
 */
public class Robot extends IterativeRobot {
		
	private Joystick     controller;
	private DriveBase    base;
	private Intake		 intake;
	private Shooter		 shooter;
	
	ADIS16448_IMU imu;
	
    public void robotInit() {
    	
    	controller  = new Joystick(0);
    	base        = new DriveBase(controller);
    	intake      = new Intake();  
    	shooter     = new Shooter();
    	
    	 while(true){try{imu = new ADIS16448_IMU();break;}catch( Error e){}}
    }

    public void autonomousInit() {

    }

    public void autonomousPeriodic() {

    }
    
    public void teleopPeriodic() {
    	
    	SmartDashboard.putNumber("Gyro", imu.getAngleZ()%360);	
    	shooter.setShotSpeed((int)(SmartDashboard.getNumber("Shot_Speed")));
    		
        base.updateDrive();
        if (base.isReversed() && !intake.isReadyToFire()) {
        	intake.collect();
        } else if (base.isReversed()) {
        	base.setReversed(false);
        } else if (controller.getRawAxis(3) > 0.9){
        	shooter.shoot(base, intake);
        }
    }

    public void testPeriodic() {
    
    }
    
}
