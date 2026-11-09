package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Modular_Components.Drivetrain;
import org.firstinspires.ftc.teamcode.Modular_Components.Intake;

@TeleOp
public class RōbinTheThird extends OpMode {

    double angle = 0;
    double intakePower = 0;
    boolean useIntake = false;
    public Drivetrain drive = new Drivetrain();
    public Intake intake = new Intake();

    @Override
    public void init() {
        drive.init(hardwareMap);
        intake.init(hardwareMap, telemetry);
    }

    @Override
    public void loop() {

        if(gamepad1.dpadUpWasReleased()) {
            intakePower += 0.01;
        }
        if(gamepad1.dpadDownWasReleased()) {
            intakePower -= 0.01;
        }
        telemetry.addData("Intake Power: ", intakePower);

        drive.mecanumDrive(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

        if(gamepad1.left_bumper) {
            intake.adjustBar(1);
            angle = 1;
        }
        else {
            intake.adjustBar(0);
            angle = 0;
        }

        if(gamepad1.rightBumperWasReleased()) {
            useIntake = !useIntake;
        }
        if(useIntake && intake.inPosition(angle)) {
            intake.run(intakePower);
        }
        else {
            intake.run(0);
        }

        telemetry.update();
    }
}
