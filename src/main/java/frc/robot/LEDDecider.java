package frc.robot;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LEDDecider extends SubsystemBase {
  private static Spark m_blinkin = null;

  /**
   * Creates a new Blinkin LED controller.
   * 
   * @param pwmPort  The PWM port the Blinkin is connected to.
   */
  public LEDDecider(int pwmPort) {
    m_blinkin = new Spark(pwmPort);
  }

  /*
   * Set the color and blink pattern of the LED strip.
   * 
   * Consult the Rev Robotics Blinkin manual Table 5 for a mapping of values to patterns.
   * 
   * @param val The LED blink color and patern value [-1,1]
   * 
   */ 
  public void set(double val) {
    if ((val >= -1.0) && (val <= 1.0)) {
      m_blinkin.set(val);
    }
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
  public void rainbowTwinkle(){
    set(-0.55);
  }

}