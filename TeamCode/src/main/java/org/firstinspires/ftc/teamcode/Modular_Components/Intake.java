package org.firstinspires.ftc.teamcode.Modular_Components;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    DcMotor leftIntake;
    DcMotor rightIntake;
    public void init(HardwareMap hardwareMap) {
        leftIntake = hardwareMap.get(DcMotor.class, "left_intake");
        rightIntake = hardwareMap.get(DcMotor.class, "right_intake");

        leftIntake.setDirection(DcMotor.Direction.FORWARD);
        rightIntake.setDirection((DcMotor.Direction.REVERSE));
    }

    public void run(double power){
        //positive power is intake
        //negative power is outtake
        leftIntake.setPower(power);
        rightIntake.setPower(-power);
    }
}
