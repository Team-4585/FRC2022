package frc.robot.huskylib.auto;

import frc.robot.WallE;

public class AutoTaskDetractWallE extends AutonomousTaskBase{
    private WallE m_wallE;

    public AutoTaskDetractWallE(){
    }

    public void setWallE(WallE wallE){
        m_wallE = wallE;
    }

    @Override
    public void TaskInitialize() {
        // TODO Auto-generated method stub
        m_wallE.detract();
    }

    @Override
    public boolean CheckTask() {
        return true;
    }
}