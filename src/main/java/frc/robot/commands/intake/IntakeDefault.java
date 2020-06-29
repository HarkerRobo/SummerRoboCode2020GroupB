package frc.robot.commands.intake;

import frc.robot.OI;
import frc.robot.subsystems.Intake;
import harkerrobolib.commands.IndefiniteCommand;

public class IntakeDefault extends IndefiniteCommand {
   
   public static final double TRIGGER_THRESHOLD = 0.4;
   public static final double INTAKE_MAGNITUDE = -0.4;
   public static final double SLOW_OUTTAKE_MAGNITUDE = 0.2;
   
   public IntakeDefault(){
      addRequirements(Intake.getInstance());
   }

   @Override
   public void initialize()
   {

   }

   @Override
   public void execute()
   {
        if(OI.getInstance().getDriverGamepad().getRightTrigger()>=TRIGGER_THRESHOLD)
        {
            Intake.getInstance().setOutput(INTAKE_MAGNITUDE);
        }
        else if(OI.getInstance().getDriverGamepad().getLeftTrigger()>=TRIGGER_THRESHOLD)
            Intake.getInstance().setOutput(-INTAKE_MAGNITUDE);
        else
            Intake.getInstance().setOutput(0);

        if(Intake.getInstance().checkStalling())
            Intake.getInstance().setOutput(SLOW_OUTTAKE_MAGNITUDE);    
   }

   @Override
   public void end(boolean interrupted)
   {
      Intake.getInstance().setOutput(0);
   }
}