package frc.robot.commands.auto;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrain;
import frc.robot.commands.*;

public class DriveForwardTime extends SequentialCommandGroup {
  /* Creates a new Driveforwardtime. */


  public DriveForwardTime(
    DriveTrain driveTrain
  ) {
    DoubleSupplier one = () -> -0.40;
    DoubleSupplier two= ()->0.40;
   // DoubleSupplier zero = () -> 0;

    

  addCommands(
  
    new SetTankDrive(driveTrain,one,one).withTimeout(3.15),
    new SetTankDrive(driveTrain, two, two).withTimeout(3.45)

   );
      
    


//     new SetTankDrive(driveTrain,one,one),
//     new WaitCommand(1),
//     new SetTankDrive(driveTrain,zero,zero));
   }
 }