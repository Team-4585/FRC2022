package frc.robot;

import frc.robot.huskylib.src.RoboDevice;


public class MaryPoppins extends RoboDevice{
  private BasicPID m_frontMotor;
  private BasicPID m_rearMotor;

  public MaryPoppins(){
    super("MaryPoppins Sub System");

    m_frontMotor = new BasicPID(WiringConnections.FRONT_POPPINS_CONTROLLER_ID);
    m_rearMotor = new BasicPID(WiringConnections.REAR_POPPINS_CONTROLLER_ID);

    m_frontMotor.setSlave(m_rearMotor);
    //m_rearMotor.setSlave(m_frontMotor);
  }

  public void Initialize(){

  }

  public void riseUp(){
    //Update the double for specific values
    m_frontMotor.setRotations(10);
    //m_rearMotor.setRotations(10);
    System.out.println("Rising up");
  }

  public void dropDown(){
    //Update the double for specific values
    m_frontMotor.setRotations(0.0);
    //m_rearMotor.setRotations(0.0);

    //NEEDS MAJOR BRAKING HERE!
  }

  public boolean isRisenUp(){
    double currentPosition = m_frontMotor.getPosition();
    System.out.println("Current Position: " + currentPosition);

    //edit this
    if (currentPosition > 0){

    }
    return true;
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
