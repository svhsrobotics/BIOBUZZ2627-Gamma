package org.firstinspires.ftc.teamcode.Modular_Components;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

//The class for drive functions for the robot
public class Drivetrain {

    //"static" creates a constant so there is a singular reference for the constants
    public static double maxMotorPower = 0.85;

    //Creates a digital reference of the motors (Lines 10 -- 13)
    private DcMotor leftFront; //motor port 0
    private DcMotor rightFront; //motor port 1
    private DcMotor leftBack; //motor port 2
    private DcMotor rightBack; //motor port 3

    //"init(Hardwaremap hardwaremap)" gets the hardwaremap from the Robot class and connects it to code references
    public void init(HardwareMap hardwaremap) {
        //Gets the motors from the config and ports
        //Outline: "[device name in code] = hardwaremap.get([device type].class, [device name in config])"
        leftFront = hardwaremap.get(DcMotor.class, "left_Front");
        rightFront = hardwaremap.get(DcMotor.class, "right_Front");
        leftBack = hardwaremap.get(DcMotor.class, "left_Back");
        rightBack = hardwaremap.get(DcMotor.class, "right_Back");

        //Sets the rotation direction
        //"FORWARD" is counter-clockwise
        //"REVERSE" is clockwise
        //Outline: "[device name in code].setDirection(DcMotor.Direction.[FORWARD/BACKWARD]"
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.FORWARD);
        leftBack.setDirection(DcMotor.Direction.REVERSE);
        rightFront.setDirection(DcMotor.Direction.FORWARD);
    }

    public void mecanumDrive(double y, double rx, double x) {
        //Mecanum drive for TeleOp

        /*    ~Variable to Control Scheme~
        y = -gamepad1.left_stick_y;
        rx = gamepad1.left_stick_x;
        x = gamepad1.right_stick_x;     */

        //Outline: "[device name in code].setPower(maxMotorPower * [mecanum equation])"
        leftFront.setPower(maxMotorPower * (y + x + rx));
        leftBack.setPower(maxMotorPower * (y - x + rx));
        rightFront.setPower(maxMotorPower * (y - x - rx));
        rightBack.setPower(maxMotorPower * (y + x - rx));
    }
}
