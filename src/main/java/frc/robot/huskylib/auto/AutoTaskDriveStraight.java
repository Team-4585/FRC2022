package frc.robot.huskylib.auto;

import frc.robot.FRC2022Chassis;
import edu.wpi.first.wpilibj.Timer;

public class AutoTaskDriveStraight extends AutonomousTaskBase{
    private FRC2022Chassis m_chassis;
    private Timer m_timer = new Timer();

    public AutoTaskDriveStraight(){
    }

    public void setChassis(FRC2022Chassis chassis){
        m_chassis = chassis;
    }

    @Override
    public void TaskInitialize() {
        // TODO Auto-generated method stub
        m_chassis.driveStraight();
        m_timer.start();
        System.out.println("Driving forward");
    }

    @Override
    public boolean CheckTask() {
        if(m_chassis == null){
            System.out.println("Chassis is null!");
        }
        else{
            System.out.println("Chassis is valid");
        }

        System.out.println(m_timer.get());

        if(m_timer.hasElapsed(3)){
            m_chassis.setTargForwardBack(0.0);
            m_timer.stop();
            m_timer.reset();
            return true;
        } else{
            return false;
        }
    }
}