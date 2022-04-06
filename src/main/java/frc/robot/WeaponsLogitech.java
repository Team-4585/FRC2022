package frc.robot;

import frc.robot.huskylib.devices.LogitechController;

public class WeaponsLogitech extends LogitechController{
  private static final int WEAPONS_JOYSTICK_PORT = 1;

  private static final double FB_LIVE_ZONE = 1.0 - DEFAULT_FB_DEADZONE;

 
  private static final int BUTTON_A = 0;
  private static final int BUTTON_B = 1;
  private static final int BUTTON_X = 2;
  private static final int BUTTON_Y = 3;
  private static final int BUTTON_5 = 4;
  private static final int BUTTON_6 = 5;
  private static final int BUTTON_7 = 6;
  private static final int BUTTON_8 = 7;
  private static final int BUTTON_9 = 8;
  private static final int BUTTON_10 = 9;

  public WeaponsLogitech(){
      super(WEAPONS_JOYSTICK_PORT);
  }


  public double getLeftTriggerValue(){
    double RetVal = 0.0;
    double RawVal = getAxisValue(LogitechController.LEFT_TRIGGER);
    double RawMagVal = Math.abs(RawVal);  // work with positive numbers

    if(RawMagVal > LogitechController.DEFAULT_FB_DEADZONE){
      RetVal = RawMagVal - DEFAULT_FB_DEADZONE;  // distance past dead zone
      RetVal /= FB_LIVE_ZONE;             // scale to full range of live zone
      RetVal = RetVal * RetVal;           // square it to make the line a curve rather than straight
      if(RawVal > 0.0){
        RetVal = -RetVal;                 // Fix the sign, note that we're reversing the sign from the
      }                                // raw joystick reading.
      }

      return RetVal;
    }

    public double getRightTriggerValue(){
      double RetVal = 0.0;
      double RawVal = getAxisValue(LogitechController.RIGHT_TRIGGER);
      double RawMagVal = Math.abs(RawVal);  // work with positive numbers
  
      if(RawMagVal > LogitechController.DEFAULT_FB_DEADZONE){
        RetVal = RawMagVal - DEFAULT_FB_DEADZONE;  // distance past dead zone
        RetVal /= FB_LIVE_ZONE;             // scale to full range of live zone
        RetVal = RetVal * RetVal;           // square it to make the line a curve rather than straight
        if(RawVal > 0.0){
          RetVal = -RetVal;                 // Fix the sign, note that we're reversing the sign from the
        }                                // raw joystick reading.
        }
  
        System.out.println(RetVal);

        return RetVal;

      }

      public double getRightXJoystickValue(){
        double RetVal = 0.0;
        double RawVal = getAxisValue(LogitechController.RIGHT_X_AXIS);
        double RawMagVal = Math.abs(RawVal);  // work with positive numbers
    
        if(RawMagVal > LogitechController.DEFAULT_FB_DEADZONE){
          RetVal = RawMagVal - DEFAULT_FB_DEADZONE;  // distance past dead zone
          RetVal /= FB_LIVE_ZONE;             // scale to full range of live zone
          RetVal = RetVal * RetVal;           // square it to make the line a curve rather than straight
          if(RawVal > 0.0){
            RetVal = -RetVal;                 // Fix the sign, note that we're reversing the sign from the
          }                                // raw joystick reading.
          }
    
          System.out.println(RetVal);
  
          return RetVal;
  
        }

        public double getRightYJoystickValue(){
          double RetVal = 0.0;
          double RawVal = getAxisValue(LogitechController.RIGHT_Y_AXIS);
          double RawMagVal = Math.abs(RawVal);  // work with positive numbers
      
          if(RawMagVal > LogitechController.DEFAULT_FB_DEADZONE){
            RetVal = RawMagVal - DEFAULT_FB_DEADZONE;  // distance past dead zone
            RetVal /= FB_LIVE_ZONE;             // scale to full range of live zone
            RetVal = RetVal * RetVal;           // square it to make the line a curve rather than straight
            if(RawVal > 0.0){
              RetVal = -RetVal;                 // Fix the sign, note that we're reversing the sign from the
            }                                // raw joystick reading.
            }
      
            System.out.println(RetVal);
    
            return RetVal;
    
          }


  public Boolean APushed(){
    return isButtonPushed(BUTTON_A);
  }

  public Boolean BPressEvent(){
    return buttonPressEvent(BUTTON_B);
  }
    
  public Boolean XReleaseEvent(){
    return buttonReleaseEvent(BUTTON_X);
  }

  public Boolean YReleaseEvent(){
    return buttonReleaseEvent(BUTTON_Y);
  }

  // public Boolean button3ReleaseEvent(){
  //   return buttonReleaseEvent(BUTTON_3);
  // }

  // public Boolean button4ReleaseEvent(){
  //   return buttonReleaseEvent(BUTTON_4);
  // }

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
