package frc.robot;

import frc.robot.huskylib.src.RoboDevice;


public class MaryPoppins extends RoboDevice{
  private BasicPID m_frontMotor;
  private BasicPID m_rearMotor;

  private double initialPosition = 0.0;
  private double risenPosition;
  private double positionThreshold = 0.01;

  public MaryPoppins(){
    super("MaryPoppins Sub System");

    m_frontMotor = new BasicPID(WiringConnections.FRONT_POPPINS_CONTROLLER_ID);
    m_rearMotor = new BasicPID(WiringConnections.REAR_POPPINS_CONTROLLER_ID);

    m_frontMotor.setSlave(m_rearMotor);
    //m_rearMotor.setSlave(m_frontMotor);

    m_frontMotor.setPosition(initialPosition);
  }

  public void Initialize(){

  }

  public void riseUp(){
    System.out.println("Rise up...");
    //Update the double for specific values
    m_frontMotor.setRotations(70);
    risenPosition = m_frontMotor.getPosition();
    
    //m_rearMotor.setRotations(10);
    System.out.println("Rising up");
  }

  public void dropDown(){
    //Update the double for specific values
    m_frontMotor.setRotations(0.0);
    initialPosition = m_frontMotor.getPosition();
    //m_rearMotor.setRotations(0.0);

    //NEEDS MAJOR BRAKING HERE!
  }

  public boolean isRisenUp(){
    double currentPosition = m_frontMotor.getPosition();
    System.out.println("Current Position: " + currentPosition);

    //edit this
    if (Math.abs(currentPosition - initialPosition) < positionThreshold){
      System.out.println("Mary Poppins is deployed!");
      return false;
    } else{
      return true;
    }
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
