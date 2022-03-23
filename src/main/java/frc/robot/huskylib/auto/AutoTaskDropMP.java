package frc.robot.huskylib.auto;

import frc.robot.MaryPoppins;

public class AutoTaskDropMP extends AutonomousTaskBase{
    private MaryPoppins m_maryPoppins;

    public AutoTaskDropMP(MaryPoppins maryPoppins){
        m_maryPoppins = maryPoppins;
    }

    @Override
    public void TaskInitialize() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean DoTask() {
        m_maryPoppins.dropDown();
        return true;
    }
}