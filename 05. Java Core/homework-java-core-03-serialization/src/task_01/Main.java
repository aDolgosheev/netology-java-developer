package task_01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String mainPathName = "C:\\_java\\other\\Games\\";
        StringBuilder logs = new StringBuilder();
        String[] arrayPathFolders = {"src", "res", "savegames", "temp", "src\\main", "src\\test", "res\\drawables",
                "res\\vectors", "res\\icons"};
        List<String> list = new ArrayList<>();
        Collections.addAll(list, arrayPathFolders);
        for (String name : list) {
            createFolder(mainPathName, name, logs);
        }

        Map<String, String> mapPathFiles = new HashMap<>();
        mapPathFiles.put("Main.java", "src\\main\\");
        mapPathFiles.put("Utils.java", "src\\main\\");
        mapPathFiles.put("temp.txt", "temp");
        for (Map.Entry<String, String> file : mapPathFiles.entrySet()) {
            createFile(mainPathName, file, logs);
        }
    }

    public static void createFolder(String mainPathName, String folderName, StringBuilder logs) {
        if (new File(mainPathName + folderName).mkdir()) {
            logs.append("Folder \"").append(folderName).append("\" has been created.\n");
        } else {
            logs.append("ERROR! Folder \"").append(folderName).append("\" has not been created.\n");
        }
    }

    public static void createFile(String mainPathName, Map.Entry<String, String> file, StringBuilder logs) {
        try {
            File newFile = new File(mainPathName + file.getValue(), file.getKey());
            if (newFile.createNewFile()) {
                logs.append("File \"").append(file.getKey()).append("\" has been created.\n");
            } else {
                logs.append("ERROR! File \"").append(file.getKey()).append("\" has not been created.\n");
            }
            if (newFile.getName().contains(".txt")) {
                try (FileWriter writer = new FileWriter(newFile)) {
                    writer.write(logs.toString());
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
