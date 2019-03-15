package files;

import java.io.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * Created By Muhammad Ayesh
 */
public class FilesUtil implements Closeable {

    private final PrintWriter printWriter;
    private final BufferedReader fileReader;

    public FilesUtil(File file, boolean appendToFile) throws IOException {
        printWriter = new PrintWriter(new FileWriter(file, appendToFile));
        fileReader = new BufferedReader(new FileReader(file));
    }

    public static void copyFile(InputStream is, OutputStream os, long fileSize) throws IOException {
        try {
            copyStreamFile(is, os, fileSize);
        } finally {
            closeStreams(is, os);
        }
    }

    private static void copyStreamFile(InputStream is, OutputStream os, long fileSize) throws IOException {
        copyCharOrStream(is, os, fileSize);
    }

    public static void copyFile(Reader reader, Writer writer, long fileSize) throws IOException {
        try {
            copyCharFile(reader, writer, fileSize);
        } finally {
            closeStreams(reader, writer);
        }
    }

    private static void copyCharFile(Reader reader, Writer writer, long fileSize) throws IOException {
        copyCharOrStream(reader, writer, fileSize);
    }

    private static void copyCharOrStream(Object is, Object os, long fileSize) throws IOException {
        long startTime = System.currentTimeMillis();
        copy(is, os, fileSize);
        long totalTime = System.currentTimeMillis() - startTime;
        System.out.println(formatTime(totalTime, TimeUnit.MILLISECONDS));
    }

    private static void closeStreams(Closeable is, Closeable os) throws IOException {
        if (is != null) {
            is.close();
        }
        if (os != null) {
            os.close();
        }
    }

    private static void copy(Object reader, Object writer, long fileSize) throws IOException {
        if (reader instanceof Reader && writer instanceof Writer) {
            char[] buffer = new char[8192];
            int transferSize;
            long copiedBytesSize = 0;
            while ((transferSize = ((Reader) reader).read(buffer)) != -1) {
                ((Writer) writer).write(buffer, 0, transferSize);
                copiedBytesSize += transferSize;
                System.out.println(String.format("%.1f%%", 100.0 * copiedBytesSize / fileSize));
            }
        } else if (reader instanceof InputStream && writer instanceof OutputStream) {
            byte[] buffer = new byte[8192];
            int transferSize;
            long copiedBytesSize = 0;
            while ((transferSize = ((InputStream) reader).read(buffer)) != -1) {
                ((OutputStream) writer).write(buffer, 0, transferSize);
                copiedBytesSize += transferSize;
                System.out.println(String.format("%.1f%%", 100.0 * copiedBytesSize / fileSize));
            }
        }
    }

    public static String formatTime(long totalTime, TimeUnit timeUnit) {
        final long hr = TimeUnit.MILLISECONDS.toHours(totalTime);
        final long min = TimeUnit.MILLISECONDS.toMinutes(totalTime) % 60;
        final long sec = TimeUnit.MILLISECONDS.toSeconds(totalTime) % 60;
        final long ms = TimeUnit.MILLISECONDS.toMillis(totalTime) % 1000;
        if (TimeUnit.MILLISECONDS.equals(timeUnit)) {
            return String.format("%02dh: %02dm: %02dsec :%03d mill", hr, min, sec, ms);
        } else {
            return String.format("%02dh: %02dm: %02dsec", hr, min, sec);
        }
    }

    public void printLine(String line) {
        printWriter.println(line);
    }

    public void print(String text) {
        printWriter.print(text);
    }

    public String readLine() throws IOException {
        return fileReader.readLine();
    }

    public int read() throws IOException {
        return fileReader.read();
    }

    public Stream<String> lines() {
        return fileReader.lines();
    }

    public void flush() {
        printWriter.flush();
    }

    @Override
    public void close() throws IOException {
        printWriter.close();
    }
}
