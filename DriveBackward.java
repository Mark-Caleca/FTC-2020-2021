package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Autonomous(name="DriveBackwards", group="Autonomous")

public class DriveBackward extends LinearOpMode{

    public DcMotor rightFrontMotor, leftFrontMotor, rightBackMotor, leftBackMotor;

    public void init(HardwareMap ahwMap) {
        HardwareMap hwMap = ahwMap;

        rightFrontMotor = hwMap.get(DcMotor.class, "rfm");
        leftFrontMotor = hwMap.get(DcMotor.class, "lfm");
        rightBackMotor = hwMap.get(DcMotor.class, "rbm");
        leftBackMotor = hwMap.get(DcMotor.class, "lbm");

        leftFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        rightFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        leftBackMotor.setDirection(DcMotor.Direction.FORWARD);
        rightBackMotor.setDirection(DcMotor.Direction.FORWARD);
    }

    @Override
    public void runOpMode() {
        init(hardwareMap);

        telemetry.addData("Mode", "waiting");
        telemetry.update();


        waitForStart();

        telemetry.addData("Mode", "running");
        telemetry.update();

        setMotorPower(0.25);

        sleep(2000);

        setMotorPower(0.0);
    }
    public void setMotorPower(double powerA){
        leftFrontMotor.setPower(powerA);
        rightFrontMotor.setPower(powerA);
        leftBackMotor.setPower(powerA);
        rightBackMotor.setPower(powerA);
    }
}