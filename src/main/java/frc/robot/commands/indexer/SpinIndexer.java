import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.subsystems.Indexer;
import harkerrobolib.commands.IndefiniteCommand;

public class SpinIndexer extends IndefiniteCommand {

    private double spinMagnitude;
    private boolean spinBackward;
    
    public SpinIndexer(double spinOutput, boolean spinBackward) {
        super.addRequirements(Indexer.getInstance());
        spinMagnitude = spinOutput;
        this.spinBackward = spinBackward;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        boolean upperDetected = Indexer.getInstance().getUpperSensor().get();
        boolean lowerDetected = Indexer.getInstance().getLowerSensor().get();

        if ( (!upperDetected || !lowerDetected) || spinBackward) {
            Indexer.getInstance().getSpine().set(ControlMode.PercentOutput, (spinBackward) ? -spinMagnitude : spinMagnitude);
        }
        else {
            Indexer.getInstance().getSpine().set(ControlMode.Disabled, 0);
        }
    }
}