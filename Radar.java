package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import java.util.Timer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;


import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Position;


@Autonomous(name="Radar", group="Autonomous")

public class Radar extends LinearOpMode{
    DriveTrain robot = new DriveTrain();
    ElapsedTime time = new ElapsedTime();

    @Override
    public void runOpMode() {
        robot.init(hardwareMap); 
        waitForStart();

        int steps = 53;
        sleep(2500);
        for(int i = 0; i < steps; i++){
            time.reset();
            long StartTime = System.currentTimeMillis();
            telemetry.update();
            telemetry.addData("Start wait, run ",i);
            sleep(500);
            robot.mecanumDriveStraightAlongZero(0.5,1.1,2);
            final int moveTime = 1500; //ms
            final int collectTime = 1000; //ms
            double now = time.milliseconds();
            long newTime = System.currentTimeMillis();
            int elapsedTime = (int)(newTime - StartTime);
            System.out.println(elapsedTime);
            telemetry.addData("Time elapsed ", elapsedTime);
            if (elapsedTime < moveTime){
                int sleepTime = moveTime - (int)elapsedTime;
                telemetry.addData("sleep Time",sleepTime);
                sleep(sleepTime);
                telemetry.addData("collects left",steps - i);
                telemetry.update();
                sleep(collectTime);
            }
            else {
                telementary.addData("Error: Moving time took ", now);
                telementary.update();
            }
        }
    }
}