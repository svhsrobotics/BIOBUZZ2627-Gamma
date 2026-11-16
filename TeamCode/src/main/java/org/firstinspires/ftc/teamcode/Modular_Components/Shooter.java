package org.firstinspires.ftc.teamcode.Modular_Components;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

//The class for intake functions for the robot
public class Shooter {

    //Creates a digital reference of the motor
    DcMotor shooter;

    //"init(Hardwaremap hardwaremap)" gets the hardwaremap from the Robot class and connects it to code references
    public void init(HardwareMap hardwareMap) {

        //Outline: "[device name in code] = hardwaremap.get([device type].class, [device name in config])"
        shooter = hardwareMap.get(DcMotor.class, "shooter_Motor");

        //Outline: "[device name in code].setDirecton([device type].Direction.[FORWARD/BACKWARD]"
        shooter.setDirection(DcMotor.Direction.REVERSE);
    }

    //cole comment. when found alert cole. made 11/16/26

    //Sets the power to a power value
    public void shoot(double power) {
        //Power limit is 1, but the rpm is 6000. Use with caution.

        shooter.setPower(power);
    }
}
