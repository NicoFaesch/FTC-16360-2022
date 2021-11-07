package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.lib.Globals;
import org.firstinspires.ftc.teamcode.lib.hardware.Robot;

//@Disabled
@Autonomous(group = "opmodes")
public class Auto_Red_Inner extends LinearOpMode {

    Auto_Base base;

    @Override
    public void runOpMode() throws InterruptedException {

        // initialize auto
        base = new Auto_Base(hardwareMap, telemetry, Auto_Base.StartPos.RED_INNER);

        waitForStart();

        if (isStopRequested()) return;

        while(opModeIsActive() && !isStopRequested()) {
            // clear cache for bulk reading
            for (LynxModule module : this.hardwareMap.getAll(LynxModule.class)) {
                module.clearBulkCache();
            }

            base.update();
        }
    }
    //Globals.currentPose = base.robot.drive.getPoseEstimate();
}