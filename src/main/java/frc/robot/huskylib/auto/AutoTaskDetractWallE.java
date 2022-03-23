package frc.robot.huskylib.auto;

import frc.robot.WallE;

public class AutoTaskDetractWallE extends AutonomousTaskBase{
    private WallE m_wallE;

    public AutoTaskDetractWallE(WallE wallE){
        m_wallE = wallE;
    }

    @Override
    public void TaskInitialize() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean DoTask() {
        m_wallE.detract();
        return true;
    }
}