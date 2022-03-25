package frc.robot.huskylib.auto;

// An abstract class that all the autonomous tasks should inherit from.  This will allow us
// to make a list of tasks that may have different formats.
public abstract class AutonomousTaskBase {

    // Initial setup for the task before it starts running
    public abstract void TaskInitialize();

    // Called each time through the loop.  
    // Return 'true' if the task is completed, 'false' if it is not
    public abstract boolean CheckTask();
    
}
