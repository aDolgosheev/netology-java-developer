package task_03;

import task_02.GameProgress;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {

    public static void main(String[] args) {

        openZip("C:\\_java\\other\\Games\\savegames\\zip_savegames.zip", "C:\\_java\\other\\Games\\savegames\\");
        openProgress("C:\\_java\\other\\Games\\savegames\\save03.dat");

    }

    public static void openZip(String zipFilePath, String unzipFolderPath) {
        try (ZipInputStream zin = new ZipInputStream(new
                FileInputStream(zipFilePath))) {
            ZipEntry entry;
            String name;
            while ((entry = zin.getNextEntry()) != null) {
                name = entry.getName();
                FileOutputStream fout = new FileOutputStream(unzipFolderPath + name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void openProgress(String savegameFilePath) {
        GameProgress saveGame = null;
        try (FileInputStream fis = new FileInputStream(savegameFilePath);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            saveGame = (GameProgress) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(saveGame);
    }
}
