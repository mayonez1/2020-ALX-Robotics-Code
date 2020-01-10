/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.Constants;

public class DriveTank extends CommandBase {
  /**
   * Creates a new DriveTank.
   */
  public DriveTank() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double velocity = -Robot.m_robotContainer.driverGamepad.getRawAxis(Constants.DRIVER_GAMEPAD_LSTICK);
    double rotationalSpeed = Robot.m_robotContainer.driverGamepad.getRawAxis(Constants.DRIVER_GAMEPAD_RSTICK);
    Robot.m_drivetrain.tankDrive(velocity, rotationalSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.m_drivetrain.tankDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
