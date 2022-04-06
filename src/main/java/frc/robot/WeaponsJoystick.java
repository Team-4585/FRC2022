package frc.robot;

import frc.robot.huskylib.devices.HuskyJoystick;

public class WeaponsJoystick extends HuskyJoystick{
  private static final int WEAPONS_JOYSTICK_PORT = 2;
 
  private static final int TRIGGER_BUTTON = 0;
  private static final int BUTTON_2 = 1;
  private static final int BUTTON_3 = 2;
  private static final int BUTTON_4 = 3;
  private static final int BUTTON_5 = 4;
  private static final int BUTTON_6 = 5;
  private static final int BUTTON_7 = 6;
  private static final int BUTTON_8 = 7;
  private static final int BUTTON_9 = 8;
  private static final int BUTTON_10 = 9;

  private static final double FB_DEAD_ZONE = 0.2;
  private static final double FB_LIVE_ZONE = 1.0 - FB_DEAD_ZONE;

  private static final double SS_DEAD_ZONE = 0.2;
  private static final double SS_LIVE_ZONE = 1.0 - SS_DEAD_ZONE;

  private static final double ROT_DEAD_ZONE = 0.1;
  private static final double ROT_LIVE_ZONE = 1.0 - ROT_DEAD_ZONE;


  public WeaponsJoystick(){
      super(WEAPONS_JOYSTICK_PORT);
  }

  public double getForwardBackwardValue(){
    double RetVal = 0.0;
    double RawVal = getAxisValue(HuskyJoystick.AXIS_FORWARD_BACKWARD);
    double RawMagVal = Math.abs(RawVal);  // work with positive numbers

    if(RawMagVal > FB_DEAD_ZONE){
      RetVal = RawMagVal - FB_DEAD_ZONE;  // distance past dead zone
      RetVal /= FB_LIVE_ZONE;             // scale to full range of live zone
      RetVal = RetVal * RetVal;           // square it to make the line a curve rather than straight
      if(RawVal > 0.0){
        RetVal = -RetVal;                 // Fix the sign, note that we're reversing the sign from the
                                          // raw joystick reading.
      }
    }

    return RetVal;
  }

  public Boolean triggerPushed(){
    return isButtonPushed(TRIGGER_BUTTON);
  }

  public Boolean triggerPressEvent(){
    return buttonPressEvent(TRIGGER_BUTTON);
  }
    
  public Boolean triggerReleaseEvent(){
    return buttonReleaseEvent(TRIGGER_BUTTON);
  }

  public Boolean button2ReleaseEvent(){
    return buttonReleaseEvent(BUTTON_2);
  }

  public Boolean button3ReleaseEvent(){
    return buttonReleaseEvent(BUTTON_3);
  }

  public Boolean button4ReleaseEvent(){
    return buttonReleaseEvent(BUTTON_4);
  }

  public Boolean button5ReleaseEvent(){
    return buttonReleaseEvent(BUTTON_5);
  }

  public Boolean button6Pushed(){
    return isButtonPushed(BUTTON_6);
  }

  public Boolean button6ReleaseEvent(){
    return buttonReleaseEvent(BUTTON_6);
  }

  public Boolean button7ReleaseEvent(){
    return buttonReleaseEvent(BUTTON_7);
  }
   public Boolean button8ReleaseEvent(){
    return buttonReleaseEvent(BUTTON_8);
  }

  public Boolean button9ReleaseEvent(){
    return buttonReleaseEvent(BUTTON_9);
  }

  public Boolean button10ReleaseEvent(){
    return buttonReleaseEvent(BUTTON_10);
  }
}
