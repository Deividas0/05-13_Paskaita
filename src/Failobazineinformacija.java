import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Failobazineinformacija {
    String failoPavadinimas;
    String failoVieta;
    String failoDydis;

    public static String getFileSizeInKB(Path path) {
        try {
            long sizeInBytes = Files.size(path);
            long sizeInKB = sizeInBytes / 1024;
            return sizeInKB + " KB";
        } catch (IOException e) {
            System.err.println("Unable to determine file size: " + e.getMessage());
            return "Error";
        }
    }
}
