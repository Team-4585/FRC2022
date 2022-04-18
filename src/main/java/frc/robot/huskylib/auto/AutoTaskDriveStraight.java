package frc.robot.huskylib.auto;

import frc.robot.FRC2022Chassis;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.WallE;

public class AutoTaskDriveStraight extends AutonomousTaskBase{
    private FRC2022Chassis m_chassis;
    private Timer m_timer = new Timer();
    private WallE m_wallE;
    private double secondCount = 0.0;
    private double motorSpeed = 0.0;

    public AutoTaskDriveStraight(double seconds, double speed){
        secondCount = seconds;
        motorSpeed = speed;
    }

    public void setChassis(FRC2022Chassis chassis){
        m_chassis = chassis;
    }

    public void setWallE(WallE walle){
        m_wallE = walle;
    }

    @Override
    public void TaskInitialize() {
        // TODO Auto-generated method stub
        m_chassis.driveStraight(motorSpeed);
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

        if(m_timer.hasElapsed(secondCount)){
            m_chassis.setTargForwardBack(0.0);
            m_timer.stop();
            m_timer.reset();
            m_wallE.stopIntake();
            return true;
        } else{
            return false;
        }
    }
}