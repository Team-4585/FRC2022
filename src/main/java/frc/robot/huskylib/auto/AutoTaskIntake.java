 package frc.robot.huskylib.auto;

import frc.robot.WallE;
import edu.wpi.first.wpilibj.Timer;


public class AutoTaskIntake extends AutonomousTaskBase{
    private WallE m_wallE;
    private Timer m_timer = new Timer();


    public AutoTaskIntake(){
    }

    public void setWallESpinner(WallE wallE){
        m_wallE = wallE;
    }

    @Override
    public void TaskInitialize() {
        // TODO Auto-generated method stub
        m_wallE.intake();
       // m_timer.start();
    }

    @Override
    public boolean CheckTask() {
        // if(m_timer.hasElapsed(2)){
        //     m_timer.stop();
        //     m_timer.reset();
        //     m_wallE.stopIntake();
        //     return true;
        // } else{
        //     return false;
        // }
        return true;
    }
}