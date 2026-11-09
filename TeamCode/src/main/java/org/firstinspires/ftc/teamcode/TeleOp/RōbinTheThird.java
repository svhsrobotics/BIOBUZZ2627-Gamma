package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Modular_Components.Drivetrain;
import org.firstinspires.ftc.teamcode.Modular_Components.Intake;

@TeleOp
public class RōbinTheThird extends OpMode {

    double intakePower = 0;
    public Drivetrain drive = new Drivetrain();
    public Intake intake = new Intake();

    @Override
    public void init() {
        drive.init(hardwareMap);
        intake.init(hardwareMap, telemetry);
    }

    @Override
    public void loop() {

        if(gamepad1.left_trigger > 0.9) {
            intakePower = 1;
        }
        else if(gamepad1.left_trigger_pressed){
            intakePower = -1;
        }
        else {
            intakePower = 0;
        }

        intake.run(intakePower);

        drive.mecanumDrive(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

        telemetry.update();
    }
}
