/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.commands.DriveTank;
import edu.wpi.first.wpilibj.PWMVictorSPX;


public class Drivetrain extends SubsystemBase {
  //Creating motor controller variables//
  PWMVictorSPX leftFrontController = null;
  PWMVictorSPX rightFrontController = null;
  PWMVictorSPX leftBackController = null;
  PWMVictorSPX rightBackController = null;
  
  DifferentialDrive differentialDrive = null;

  //Tank Drive Function//
  public void arcadeDrive(double velocity, double rotationalSpeed){
    differentialDrive.arcadeDrive(velocity, rotationalSpeed);
  }

  //Telling the script the ports that correspond to the VictorSP motor controllers, as well as setting up groups//
  public Drivetrain() {
    leftFrontController = new PWMVictorSPX(Constants.DRIVETRAIN_LF_CONT);
    rightFrontController = new PWMVictorSPX(Constants.DRIVETRAIN_RF_CONT);
    leftBackController = new PWMVictorSPX(Constants.DRIVETRAIN_LB_CONT);
    rightBackController = new PWMVictorSPX(Constants.DRIVETRAIN_RB_CONT);

    SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFrontController, leftBackController);
    SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightFrontController, rightBackController);

    differentialDrive = new DifferentialDrive(leftMotors, rightMotors);


  }
  //Making the default command the DriveTank script//
  public void initDefaultCommand(){
    setDefaultCommand(new DriveTank());
  }

  @Override
  public void periodic() {
    
  }
}
