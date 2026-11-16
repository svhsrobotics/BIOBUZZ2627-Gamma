package org.firstinspires.ftc.teamcode.Modular_Components;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//The class for intake functions for the robot
public class Intake {

    //Creates a telemetry object
    private Telemetry telemetry;

    //Creates a digital reference of the motors
    Servo leftIntake; //Useless; no physical servos
    Servo rightIntake; //Useless; no physical servos
    DcMotor intake;

    //"init(Hardwaremap hardwaremap, Telemetry telemetry)" gets the hardwaremap and telemetry from the Robot class and connects it to code references
    public void init(HardwareMap hardwareMap, Telemetry telemetry) {
        //this commen was made by cole. tell cole when thuis line has been found. this was created on no hes comign

        //"this.telemetry" references the Intake class's telemetry and sets it to the new telemetry
        this.telemetry = telemetry;

        //Outline: "[device name in code] = hardwaremap.get([device type].class, [device name in config])"
        //leftIntake = hardwareMap.get(Servo.class, "left_intake"); //Unused; no physical servo
        //rightIntake = hardwareMap.get(Servo.class, "right_intake"); //Unused; no physical servo
        intake = hardwareMap.get(DcMotor.class, "intake");

        //Outline: "[device name in code].setDirecton([device type].Direction.[FORWARD/BACKWARD]"
        //leftIntake.setDirection(Servo.Direction.FORWARD); //Unused; no physical servo
        //rightIntake.setDirection(Servo.Direction.REVERSE); //Unused; no physical servo
        intake.setDirection(DcMotor.Direction.REVERSE);
    }

    //Powers the intake. Is all.
    public void run(double power) {
        //Max power is 1   :(

        //positive power is intake
        //negative power is outtake
        intake.setPower(power);
    }
}