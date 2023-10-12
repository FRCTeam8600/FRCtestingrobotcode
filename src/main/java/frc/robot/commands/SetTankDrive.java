// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class SetTankDrive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private DriveTrain m_driveTrain;
    private DoubleSupplier m_leftOutput, m_rightOutput;

  /**
   * Creates a new ExampleCommand.
   *
   * @param driveTrain  The Drivetrain used by this command.
   */
  public SetTankDrive(DriveTrain driveTrain, DoubleSupplier leftOutput, DoubleSupplier rightOutput) {
    m_driveTrain = driveTrain;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
    m_leftOutput=leftOutput;
    m_rightOutput=rightOutput;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
         m_driveTrain.setPercentOutput(m_leftOutput.getAsDouble(), m_rightOutput.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveTrain.setPercentOutput(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
