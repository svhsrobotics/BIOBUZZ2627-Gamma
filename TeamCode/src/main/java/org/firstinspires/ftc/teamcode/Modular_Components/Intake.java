package org.firstinspires.ftc.teamcode.Modular_Components;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake {

    private Telemetry telemetry;
    public boolean safetySwitch = true;
    public double geckoLimit = 5;
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

        telemetry.addData("Gecko Safety Switch: ", safetySwitch);

        if ((Math.abs(power) > geckoLimit) && (safetySwitch = true)) {
            telemetry.addLine("Unsafe power levels. ");
            telemetry.addLine("Would you like to proceed?");
            intake.setPower(geckoLimit);
        } else {
            intake.setPower(power);
        }
    }
}