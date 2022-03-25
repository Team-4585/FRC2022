package frc.robot;

import frc.robot.huskylib.src.RoboDevice;
import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class WallE extends RoboDevice{

private BasicPID left_motor;
private BasicPID right_motor;
private CANSparkMax intakeMotor;

private double targPosition = 0.7;
private double intakeSpeed = 0.0;

private static double positionThreshold = 0.05;

  public WallE(){
    super("WallE Sub System");

    left_motor = new BasicPID(WiringConnections.LEFT_WALLE_CONTROLLER_ID);
    right_motor = new BasicPID(WiringConnections.RIGHT_WALLE_CONTROLLER_ID);
  
    left_motor.setSlave(right_motor);

    intakeMotor = new CANSparkMax(WiringConnections.INTAKE_CONTROLLER_ID, MotorType.kBrushless);
  }

  public void Initialize(){

  }

  public void deploy(){
    //Update the double for specific values
    left_motor.setRotations(targPosition);
  }

  public boolean isDeployed(){
    if(Math.abs(left_motor.getPosition() - targPosition) < positionThreshold){
      return true;
    }else{
      return false;
    }
  }

  public void intake(){
    setIntakeSpeed(0.6);
    intakeMotor.set(intakeSpeed);
  }

  public void reverseIntake(){
    setIntakeSpeed(0.6);
    intakeMotor.set(-intakeSpeed);
  }

  public void stopIntake(){
    setIntakeSpeed(0.0);
    intakeMotor.set(intakeSpeed);
  }

  public boolean isDetracted(){
    if(Math.abs(left_motor.getPosition()) < positionThreshold){
      return true;
    }else{
      return false;
    }
  }

  public void detract(){
    //Update the double for specific values
    left_motor.setRotations(0.0);
  }

  public void setIntakeSpeed(double speed){
    intakeSpeed = speed;
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
