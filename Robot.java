package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.hal.FRCNetComm.Tinstances.kRobotDrive_Tank;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class Robot extends TimedRobot {
    private static final int kLeftChannel = 1;
    private static final int kRightChannel = 0;
    private static final int kJoystickChannel = 0;

    private kRobotDrive_Tank t_robotDrive;
    private Joystick m_stick;

    @Override
    public void robotInit() {
        PWMSparkMax left = new PWMSparkMax(kLeftChannel);
        PWMSparkMax right = new PWMSparkMax(kRightChannel);

        left.setInverted(true);
        right.setInverted(true);

        t_robotDrive = new kRobotDrive_Tank(left, right);

        m_stick = new Joystick(kJoystickChannel);
    }

    @Override
    public void rotate() {
        m_robotDrive.driveCartesian(-m_stick.getY(), m_stick.getX(), m_stick.getZ(), 1.0);
    }
}
