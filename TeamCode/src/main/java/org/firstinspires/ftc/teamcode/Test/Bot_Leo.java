package org.firstinspires.ftc.teamcode.Test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class Bot_Leo extends OpMode {
    double x;
    double y;
    double rx;

    DcMotor leftFront; //motor 0
    DcMotor rightFront; //motor 1
    DcMotor leftBack; //motor 2
    DcMotor rightBack; //motor 3
    CRServo leftIntake;
    CRServo rightIntake;

    @Override
    public void init() {
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        leftIntake = hardwareMap.get(CRServo.class, "leftIntake");
        rightIntake = hardwareMap.get(CRServo.class, "rightIntake");
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.FORWARD);
        leftBack.setDirection(DcMotor.Direction.REVERSE);
        rightFront.setDirection(DcMotor.Direction.FORWARD);
    }
    @Override
    public void loop() {
        y = -gamepad1.left_stick_y;
        rx = gamepad1.left_stick_x;
        x = gamepad1.right_stick_x;

        leftFront.setPower(0.85 * (y + x + rx));
        leftBack.setPower(0.85 * (y - x + rx));
        rightFront.setPower(0.85 * (y - x - rx));
        rightBack.setPower(0.85 * (y + x - rx));

        if (gamepad1.left_bumper) {
            leftIntake.setPower(-3);
            rightIntake.setPower(3);
        } else if (gamepad1.right_bumper) {
            leftIntake.setPower(3);
            rightIntake.setPower(-3);
        } else {
            leftIntake.setPower(0);
            rightIntake.setPower(0);
        }
    }
}
