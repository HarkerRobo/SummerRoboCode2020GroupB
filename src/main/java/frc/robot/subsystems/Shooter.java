package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.StatorCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.RobotMap;
import harkerrobolib.subsystems.HSFlywheel;
import harkerrobolib.util.Gains;
import harkerrobolib.wrappers.HSFalcon;
import harkerrobolib.wrappers.HSMotorController;

/**
 * Represents a shooter on the 2020 robot.
 * 
 * @author Kunal Jain
 */
public class Shooter extends HSFlywheel<HSMotorController> {

   private static Shooter shooter;

   public static final double WHEEL_DIAMETER = 4;
   public static final double GEAR_RATIO = 0.675;
   public static final int TICKS_PER_REVOLUTION = 2048;

   public static final boolean SENSOR_PHASE = false;
   public static final boolean MASTER_INVERT = true;
   public static final boolean FOLLOWER_INVERT = false;
   public static final int VELOCITY_SLOT = 0;
   public static Gains velocityPIDConstants = new Gains(0.064, 0.05, 0.001, 0.9, 150); // kF, kP, kI, kD, iZone
   public static final double VOLTAGE_COMP = 9.5;
   public static final double PEAK_CURRENT = 60;
   public static final double SUSTAINED_CURRENT = 50;
   public static final StatorCurrentLimitConfiguration CURRENT_LIMIT = new StatorCurrentLimitConfiguration(true,0.2,10,100);
   public static final double PEAK_TIME = 0.2; //seconds
   public static final double STALL_CURRENT = 10.0;
   public static final double STALL_MIN_VELOCITY = 100.0;

   private Shooter() {
        super(new HSFalcon(RobotMap.SHOOTER_MASTER_ID), new HSFalcon(RobotMap.SHOOTER_FOLLOWER_ID), 
            new DoubleSolenoid(RobotMap.FORWARD_SHOOTER_SOLENOID_PORT,RobotMap.REVERSE_SHOOTER_SOLENOID_PORT), 
            WHEEL_DIAMETER, TICKS_PER_REVOLUTION, GEAR_RATIO);
        super.setupFlywheel(SENSOR_PHASE, MASTER_INVERT, FOLLOWER_INVERT, VELOCITY_SLOT, velocityPIDConstants, VOLTAGE_COMP, CURRENT_LIMIT);
    }

   public static Shooter getInstance() {
      if (shooter == null) {
         shooter = new Shooter();
      }
      return shooter;
   }

   @Override
   public void toggleSolenoid()
   {
      super.toggleSolenoid();
   }

   @Override
   public void spinShooterPercentOutput(double percentOutput)
   {
      super.spinShooterPercentOutput(percentOutput);
   }

   @Override
   public void spinShooterVelocity(double velocity)
   {
      super.spinShooterVelocity(velocity);
   }

   public boolean checkStalling()
   {
      return super.checkStalling(STALL_CURRENT, STALL_MIN_VELOCITY);
   }

   @Override
   public void periodic() 
   {

   }
}