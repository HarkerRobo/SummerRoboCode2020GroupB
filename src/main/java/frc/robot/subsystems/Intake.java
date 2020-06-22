package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.RobotMap;
import harkerrobolib.wrappers.HSTalon;

public class Intake {
   
    private static Intake intake;
    
    private HSTalon talon;
    private DoubleSolenoid solenoid;
    
    
    private Intake() {
        talon = new HSTalon(RobotMap.INTAKE_TALON_ID);
        solenoid = new DoubleSolenoid(RobotMap.FORWARD_INTAKE_SOLENOID_PORT, RobotMap.REVERSE_INTAKE_SOLENOID_PORT);
    }

    public static Intake getInstance(){
        if (intake == null){
            intake = new Intake();
        }
        return intake;
    }
}