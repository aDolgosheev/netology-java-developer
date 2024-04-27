package task_02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args) {
        GameProgress save01 = new GameProgress(100, 60, 10, 150.5, "save01.dat");
        GameProgress save02 = new GameProgress(58, 115, 13, 323, "save02.dat");
        GameProgress save03 = new GameProgress(12, 7, 26, 17890, "save03.dat");
        createSave(save01);
        createSave(save02);
        createSave(save03);

        createZipArchive();

        File saveFolder = new File("C:\\_java\\other\\Games\\savegames\\");
        if (saveFolder.listFiles() == null) {
            System.out.println("Папка пустая");
        } else {
            for (File file : saveFolder.listFiles()) {
                if (!file.getName().contains(".zip")) {
                    if (file.delete()) {
                        System.out.println(file.getName() + " успешно удален.");
                    } else {
                        System.out.println("Ошибка удаления файла");
                    }
                }
            }
        }

    }

    public static void createSave(GameProgress saveName) {
        try (FileOutputStream fos = new FileOutputStream("C:\\_java\\other\\Games\\savegames\\" + saveName.getName());
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(saveName);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void createZipArchive() {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("C:\\_java\\other\\Games\\savegames\\zip_savegames.zip"));
             FileInputStream fis1 = new FileInputStream("C:\\_java\\other\\Games\\savegames\\save01.dat");
             FileInputStream fis2 = new FileInputStream("C:\\_java\\other\\Games\\savegames\\save02.dat");
             FileInputStream fis3 = new FileInputStream("C:\\_java\\other\\Games\\savegames\\save03.dat")) {

            ZipEntry entry = new ZipEntry("save01.dat");
            zout.putNextEntry(entry);
            byte[] buffer = new byte[fis1.available()];
            fis1.read(buffer);
            zout.write(buffer);
            zout.closeEntry();

            entry = new ZipEntry("save02.dat");
            zout.putNextEntry(entry);
            buffer = new byte[fis2.available()];
            fis2.read(buffer);
            zout.write(buffer);
            zout.closeEntry();

            entry = new ZipEntry("save03.dat");
            zout.putNextEntry(entry);
            buffer = new byte[fis3.available()];
            fis3.read(buffer);
            zout.write(buffer);
            zout.closeEntry();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
