package frc.robot.commands.drivetrain;

import harkerrobolib.commands.drivetrain.SwerveManual;
import harkerrobolib.subsystems.HSSwerveDrivetrain;
import harkerrobolib.wrappers.HSGamepad;

public class SwerveDriveManual extends SwerveManual {

   public SwerveDriveManual(HSSwerveDrivetrain drivetrain, int driveVelocitySlot, int anglePositionSlot,
         HSGamepad gamepad, double maxDriveVelocity, double maxRotationVelocity, double pigeon_kP,
         double outputMultiplier) {
      super(drivetrain, driveVelocitySlot, anglePositionSlot, gamepad, maxDriveVelocity, maxRotationVelocity, pigeon_kP,
            outputMultiplier);
      // TODO Auto-generated constructor stub
   }
    
}