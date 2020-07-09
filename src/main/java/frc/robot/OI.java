package frc.robot;

import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import harkerrobolib.commands.CallMethodCommand;
import harkerrobolib.wrappers.XboxGamepad;

/**
 * Contains the driver and operator gamepads and sets up their commands.
 * 
 * @author Ada P
 * @author Kunal J
 * @since 6/21/20
 */
public class OI
{
   public static final int DRIVER_GAMEPAD_PORT = 0;
   public static final int OPERATOR_GAMEPAD_PORT = 1;

   public static final double JOYSTICK_DEADBAND = 0.05;
   public static final double TRIGGER_DEADBAND = 0.05;

   public static OI oi;
   private XboxGamepad driverGamepad;
   private XboxGamepad operatorGamepad;
   
   private OI() {
        driverGamepad = new XboxGamepad(DRIVER_GAMEPAD_PORT);
        operatorGamepad = new XboxGamepad(OPERATOR_GAMEPAD_PORT);
        initBindings();
   }
   
   public void initBindings(){
       driverGamepad.getButtonB().whenPressed(new CallMethodCommand(() -> Intake.getInstance().toggleSolenoid()));
       driverGamepad.getButtonX().whenPressed(new CallMethodCommand(() -> Shooter.getInstance().toggleSolenoid()));
   }
   
   public static OI getInstance() {
       if (oi == null){
           oi = new OI();
       }
       return oi;
   }

   public XboxGamepad getDriverGamepad(){
       return driverGamepad;
   }

   public XboxGamepad getOperatorGamepad() {
       return operatorGamepad;
   }

}