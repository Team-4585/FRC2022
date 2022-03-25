package frc.robot.huskylib.auto;

// an autonomous class that will print the numbers up to the target number and
// then complete.
public class AutoTaskTickCount extends AutonomousTaskBase{

    private int m_countMax = 0;
    private int m_currentCount = 0;

    public AutoTaskTickCount(int countMax){
        m_countMax = countMax;
    }

    @Override
    public void TaskInitialize() {
        m_currentCount = 0;
    }

    @Override
    public boolean CheckTask() {
        System.out.println(m_currentCount);

        m_currentCount++;

        if(m_currentCount > m_countMax){
            return true;
        }
        else{
            return false;
        }
    }

    
}
