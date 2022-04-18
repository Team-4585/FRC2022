package frc.robot.huskylib.auto;

import frc.robot.FRC2022Chassis;
import edu.wpi.first.wpilibj.Timer;

public class AutoTaskDriveBackwards extends AutonomousTaskBase{
    private FRC2022Chassis m_chassis;
    private Timer m_timer = new Timer();
    private double motorSpeed = 0.0;
    private double secondCount = 0.0;

    public AutoTaskDriveBackwards(double seconds, double speed){
        motorSpeed = speed;
        secondCount = seconds;
    }

    public void setChassis(FRC2022Chassis chassis){
        m_chassis = chassis;
    }

    @Override
    public void TaskInitialize() {
        // TODO Auto-generated method stub
        m_chassis.driveBackwards(motorSpeed);
        m_timer.start();
        System.out.println("Driving backwards");
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

        if(m_timer.hasElapsed(secondCount)){
            m_chassis.setTargForwardBack(0.0);
            m_timer.stop();
            m_timer.reset();
            return true;
        } else{
            return false;
        }
    }
}