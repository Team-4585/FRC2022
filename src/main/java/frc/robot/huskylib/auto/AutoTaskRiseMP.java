package frc.robot.huskylib.auto;

import frc.robot.MaryPoppins;

public class AutoTaskRiseMP extends AutonomousTaskBase{
    private MaryPoppins m_maryPoppins;

    public AutoTaskRiseMP(MaryPoppins maryPoppins){
        m_maryPoppins = maryPoppins;
    }

    @Override
    public void TaskInitialize() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean DoTask() {
        m_maryPoppins.riseUp();
        return true;
    }
}