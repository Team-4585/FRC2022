package frc.robot;

import java.util.List;
import frc.robot.huskylib.auto.*;

public class FRC2022AutonomousDecisionMaker {

  private FRC2022Chassis m_Chassis;
  private WallE m_WallE;
  // private MaryPoppins m_MaryPoppins;

  private List<AutonomousTaskBase> m_TaskList;
  private AutonomousTaskDispatcher m_autoTaskDispatcher;

  private AutoTaskDeployWallE autoDeployWallE = new AutoTaskDeployWallE();
  private AutoTaskDetractWallE autoDetractWallE = new AutoTaskDetractWallE();
  private AutoTaskStartSequence autoStartSeq = new AutoTaskStartSequence();
  private AutoTaskDriveStraight autoDriveStraight = new AutoTaskDriveStraight(0.5, 0.2);
  private AutoTaskDriveStraight autoDriveFast = new AutoTaskDriveStraight(3, 0.4);
  private AutoTaskWait autoWait2 = new AutoTaskWait(2);
  private AutoTaskOuttake autoSpitBall = new AutoTaskOuttake();
  private AutoTaskDriveBackwards autoBackwards = new AutoTaskDriveBackwards(4, 0.2);
  private AutoTaskIntake autoIntake = new AutoTaskIntake();


  // private AutoTaskDetractWallE autoDetractWallE;
  

 // private AutoTaskRiseMP autoRiseMP = new AutoTaskRiseMP(m_MaryPoppins);
 // private AutoTaskDropMP autoDropMP = new AutoTaskDropMP(m_MaryPoppins);

  FRC2022AutonomousDecisionMaker(){
   // m_TaskList = List.of(new AutoTaskTickCount(25), new AutoTaskHalt());
    
   System.out.println("Initializing list");
   m_TaskList = List.of(
    autoStartSeq,
    autoDeployWallE,
    autoSpitBall, 
    autoDetractWallE,
    autoDriveStraight,
    autoDriveStraight,
    autoDriveStraight,
    autoDriveStraight,
    autoDriveStraight,
    autoDriveStraight,
    autoIntake,
    autoDriveStraight, 
    autoDeployWallE,
    autoBackwards,
    autoSpitBall,
    autoDriveFast,
    autoDetractWallE,
    new AutoTaskHalt()
  );

  m_autoTaskDispatcher = new AutonomousTaskDispatcher(m_TaskList);
  }

  public void initialize(){

    m_autoTaskDispatcher.resetAuto();
  }

  public void doDecisions(){
    m_autoTaskDispatcher.RunAutoTask();
    System.out.println("Entering autonomous decisions");
  }

  public void setChassis(FRC2022Chassis TheChassis){
    m_Chassis = TheChassis;
    autoDriveStraight.setChassis(TheChassis);
    autoDriveFast.setChassis(TheChassis);
    autoBackwards.setChassis(TheChassis);
  }

  public void setWallESubSystem(WallE WallESys){
    m_WallE = WallESys;
    autoDeployWallE.setWallE(WallESys);
    autoDetractWallE.setWallE(WallESys);
    autoSpitBall.setWallESpinner(WallESys);
    autoDriveStraight.setWallE(WallESys);
    autoDriveFast.setWallE(WallESys);
    autoIntake.setWallESpinner(WallESys);
    }

  public void setMaryPoppinsSubSystem(MaryPoppins MaryPoppinsSys){
    // m_MaryPoppins = MaryPoppinsSys;
  }


}
