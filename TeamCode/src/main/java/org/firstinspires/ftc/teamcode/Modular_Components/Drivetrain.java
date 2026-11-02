package org.firstinspires.ftc.teamcode.Modular_Components;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drivetrain {

    public static double maxMotorPower = 0.85;
    private DcMotor leftFront; //motor port 0
    private DcMotor rightFront; //motor port 1
    private DcMotor leftBack; //motor port 2
    private DcMotor rightBack; //motor port 3

    public void init(HardwareMap hardwaremap) {
        leftFront = hardwaremap.get(DcMotor.class, "left_front");
        rightFront = hardwaremap.get(DcMotor.class, "right_front");
        leftBack = hardwaremap.get(DcMotor.class, "left_back");
        rightBack = hardwaremap.get(DcMotor.class, "right_Back");

        leftFront.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.FORWARD);
        leftBack.setDirection(DcMotor.Direction.REVERSE);
        rightFront.setDirection(DcMotor.Direction.FORWARD);
    }

    public void mecanumDrive(double y, double rx, double x) {
        /*    ~Variable to Control Scheme~
        y = -gamepad1.left_stick_y;
        rx = gamepad1.left_stick_x;
        x = gamepad1.right_stick_x;
        */

        leftFront.setPower(maxMotorPower * (y + x + rx));
        leftBack.setPower(maxMotorPower * (y - x + rx));
        rightFront.setPower(maxMotorPower * (y - x - rx));
        rightBack.setPower(maxMotorPower * (y + x - rx));
    }
}
