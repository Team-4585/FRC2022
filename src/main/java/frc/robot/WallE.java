package frc.robot;

import frc.robot.huskylib.src.RoboDevice;
import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class WallE extends RoboDevice{

private BasicPID left_motor;
private BasicPID right_motor;
private CANSparkMax intakeMotor;

private double targRotations = 2.0;
private double intakeSpeed = 0.0;

private static double positionThreshold = 0.05;
private double restingPosition = -2.0;
private double initialPosition = 0.0;
private double shootPosition;

  public WallE(){
    super("WallE Sub System");

    left_motor = new BasicPID(WiringConnections.LEFT_WALLE_CONTROLLER_ID);
    right_motor = new BasicPID(WiringConnections.RIGHT_WALLE_CONTROLLER_ID);
  
    left_motor.setSlave(right_motor);

    intakeMotor = new CANSparkMax(WiringConnections.INTAKE_CONTROLLER_ID, MotorType.kBrushless);

    left_motor.setPosition(initialPosition);
  }

  //11.3 motor to gearbox, 5 to big arm
  public void Initialize(){
  }

  public void deploy(){
    //Update the double for specific values
    left_motor.setRotations(targRotations);
    shootPosition = left_motor.getPosition();
  }

  public boolean isDeployed(){
    if(Math.abs(left_motor.getPosition() - targRotations) < positionThreshold){
      return true;
    }else{
      return false;
    }
  }

  public boolean isMoving(){
    double currentPosition = left_motor.getPosition();

    //edit restingPosition value once we figure out the zeroing thing!
    if (Math.abs(currentPosition - restingPosition) < positionThreshold){
      System.out.println("WallE is deployed!");
      return false;
    } else{
      System.out.println("WallE is deployed!");
      return true;
    }
  }

  //because of the direction the motor was installed, we have to invert its values to go "forward"
  public void intake(){
    setIntakeSpeed(-0.6);
    System.out.println("Intaking" +  intakeMotor.get());
   
    intakeMotor.set(intakeSpeed);
  }

  public void reverseIntake(){
    setIntakeSpeed(-0.6);
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
    left_motor.setRotations(restingPosition);
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
