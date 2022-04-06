package frc.robot;

import frc.robot.huskylib.src.RoboDevice;
import com.revrobotics.*;


public class MaryPoppins extends RoboDevice{
  private BasicPID m_frontMotor;
  private BasicPID m_rearMotor;

  private final static double INITIAL_POSITION = 0.0;
  private boolean hasRisen = false;
  private double risenPosition;
  private double positionThreshold = 0.01;

  public MaryPoppins(){
    super("MaryPoppins Sub System");

    m_frontMotor = new BasicPID(WiringConnections.FRONT_POPPINS_CONTROLLER_ID);
    m_rearMotor = new BasicPID(WiringConnections.REAR_POPPINS_CONTROLLER_ID);

    m_frontMotor.setSlave(m_rearMotor);
    //m_rearMotor.setSlave(m_frontMotor);

    //m_frontMotor.setPosition(initialPosition);
  }

  public void Initialize(){
    if(!hasRisen){
      m_frontMotor.setPosition(INITIAL_POSITION);
    }
  }

  public void riseUp(){
    System.out.println("Rise up...");
    //Update the double for specific values
    m_frontMotor.setRotations(-60);
    risenPosition = m_frontMotor.getPosition();

    // if(Math.abs(m_frontMotor.getPosition() - risenPosition) < 0.02){
    //   m_frontMotor.stopMovement();
    // } else{
    //   System.out.println("Hasn't risen yet");
    // }
    //m_rearMotor.setRotations(10);
    hasRisen = true;
    System.out.println("Rising up");
  }

  public void lowRise(){
    hasRisen = true;
    m_frontMotor.setRotations(-40);
  }

  public void midRise(){
    hasRisen = true;
    m_frontMotor.setRotations(-20);
  }

// //for testing purposes only!
//   public void rotate(double speed){
//     CANSparkMax motor = m_frontMotor.getMotor();
//     CANSparkMax motor2 = m_rearMotor.getMotor();
//     motor2.follow(motor, true);
//     motor.set(speed);
//   }

  // public void setInitialPosition(double position){
  //   initialPosition = position;
  // }


  public void resetPosition(){
    //m_frontMotor.setPosition(getMPInitalPosition());

  }

  public void lowerToInitialPosition(){
    m_frontMotor.setRotations(INITIAL_POSITION);
    hasRisen = false;
  }

  public void dropDown(){
    //Update the double for specific values
    m_frontMotor.setRotations(-5);
    System.out.println(m_frontMotor.getPosition());
    //initialPosition = m_frontMotor.getPosition();
    //m_rearMotor.setRotations(0.0);

    //NEEDS MAJOR BRAKING HERE!
  }

  public boolean isRisenUp(){
    double currentPosition = m_frontMotor.getPosition();
    System.out.println("Current Position: " + currentPosition);

    //edit this
    if (Math.abs(currentPosition - INITIAL_POSITION) < positionThreshold){
      System.out.println("Mary Poppins is deployed!");
      return false;
    } else{
      return true;
    }
  }

  public BasicPID getMotor(){
    return m_frontMotor;
  }

  @Override
  public void doGatherInfo() {
    super.doGatherInfo();

  }

  @Override
  public void doActions() {
    super.doActions();
  }

}
