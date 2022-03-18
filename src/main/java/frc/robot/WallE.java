package frc.robot;

import frc.robot.huskylib.src.RoboDevice;


public class WallE extends RoboDevice{

private BasicPID left_motor;
private BasicPID right_motor;

  public WallE(){
    super("WallE Sub System");

    left_motor = new BasicPID(WiringConnections.LEFT_WALLE_CONTROLLER_ID);
    right_motor = new BasicPID(WiringConnections.RIGHT_WALLE_CONTROLLER_ID);
  
    left_motor.setSlave(right_motor);
  }

  public void Initialize(){

  }

  public void deploy(){
    //Update the double for specific values
    left_motor.setRotations(0.7);
  }

  public void detract(){
    //Update the double for specific values
    left_motor.setRotations(0.0);
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
