package org.firstinspires.ftc.teamcode.Modular_Components;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake {

    private Telemetry telemetry;
    Servo leftIntake;
    Servo rightIntake;
    DcMotor intake;

    public void init(HardwareMap hardwareMap, Telemetry telemetry) {

        this.telemetry = telemetry;

        //leftIntake = hardwareMap.get(Servo.class, "left_intake");
        //rightIntake = hardwareMap.get(Servo.class, "right_intake");
        intake = hardwareMap.get(DcMotor.class, "intake");

        //leftIntake.setDirection(Servo.Direction.FORWARD);
        //rightIntake.setDirection((Servo.Direction.REVERSE));
        intake.setDirection(DcMotor.Direction.REVERSE);
    }

    public void run(double power) {
        //positive power is intake
        //negative power is outtake
        intake.setPower(power);
    }
}