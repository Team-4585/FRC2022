package frc.robot.huskylib.auto;

import frc.robot.FRC2022Chassis;

public class AutoTaskDriveStraight extends AutonomousTaskBase{
    private FRC2022Chassis m_chassis;

    public AutoTaskDriveStraight(FRC2022Chassis chassis){
        m_chassis = chassis;
    }

    @Override
    public void TaskInitialize() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean DoTask() {
        m_chassis.setTargForwardBack(0.2);
        return true;
    }
}