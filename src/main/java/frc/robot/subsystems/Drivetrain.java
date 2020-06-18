package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXInvertType;

import frc.robot.RobotMap;
import harkerrobolib.subsystems.HSSwerveDrivetrain;
import harkerrobolib.util.SwerveModule;
import harkerrobolib.wrappers.HSPigeon;

public class Drivetrain extends HSSwerveDrivetrain {

   public static Drivetrain drivetrain;
   
   public static final TalonFXInvertType TL_DRIVE_INVERT = TalonFXInvertType.Clockwise;
   public static final TalonFXInvertType TR_DRIVE_INVERT = TalonFXInvertType.Clockwise;
   public static final TalonFXInvertType BL_DRIVE_INVERT = TalonFXInvertType.Clockwise;
   public static final TalonFXInvertType BR_DRIVE_INVERT = TalonFXInvertType.Clockwise;
   
   
   public static final boolean TL_ANGLE_INVERT = false;
   public static final boolean TR_ANGLE_INVERT = true;
   public static final boolean BL_ANGLE_INVERT = false;
   public static final boolean BR_ANGLE_INVERT = true;
    
   
   public static final boolean TL_DRIVE_SENSOR_PHASE = false;
   public static final boolean TR_DRIVE_SENSOR_PHASE = false;
   public static final boolean BL_DRIVE_SENSOR_PHASE = false;
   public static final boolean BR_DRIVE_SENSOR_PHASE = false;
   
   public static final boolean TL_ANGLE_SENSOR_PHASE = false;
   public static final boolean TR_ANGLE_SENSOR_PHASE = false;
   public static final boolean BL_ANGLE_SENSOR_PHASE = false;
   public static final boolean BR_ANGLE_SENSOR_PHASE = false;
   
   public static final double CHASSIS_WIDTH = 0.535; //meters
   public static final double CHASSIS_LENGTH = 0.645; //meters
   public static final double GEAR_RATIO = 6; 
   public static final double WHEEL_DIAMETER = 4; //inches

   public static final int TL_OFFSET = 9084;
   public static final int TR_OFFSET = 5951;
   public static final int BL_OFFSET = 1582;
   public static final int BR_OFFSET = 5891;

   private Drivetrain() {
      super(initModules(), initPigeon(), CHASSIS_WIDTH, CHASSIS_LENGTH);
      // TODO Auto-generated constructor stub
   }

   public static Drivetrain getInstance() {
      if (drivetrain == null) {
         drivetrain = new Drivetrain();
      }
      return drivetrain;
   }

   public static SwerveModule[] initModules()
   {
      SwerveModule[] modules = new SwerveModule[4];
      modules[0] = new SwerveModule(RobotMap.TL_DRIVE_ID, TL_DRIVE_INVERT, TL_DRIVE_SENSOR_PHASE, RobotMap.TL_ANGLE_ID, TL_ANGLE_INVERT, TL_ANGLE_SENSOR_PHASE, WHEEL_DIAMETER, GEAR_RATIO, TL_OFFSET);
      modules[1] = new SwerveModule(RobotMap.TR_DRIVE_ID, TR_DRIVE_INVERT, TR_DRIVE_SENSOR_PHASE, RobotMap.TR_ANGLE_ID, TR_ANGLE_INVERT, TR_ANGLE_SENSOR_PHASE, WHEEL_DIAMETER, GEAR_RATIO, TR_OFFSET);
      modules[2] = new SwerveModule(RobotMap.BL_DRIVE_ID, BL_DRIVE_INVERT, BL_DRIVE_SENSOR_PHASE, RobotMap.BL_ANGLE_ID, BL_ANGLE_INVERT, BL_ANGLE_SENSOR_PHASE, WHEEL_DIAMETER, GEAR_RATIO, BL_OFFSET);
      modules[3] = new SwerveModule(RobotMap.BR_DRIVE_ID, BR_DRIVE_INVERT, BR_DRIVE_SENSOR_PHASE, RobotMap.BR_ANGLE_ID, BR_ANGLE_INVERT, BR_ANGLE_SENSOR_PHASE, WHEEL_DIAMETER, GEAR_RATIO, BR_OFFSET);
      
      return modules;
   }

   public static HSPigeon initPigeon()
   {
      return new HSPigeon(RobotMap.PIGEON_ID);
   }

}