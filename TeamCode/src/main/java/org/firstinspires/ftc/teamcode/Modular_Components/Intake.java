package org.firstinspires.ftc.teamcode.Modular_Components;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake {

    private Telemetry telemetry;
    public boolean safetySwitch = true;
    public double geckoLimit = 0.1;
    Servo leftIntake;
    Servo rightIntake;
    DcMotor intake;
    public void init(HardwareMap hardwareMap, Telemetry telemetry) {

        this.telemetry = telemetry;

        leftIntake = hardwareMap.get(Servo.class, "left_intake");
        rightIntake = hardwareMap.get(Servo.class, "right_intake");
        intake = hardwareMap.get(DcMotor.class, "intake");

        leftIntake.setDirection(Servo.Direction.FORWARD);
        rightIntake.setDirection((Servo.Direction.REVERSE));
        intake.setDirection(DcMotor.Direction.FORWARD);
    }

    public void run(double power){
        //positive power is intake
        //negative power is outtake

        telemetry.addData("Gecko Safety Switch: ", safetySwitch);

        if((power > geckoLimit) && (safetySwitch = true)) {
            telemetry.addLine("Unsafe power levels. ");
            telemetry.addLine("Would you like to proceed?");
        }
        else {
            intake.setPower(power);
        }
    }

    public void adjustBar(double angle) {
        leftIntake.setPosition(angle);
        rightIntake.setPosition(angle);
    }

    public boolean inPosition(double angle) {
        return (leftIntake.getPosition() == angle) && (rightIntake.getPosition() == angle);
    }
}
