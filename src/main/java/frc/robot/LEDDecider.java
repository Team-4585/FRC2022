package frc.robot;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LEDDecider extends SubsystemBase{
  private static Spark m_blinkin = null;

  public LEDDecider (int pwmPort){
    m_blinkin = new Spark(pwmPort);
  }

  public void set(double val){
    if((val >= -1.0) && (val <= 1.0)){
      m_blinkin.set(val);
    }
  }

  public void rainbowTwinkle(){
    set(-0.55);
  }

  public void solidGreen(){
    set(0.75);
  }

  public void solidRed(){
    set(0.61);
  }

  public void solidBlue(){
    set(0.87);
  }

  public void solidWhite(){
    set(0.93);
  }
}
