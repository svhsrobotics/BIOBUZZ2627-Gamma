package org.firstinspires.ftc.teamcode.Modular_Components;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//Creates all the objects for the actual control classes
public class Robot {

    //Creates a telemetry object
    private Telemetry telemetry;

    //Creates a copy of the classes for the Robot class
    //Outline: "public [class name] [object name] = new [class name]();"
    public Drivetrain drive = new Drivetrain();
    public Intake intake = new Intake();
    public Shooter shooter = new Shooter();
//cole dcommemnt

    //"init(Hardwaremap hardwaremap, Telemetry telemetry)" gets the hardwaremap and telemetry from the Robot class and connects it to code references
    public void init(HardwareMap hardwareMap, Telemetry telemetry) {

        //"this.telemetry" references the Intake class's telemetry and sets it to the new telemetry
        this.telemetry = telemetry;

        //Sends hardwaremap and telemetry abilities to other objets
        drive.init(hardwareMap);
        intake.init(hardwareMap, telemetry);
        shooter.init(hardwareMap);
    }
}
