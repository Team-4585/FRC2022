package frc.robot.huskylib.auto;

// an autonomous class that does nothing and will never complete.
// put this at the end of the list of tasks to do
public class AutoTaskHalt extends AutonomousTaskBase {

    public AutoTaskHalt(){
    }

    @Override
    public void TaskInitialize() {
    }

    @Override
    public boolean DoTask() {
        return false;   // This task never completes.
    }
    
}
