package frc.robot.huskylib.auto;

import java.util.List;
import java.util.ListIterator;

// This is a class to handle the coordination of a list of autonomous tasks.  It will start with the first task
// in the list and call its initialization routine. Then each time RunAutoTask is called by the autonomousDecisionMaker
// it will call the current task's 'DoTask' routine. It will will continue to call that same routine each time until the
// task declares itself done by returning a 'true' instead of a 'false'. The displatcher will then get the next task out
// of the list and call its initialization routine and repeat the process.


public class AutonomousTaskDispatcher {
    private List<AutonomousTaskBase> m_autoTaskList;
    private AutonomousTaskBase m_currentTask;
    private ListIterator<AutonomousTaskBase> m_TaskItr;

    public AutonomousTaskDispatcher(List<AutonomousTaskBase> autoTaskList){
        m_autoTaskList = autoTaskList;
        m_TaskItr = m_autoTaskList.listIterator();
        m_currentTask = m_TaskItr.next();       // get the first task and bump the iterator
        m_currentTask.TaskInitialize();
    }

    public void RunAutoTask(){
        System.out.println("RunAutoTask");
        if(m_currentTask.CheckTask()){
            // Task completed. Move to the next one.
            m_currentTask = m_TaskItr.next();       // get the next task and bump the iterator
            m_currentTask.TaskInitialize();
        }
    }

}
