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



/**

 * This is a demo program showing the use of the DifferentialDrive class.

 * Runs the motors with arcade steering.

 */

public class Robot extends TimedRobot {

  public final PWMVictorSPX m_lfMotor = new PWMVictorSPX(9);

  public final PWMVictorSPX m_rfMotor = new PWMVictorSPX(1);

  public final PWMVictorSPX m_lbMotor = new PWMVictorSPX(8);

  public final PWMVictorSPX m_rbMotor = new PWMVictorSPX(0);

  SpeedControllerGroup leftMotors = new SpeedControllerGroup(m_lfMotor, m_lbMotor);

  SpeedControllerGroup rightMotors = new SpeedControllerGroup(m_rfMotor, m_rbMotor);

  private final DifferentialDrive m_robotDrive = new DifferentialDrive(leftMotors, rightMotors);

  private final Joystick m_stick = new Joystick(0);



  @Override

  public void teleopPeriodic() {

    // Drive with arcade drive.

    // That means that the Y axis drives forward

    // and backward, and the X turns left and right.

    m_robotDrive.arcadeDrive(m_stick.getY(), m_stick.getX());

  }

}