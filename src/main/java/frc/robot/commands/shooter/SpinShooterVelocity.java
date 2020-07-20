package frc.robot.commands.shooter;

import frc.robot.subsystems.Shooter;
import harkerrobolib.commands.IndefiniteCommand;

/**
 * Spins the shooter at a certain velocity.
 */
public class SpinShooterVelocity extends IndefiniteCommand {

    private double velocity;

    public SpinShooterVelocity(double velocity){
        addRequirements(Shooter.getInstance());
        this.velocity = velocity;
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute(){
        Shooter.getInstance().spinShooterVelocity(velocity);
    }

    @Override
    public void end(boolean interrupted) {
        Shooter.getInstance().spinShooterVelocity(0);
    }
}