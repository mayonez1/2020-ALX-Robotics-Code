/*----------------------------------------------------------------------------*/

/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */

/* Open Source Software - may be modified and shared by FRC teams. The code   */

/* must be accompanied by the FIRST BSD license file in the root directory of */

/* the project.                                                               */

/*----------------------------------------------------------------------------*/



package frc.robot;



import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.PWMVictorSPX;

import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj.SpeedControllerGroup;

import edu.wpi.first.wpilibj.Compressor;

import java.util.concurrent.TimeUnit;

import java.util.*;

/**

 * This is a demo program showing the use of the DifferentialDrive class.

 * Runs the motors with arcade steering.

 */

public class Robot extends TimedRobot {

  //Method for starting robot during autonomous//
  class Start extends TimerTask{
    public void run(){
      m_lfMotor.set(-0.2);
      m_lbMotor.set(-0.2);
      m_rfMotor.set(0.2);
      m_rbMotor.set(0.2);
      try {
        TimeUnit.SECONDS.sleep(2);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

  }
}

  //Declaring Compressor on Port 0//

  public final Compressor compressor1 = new Compressor(0);

  //Declaring variables related to the compressor, these variables tell if the compressor is enabled//
  //can get the pressure switch value as a boolean//
  //and can get the compressor current as a double//

  public final boolean enabled = compressor1.enabled();

  public final boolean pressureSwitch = compressor1.getPressureSwitchValue();

  public final double current = compressor1.getCompressorCurrent();

  //Declaring motors with motor types and motor ports//

  public final PWMVictorSPX m_lfMotor = new PWMVictorSPX(9);

  public final PWMVictorSPX m_rfMotor = new PWMVictorSPX(1);

  public final PWMVictorSPX m_lbMotor = new PWMVictorSPX(8);

  public final PWMVictorSPX m_rbMotor = new PWMVictorSPX(0);

  //Setting speed controller groups, sets up the groups as left and right motors//

  SpeedControllerGroup leftMotors = new SpeedControllerGroup(m_lfMotor, m_lbMotor);

  SpeedControllerGroup rightMotors = new SpeedControllerGroup(m_rfMotor, m_rbMotor);

  //Making Differential drive//

  private final DifferentialDrive m_robotDrive = new DifferentialDrive(leftMotors, rightMotors);

  //Declaring Joystick//

  private final Joystick m_stick = new Joystick(0);




  @Override

  public void teleopPeriodic() {

    // Drive with arcade drive.

    // That means that the Y axis drives forward

    // and backward, and the X turns left and right.

    m_robotDrive.arcadeDrive(m_stick.getY(), m_stick.getX());

    //Compressor/Pneumatic Control and Stuff//
    //This turns on the air compressor, it is automatically programmed (by the library) to stop at 120psi and re-enable at 80psi//

    compressor1.setClosedLoopControl(true);


  }

  public void autonomousPeriodic(){
    //Stuff for timing//
    Timer autonTimer = new Timer();
    TimerTask task = new Start();
    m_lfMotor.set(0);
    m_lbMotor.set(0);
    m_rfMotor.set(0);
    m_rbMotor.set(0);
    //Schedules function start to run after two seconds, for two seconds//
    autonTimer.schedule(task, 2000, 2000);
	}
  }

