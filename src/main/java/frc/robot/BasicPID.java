package frc.robot;

import frc.robot.huskylib.src.RoboDevice;
import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class BasicPID extends RoboDevice{
  
  private CANSparkMax m_motor;
  private RelativeEncoder m_encoder;
  private SparkMaxPIDController m_pidController;

  public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput;
  public double rotations;
  private double m_currentPosition = 0.0;

  private int CANDeviceID;

  public BasicPID(int CANPort){
    super("BasicPID Sub System");
    CANDeviceID = CANPort;

    //Setting up devices
    m_motor = new CANSparkMax(CANDeviceID, MotorType.kBrushless);
    m_encoder = m_motor.getEncoder();
    m_motor.restoreFactoryDefaults();

    m_pidController = m_motor.getPIDController();
    m_pidController.setFeedbackDevice(m_encoder);

    //Setting up PID values
    kP = 0.1;
    kI = 1e-4;
    kD = 1;
    kIz = 0;
    kFF = 0;
    kMaxOutput = 1;
    kMinOutput = -1;
    
    m_pidController.setP(kP);
    m_pidController.setI(kI);
    m_pidController.setD(kD);
    m_pidController.setIZone(kIz);
    m_pidController.setFF(kFF);
    m_pidController.setOutputRange(kMinOutput, kMaxOutput);
  }

  public void Initialize(){
  }

  @Override
  public void doGatherInfo(){
    super.doGatherInfo();
    m_currentPosition = m_encoder.getPosition();
  }

  @Override
  public void doActions(){
    super.doActions();
     
    //Magic line of code that gets it going!
    m_pidController.setReference(rotations, CANSparkMax.ControlType.kPosition);
  }

  public void stopMovement(){
    System.out.println("Stopping Motors");
  }

  //Getter
  public double getPosition(){
    return m_currentPosition;
  }

  public void setPosition(double targPosition){
    m_encoder.setPosition(targPosition);
  }

  public CANSparkMax getMotor(){
    return m_motor;
  }

  //Setters
  //Attach a call to this method to an action on the joystick
  public void setRotations(double targRotations){
    rotations = targRotations;
  }

  public void setPValue(double kP){ 
    m_pidController.setP(kP);
  }

  public void setIValue(double kI){ 
    m_pidController.setI(kI);
  }

  public void setDValue(double kD){
    m_pidController.setD(kD);
  }

  public void setIZValue(double kIz){ 
    m_pidController.setIZone(kIz);
  }
    
  public void setFFValue(double kFF){ 
    m_pidController.setFF(kFF); 
  }
  
  public void setOutputRangeValues(double min, double max){ 
    m_pidController.setOutputRange(min, max); 
    kMinOutput = min; kMaxOutput = max;
  }

  public void setSlave(BasicPID slaveMotor){
    slaveMotor.m_motor.follow(m_motor, true);
  }

}
