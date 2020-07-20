package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.StatorCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.RobotMap;
import harkerrobolib.util.Gains;
import harkerrobolib.wrappers.HSMotorController;
import harkerrobolib.wrappers.HSTalon;
import harkerrobolib.subsystems.HSIndexer;

public class Indexer extends HSIndexer<HSMotorController> {
    private static Indexer indexer;

    private DigitalInput lowerSensor;
    private DigitalInput upperSensor;

    private static final int LOWER_SENSOR_ID = 6;
    private static final int UPPER_SENSOR_ID = 7;


    private StatorCurrentLimitConfiguration CURRENT_CONFIG;
    private double MAX_VOLTAGE;
    private boolean AGITATOR_INVERT;
    private boolean SPINE_INVERT;
    private boolean SENSOR_PHASE;

    public Indexer() {
        super(new HSTalon(RobotMap.INDEXER_SPINE_ID), new VictorSPX(RobotMap.INDEXER_AGITATOR_ID), new DoubleSolenoid(RobotMap.INDEXER_FORWARD_SOLENOID_PORT, RobotMap.INDEXER_REVERSE_SOLENOID_PORT));
        lowerSensor = new DigitalInput(LOWER_SENSOR_ID);
        upperSensor = new DigitalInput(UPPER_SENSOR_ID);
    }

    public static Indexer getInstance() {
        if(indexer == null) {
            indexer = new Indexer();
        }
        return indexer;
    }

    public DigitalInput getUpperSensor() {
        return upperSensor;
    }

    public DigitalInput getLowerSensor(){
        return lowerSensor;
    }

    public void setUpMotorControllers() {
        super.setUpMotorControllers(CURRENT_CONFIG, MAX_VOLTAGE, AGITATOR_INVERT, SPINE_INVERT, SENSOR_PHASE);
    }
}