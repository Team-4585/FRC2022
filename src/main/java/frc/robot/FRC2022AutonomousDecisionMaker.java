package frc.robot;

public class FRC2022AutonomousDecisionMaker {

  private FRC2022Chassis m_Chassis;
  private WallE m_WallE;
  private MaryPoppins m_MaryPoppins;


  FRC2022AutonomousDecisionMaker(){
  }

  public void initialize(){
  }

  public void doDecisions(){
  }

  public void setChassis(FRC2022Chassis TheChassis){
    m_Chassis = TheChassis;
  }

  public void setWallESubSystem(WallE WallESys){
    m_WallE = WallESys;
  }

  public void setMaryPoppinsSubSystem(MaryPoppins MaryPoppinsSys){
    m_MaryPoppins = MaryPoppinsSys;
  }


}
