package frc.robot.commands.drivetrain;

import frc.robot.OI;
import frc.robot.subsystems.Drivetrain;
import harkerrobolib.commands.drivetrain.SwerveManual;
import harkerrobolib.subsystems.HSSwerveDrivetrain;
import harkerrobolib.wrappers.HSGamepad;

/**
 * Manual command for swerve control using left joystick for translation and right joystick for turning.and
 * 
 * @version 6/21/20
 */
public class SwerveDriveManual extends SwerveManual {

   public static final double OUTPUT_MULTIPLIER = 0.5;

   public SwerveDriveManual(HSSwerveDrivetrain drivetrain, int driveVelocitySlot, int anglePositionSlot,
         HSGamepad gamepad, double maxDriveVelocity, double maxRotationVelocity, double pigeon_kP,
         double outputMultiplier) {
      super(Drivetrain.getInstance(), Drivetrain.DRIVE_VELOCITY_SLOT, Drivetrain.ANGLE_POSITION_SLOT, OI.getInstance().getDriverGamepad(), Drivetrain.MAX_DRIVE_VELOCITY, Drivetrain.MAX_ROTATION_VELOCITY, Drivetrain.PIGEON_KP,
            OUTPUT_MULTIPLIER);
   }
    
}