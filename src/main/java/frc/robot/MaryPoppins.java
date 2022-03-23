package frc.robot;

import frc.robot.huskylib.src.RoboDevice;


public class MaryPoppins extends RoboDevice{
  private BasicPID m_frontMotor;
  private BasicPID m_rearMotor;

  public MaryPoppins(){
    super("MaryPoppins Sub System");

    m_frontMotor = new BasicPID(WiringConnections.FRONT_POPPINS_CONTROLLER_ID);
    m_rearMotor = new BasicPID(WiringConnections.REAR_POPPINS_CONTROLLER_ID);

    //might need to invert later?
    m_frontMotor.setSlave(m_rearMotor);
  }

  public void Initialize(){

  }

  public void riseUp(){
    //Update the double for specific values
    m_frontMotor.setRotations(2);
  }

  public void dropDown(){
    //Update the double for specific values
    m_frontMotor.setRotations(0.0);

    //NEEDS MAJOR BRAKING HERE!
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
