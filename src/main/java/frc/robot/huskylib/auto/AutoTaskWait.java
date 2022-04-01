package frc.robot.huskylib.auto;

import edu.wpi.first.wpilibj.Timer;

public class AutoTaskWait extends AutonomousTaskBase{
    private Timer m_timer = new Timer();
    private double waitCount;
   
    public AutoTaskWait(double seconds){
        waitCount = seconds;
    }

    @Override
    public void TaskInitialize() {
       m_timer.start();
    }

    @Override
    public boolean CheckTask() {
        System.out.println(m_timer.get());

        if(m_timer.hasElapsed(waitCount)){
            m_timer.stop();
            m_timer.reset();
            return true;
        } else{
            return false;
        }
    }
}