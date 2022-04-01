// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.huskylib.src.HuskyRobot;
//import edu.wpi.first.cameraserver.CameraServer;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends HuskyRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  private FRC2022TeleopDecisionMaker m_TeleopDecider = new FRC2022TeleopDecisionMaker();
  private FRC2022AutonomousDecisionMaker m_AutoDecider = new FRC2022AutonomousDecisionMaker();

  private FRC2022Chassis m_TheChassis = new FRC2022Chassis();
  private WallE m_WallE = new WallE();
  private MaryPoppins m_MaryPoppins = new MaryPoppins();


  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);

    //m_TeleopDecider.initialize();
    //m_AutoDecider.initialize();
    m_TeleopDecider.setChassis(m_TheChassis);
    m_AutoDecider.setChassis(m_TheChassis);
    m_TeleopDecider.setWallESubSystem(m_WallE);
    m_AutoDecider.setWallESubSystem(m_WallE);
    m_TeleopDecider.setMaryPoppinsSubSystem(m_MaryPoppins);
    m_AutoDecider.setMaryPoppinsSubSystem(m_MaryPoppins);
     m_TeleopDecider.initialize();
     m_AutoDecider.initialize();

    //CameraServer.startAutomaticCapture();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    super.robotPeriodic();
  }

  
  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    super.autonomousInit();
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);

    m_AutoDecider.initialize();
  }

  public void doAutonomousDecisions(){
    m_AutoDecider.doDecisions();
  }


  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    super.autonomousPeriodic();

    //m_AutoDecider.doDecisions();
    // switch (m_autoSelected) {
    //   case kCustomAuto:
    //     // Put custom auto code here
    //     break;
    //   case kDefaultAuto:
    //   default:
    //     // Put default auto code here
    //     break;
    // }
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    super.teleopInit();
  
  }


  public void doTeleopDecisions(){
     m_TeleopDecider.doDecisions();
  
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    super.teleopPeriodic();
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {
    super.disabledInit();

    //m_AutoDecider.initialize();
    System.out.println("resetting auto values");
  }

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {
    super.disabledPeriodic();
  }

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {
    super.testInit();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
    super.testPeriodic();
  }

}
