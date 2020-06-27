package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import harkerrobolib.wrappers.HSTalon;

public class Intake extends SubsystemBase {
   
    private static Intake intake;
    
    private HSTalon talon;
    private DoubleSolenoid solenoid;
    
    private static final boolean TALON_INVERT = false;
    private static final boolean TALON_SENSOR_PHASE = false;
    private static final double TALON_PEAK_VOLTAGE = 10.0;
    private static final int TALON_CURRENT_LIMIT = 40;
    private static final int TALON_PEAK_CURRENT = 50;
    private static final int TALON_PEAK_CURRENT_DURATION = 100;
    private static final double TALON_MIN_CURRENT_DRAW = 10;
    private static final double TALON_MIN_VELOCITY = 100;
    
    private Intake() {
        talon = new HSTalon(RobotMap.INTAKE_TALON_ID);
        solenoid = new DoubleSolenoid(RobotMap.FORWARD_INTAKE_SOLENOID_PORT, RobotMap.REVERSE_INTAKE_SOLENOID_PORT);
        talonInit();
    }

    public static Intake getInstance(){
        if (intake == null){
            intake = new Intake();
        }
        return intake;
    }

    public void talonInit()
    {
        talon.configFactoryDefault();
        
        talon.setInverted(TALON_INVERT);
        talon.setSensorPhase(TALON_SENSOR_PHASE);
        
        talon.configVoltageCompSaturation(TALON_PEAK_VOLTAGE);
        talon.enableVoltageCompensation(true);

        talon.configContinuousCurrentLimit(TALON_CURRENT_LIMIT);
        talon.configPeakCurrentLimit(TALON_PEAK_CURRENT);
        talon.configPeakCurrentDuration(TALON_PEAK_CURRENT_DURATION);
        talon.enableCurrentLimit(true);

        talon.setNeutralMode(NeutralMode.Coast);
    }

    public void setOutput(double spinMagnitude)
    {
        if (spinMagnitude==0)
            talon.set(ControlMode.Disabled, spinMagnitude);
        talon.set(ControlMode.PercentOutput, spinMagnitude);
    }

    public boolean checkStalling()
    {
        return (talon.getStatorCurrent() >= TALON_MIN_CURRENT_DRAW && talon.getSelectedSensorVelocity()<=TALON_MIN_VELOCITY);
    }

    public HSTalon getTalon() {
        return talon;
    }

    public DoubleSolenoid getSolenoid(){
        return solenoid;
    }

    public void toggleSolenoid(){
        if(solenoid.get() == Value.kForward)
            solenoid.set(Value.kReverse);
        else
            solenoid.set(Value.kForward);
    }
}