/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.commands.DriveTank;


public class Drivetrain extends SubsystemBase {
  //Creating motor controller variables//
  VictorSP leftFrontController = null;
  VictorSP rightFrontController = null;
  VictorSP leftBackController = null;
  VictorSP rightBackController = null;
  
  DifferentialDrive differentialDrive = null;

  //Tank Drive Function//
  public void tankDrive(double velocity, double rotationalSpeed){
    differentialDrive.tankDrive(velocity, rotationalSpeed);
  }

  //Telling the script the ports that correspond to the VictorSP motor controllers, as well as setting up groups//
  public Drivetrain() {
    leftFrontController = new VictorSP(Constants.DRIVETRAIN_LF_CONT);
    rightFrontController = new VictorSP(Constants.DRIVETRAIN_RF_CONT);
    leftBackController = new VictorSP(Constants.DRIVETRAIN_LB_CONT);
    rightBackController = new VictorSP(Constants.DRIVETRAIN_RB_CONT);

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
