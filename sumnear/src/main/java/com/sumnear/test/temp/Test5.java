package com.sumnear.test.temp;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Test5 {
    public static void main(String[] args) throws IOException {
        File source = new File("E:\\youmo.kv.properties");
        File target = new File("E:\\zzz\\xxx\\yyy\\a.txt");
        target.getParentFile().mkdirs();
//        nFile.createNewFile();
        Files.copy(source.toPath(),target.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}
