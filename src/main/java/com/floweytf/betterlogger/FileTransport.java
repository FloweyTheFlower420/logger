package com.floweytf.betterlogger;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class FileTransport extends Transport{
    public FileTransport(String fileName, int level) {
        try {
            File f = new File(fileName);
            if(!f.getParentFile().exists())
                f.getParentFile().mkdirs();
            f.createNewFile();
            this.stream = new FileOutputStream(f);
        }
        catch (Exception e) {
            System.out.println("uh oh");
            System.exit(-1);
        }

        this.level = level;
        this.p = (String s) -> { return s.replaceAll("\u001B\\[[;\\d]*m", ""); };
    }

    public FileTransport(String fileName, int level, PostOutTransform p) {
        this(fileName, level);
        this. p = p;
    }
}
