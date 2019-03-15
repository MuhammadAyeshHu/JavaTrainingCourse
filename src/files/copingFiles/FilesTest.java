package files.copingFiles;
import files.FilesUtil;

import java.io.*;
public class FilesTest {
    public static final String TEST_FILE = "Files\\inputFiles\\Test File";
    public static final String OUTPUT_FILES_DIRECTORY_PATH = "Files\\outputFiles\\";

    public static void main(String[] args) throws IOException {
        File file = new File(TEST_FILE);
        File outputFile = new File(OUTPUT_FILES_DIRECTORY_PATH + file.getName());

        System.out.println("======= Write to File ========");
        try (FilesUtil util = new FilesUtil(file, false)) {
            util.printLine("This is Some Text To write into File!");
        }

        System.out.println("======= Byte Based Copy Of The File ========");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
//        FilesUtil.copyFile(fileInputStream, fileOutputStream, file.length()); // Using FileInputStream / FileOutputStream
//        FilesUtil.copyFile(new BufferedInputStream(fileInputStream), new BufferedOutputStream(fileOutputStream), file.length()); // Using Buffer

        System.out.println("======= Char Based Copy Of The File ========");
//        FilesUtil.copyFile(new FileReader(file), new FileWriter(outputFile), file.length());
        FilesUtil.copyFile(new FileReader(file), new PrintWriter(outputFile), file.length());

    }


}
