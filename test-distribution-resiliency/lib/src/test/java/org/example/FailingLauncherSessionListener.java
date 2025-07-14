package org.example;

import org.junit.platform.launcher.LauncherSession;
import org.junit.platform.launcher.LauncherSessionListener;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FailingLauncherSessionListener implements LauncherSessionListener {

    @Override
    public void launcherSessionOpened(LauncherSession session) {
        var localPath = Paths.get("/Users/pshevche/dev/reproducers/test-distribution-resiliency/settings.gradle.kts");
        if (!Files.exists(localPath)) {
            throw new RuntimeException("Severe infrastructure error on remote agent only! Can't recover!");
        }
    }
}
