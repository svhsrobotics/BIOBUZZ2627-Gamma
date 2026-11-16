package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Modular_Components.Robot;

//TeleOp class; driver controlled period
@TeleOp
public class RōbinTheThird extends OpMode {

    double intakePower = 0;
    double shooterPower = 0;

    //Creates a Robot object for the RōbinTheThird class
    //Outline: "public [class name] [object name] = new [class name]();"
    public Robot robot = new Robot();

    //Sends hardwaremap and telemetry abilities to other objets
    @Override
    public void init() {
        robot.init(hardwareMap, telemetry);
    }

    @Override
    public void loop() {

        //Refer control scheme for the intake control
        if(gamepad1.left_trigger > 0.9) {
            //Intake
            intakePower = 1;
        }
        else if(gamepad1.left_trigger_pressed){
            //Outtake
            intakePower = -1;
        }
        else {
            //Disables the intake
            intakePower = 0;
        }

        //Powers the intake
        robot.intake.run(intakePower);

        //Shooter incrementation
        //Refer to control scheme
        if(gamepad1.dpadRightWasReleased()) {
            shooterPower += 0.01;
        }
        if(gamepad1.dpadUpWasReleased()) {
            shooterPower += 0.1;
        }
        if(gamepad1.dpadLeftWasReleased()) {
            shooterPower -= 0.01;
        }
        if(gamepad1.dpadDownWasReleased()) {
            shooterPower -= 0.1;
        }

        //Powers the shooter if the right bumper is pressed
        if (gamepad1.right_bumper){
            robot.shooter.shoot(shooterPower);
            telemetry.addLine("Shooter activated!");
        }
        else {
            //Disables the shooter if the bumper is not pressed
            robot.shooter.shoot(0);
            telemetry.addLine("Shooter not activated");
        }

        //Calls the mecanum drive method
        robot.drive.mecanumDrive(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

        //Clears telemetry and sends new ones
        telemetry.update();
    }
}
