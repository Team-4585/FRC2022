package frc.robot;

import frc.robot.huskylib.devices.LogitechController;

public class FRC2022TeleopDecisionMaker {
  private FRC2022Joystick m_TheJoystick = new FRC2022Joystick();
  private WeaponsJoystick m_weaponsJoystick = new WeaponsJoystick();
  private WeaponsLogitech m_weaponsLogitech = new WeaponsLogitech();

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

    if (m_weaponsLogitech.getLeftTriggerValue() < 0){
      System.out.println("Intaking");
      m_WallE.intake();
    }

    if (m_weaponsLogitech.getLeftTriggerValue() > -0.01){
      m_WallE.stopIntake();
    }

    if (m_weaponsLogitech.getRightTriggerValue() > -0.01){
      m_WallE.stopIntake();
    }

    if (m_weaponsLogitech.getRightTriggerValue() < 0){
      m_WallE.reverseIntake();
    }

    if (m_weaponsLogitech.BPressEvent()){
      if(!m_MaryPoppins.isRisenUp()){
        m_WallE.detract();
      }else{
        System.out.println("Error: Mary Poppins on the move!");
      }
    }

    if (m_weaponsLogitech.YReleaseEvent()){
      //if(!m_WallE.isMoving()){
        m_MaryPoppins.riseUp();
      //}else{
      //  System.out.println("Error: WallE on the move!");
      //}
    }

    if (m_weaponsLogitech.APushed()){
      m_MaryPoppins.dropDown();
    }

    if (m_weaponsLogitech.XReleaseEvent()){
      if(!m_MaryPoppins.isRisenUp()){
        m_WallE.deploy();
      }else{
        System.out.println("Error: Mary Poppins on the move!");
      }
    }

    if (m_weaponsJoystick.button7ReleaseEvent()){
      m_led.solidBlue();
    }

    if(m_weaponsJoystick.button8ReleaseEvent()){
      m_led.solidRed();
    }

    if(m_weaponsJoystick.button9ReleaseEvent()){
      m_led.solidGreen();
    }

    if(m_weaponsJoystick.button10ReleaseEvent()){
      m_led.rainbowTwinkle();
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
