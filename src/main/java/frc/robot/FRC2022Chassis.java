package frc.robot;

import frc.robot.huskylib.src.*;
import frc.robot.huskylib.src.MechanumDriveTrain;
import frc.robot.huskylib.src.RoboDevice;

public class FRC2022Chassis extends RoboDevice{

  private MechanumDriveTrain m_driveTrain = 
    new MechanumDriveTrain(  WiringConnections.LEFT_FRONT_CONTROLLER_ID,
                             WiringConnections.LEFT_REAR_CONTROLLER_ID,
                             WiringConnections.RIGHT_FRONT_CONTROLLER_ID,
                             WiringConnections.RIGHT_REAR_CONTROLLER_ID
                          );

  private HuskyVector2D m_currentLocation;
  private double m_currentHeading = 0.0;
  private HuskyVector2D m_currentVelocity;

  public FRC2022Chassis(){
    super("FRC2022Chassis");

    AddChildDevice(m_driveTrain);

    m_currentLocation = new HuskyVector2D();
    m_currentVelocity = new HuskyVector2D();
  }
    
  public void Initialize(){
    m_driveTrain.Initialize();
  }

  public void setTargForwardBack(double targFB){
    m_driveTrain.setTargForwardBackSpeed(targFB);
  }

  public void setTargSideToSide(double targSS){
    m_driveTrain.setTargSideToSideSpeed(targSS);
  }

  public void setTargRotation(double targRot){
    m_driveTrain.setTargRotationSpeed(targRot);
  }

  @Override
  public void doGatherInfo() {
    super.doGatherInfo();

  }

  public HuskyVector2D getCurrentLocation(){
    return m_currentLocation;
  }

  public HuskyVector2D getCurrentVelocity(){
    return m_currentVelocity;
  }

  public double getCurrentHeading(){
    return m_currentHeading;
  }


  @Override
  public void doActions() {
    super.doActions();
  }

}
