package frc.robot.huskylib.auto;

// Dummy task to start off the task list that won't have any early initialization issues
public class AutoTaskStartSequence extends AutonomousTaskBase {
    public AutoTaskStartSequence(){      
    }

    @Override
    public void TaskInitialize() {
        System.out.println("Starting the sequence");
    }

    @Override
    public boolean CheckTask() {
        return true;
    }
    
}
