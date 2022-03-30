package frc.robot;

public class FRC2022TeleopDecisionMaker {
  private FRC2022Joystick m_TheJoystick = new FRC2022Joystick();
  private WeaponsJoystick m_weaponsJoystick = new WeaponsJoystick();

  private FRC2022Chassis m_Chassis;
  private WallE m_WallE;
  private MaryPoppins m_MaryPoppins;



  FRC2022TeleopDecisionMaker(){

  }

  public void initialize(){
  }

  public void doDecisions(){

    // System.out.println("-- F/B: " + m_TheJoystick.getForwardBackwardValue() + 
    //                    "   S/S: " + m_TheJoystick.getSideToSideValue() + 
    //                    "   Rot: " + m_TheJoystick.getTwistValue());

    m_Chassis.setTargForwardBack(m_TheJoystick.getForwardBackwardValue());
    m_Chassis.setTargSideToSide(m_TheJoystick.getSideToSideValue());
    m_Chassis.setTargRotation(m_TheJoystick.getTwistValue());

    if (m_weaponsJoystick.triggerPushed()){
      System.out.println("Intaking");
      m_WallE.intake();
    }

    if (m_weaponsJoystick.triggerReleaseEvent()){
      m_WallE.stopIntake();
    }

    if (m_weaponsJoystick.button6ReleaseEvent()){
      m_WallE.stopIntake();
    }

    if (m_weaponsJoystick.button6Pushed()){
      m_WallE.reverseIntake();
    }

    if (m_weaponsJoystick.button2ReleaseEvent()){
      m_WallE.detract();
    }

    if (m_weaponsJoystick.button3ReleaseEvent()){
      m_MaryPoppins.riseUp();
    }

    if (m_weaponsJoystick.button4ReleaseEvent()){
      m_MaryPoppins.dropDown();
    }

    if (m_weaponsJoystick.button5ReleaseEvent()){
      if(m_MaryPoppins.isRisenUp()){

      }
      m_WallE.deploy();
    }
  }

  public void setChassis(FRC2022Chassis TheChassis){
    m_Chassis = TheChassis;
  }

  public void setWallESubSystem(WallE WallESys){
    m_WallE = WallESys;
  }

  public void setMaryPoppinsSubSystem(MaryPoppins MaryPoppinsSys){
    m_MaryPoppins = MaryPoppinsSys;
  }


}
