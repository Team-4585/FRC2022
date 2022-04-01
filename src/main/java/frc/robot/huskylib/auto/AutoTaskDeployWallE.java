package frc.robot.huskylib.auto;

import frc.robot.WallE;

public class AutoTaskDeployWallE extends AutonomousTaskBase{
    private WallE m_wallE;

    public AutoTaskDeployWallE(){
    }

    public void setWallE(WallE wallE){
        m_wallE = wallE;
    }

    @Override
    public void TaskInitialize() {
        // TODO Auto-generated method stub
        m_wallE.deploy();
    }

    @Override
    public boolean CheckTask() {
        return m_wallE.isDeployed();
    }
}