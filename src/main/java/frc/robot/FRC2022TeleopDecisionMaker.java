package frc.robot;

public class FRC2022TeleopDecisionMaker {
  private FRC2022Joystick m_TheJoystick = new FRC2022Joystick();
  private WeaponsJoystick m_weaponsJoystick = new WeaponsJoystick();

  private FRC2022Chassis m_Chassis;
  private WallE m_WallE;
  private MaryPoppins m_MaryPoppins;
  private LEDDecider m_led;



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
      if(!m_MaryPoppins.isRisenUp()){
        m_WallE.detract();
      }else{
        System.out.println("Error: Mary Poppins on the move!");
      }
    }

    if (m_weaponsJoystick.button3ReleaseEvent()){
      //if(!m_WallE.isMoving()){
        m_MaryPoppins.riseUp();
      //}else{
      //  System.out.println("Error: WallE on the move!");
      //}
    }

    if (m_weaponsJoystick.button4ReleaseEvent()){
      m_MaryPoppins.dropDown();
    }

    if (m_weaponsJoystick.button5ReleaseEvent()){
      if(!m_MaryPoppins.isRisenUp()){
        m_WallE.deploy();
      }else{
        System.out.println("Error: Mary Poppins on the move!");
      }
    }

    if(m_weaponsJoystick.greenPressEvent()){
      m_led.solidGreen();
    }
    
    if(m_weaponsJoystick.bluePressEvent()){
      m_led.solidBlue();
    }
     
     if(m_weaponsJoystick.redPressEvent()){
      m_led.solidRed();
    }

    if(m_weaponsJoystick.whitePressEvent()){
      m_led.solidWhite();
    }

  }

  public void setChassisandLED(FRC2022Chassis TheChassis, LEDDecider led){
    m_Chassis = TheChassis;
    m_led = led;
  }

  public void setWallESubSystem(WallE WallESys){
    m_WallE = WallESys;
  }

  public void setMaryPoppinsSubSystem(MaryPoppins MaryPoppinsSys){
    m_MaryPoppins = MaryPoppinsSys;
  }


}
