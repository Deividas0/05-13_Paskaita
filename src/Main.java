import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static String directoryPath = "C:\\MokymoDarbai\\05_13_Paskaita\\";

    public static void main(String[] args) throws FileNotFoundException {
        Failobazineinformacija fBI = new Failobazineinformacija();
        String directoryPath = "C:\\MokymoDarbai\\05_13_Paskaita\\";
        String[] manoFailai = listTextAndCsvFiles(directoryPath);

        for(int i = 0; i < manoFailai.length; i++) {
            if (manoFailai[i] != null) {
                FailoPavadinimasIrMasyvas X = priskirtiFailuDuomenis(manoFailai[i]);
                System.out.print(X);
            }
        }



//        Book1 book = new Book1();
//        Book1[] objMasyvas = new Book1[50];
//        int i = book.failasYMasyva(book.book1);
//        int[] book2Masyvas = new int[i];
//        int reiksmes = 0;
//        for (int a : book.book1Masyvas) {
//            if (a != 0) {
//                reiksmes++;
//            }
//        }
//        int skaicius = 0;
//        for (int a : book.book1Masyvas) {
//            if (a != 0) {
//                book2Masyvas[skaicius++] = a;
//            }
//        }
        //book.surusiuojam(book.book1Masyvas);                   // surusiuoja book1Masyvas
        //System.out.println(Arrays.toString(book2Masyvas));     // atspausdina surusiuota book2Masyvas ( be 0 )
        //book.arrayYFaila(book2Masyvas);                      // surusiuota Array ikelia y Book2.csv
        //listTextAndCsvFiles(directoryPath);
        //System.out.println((Arrays.toString(listTextAndCsvFiles(directoryPath))));     // spausdina visus failus esancius toi lokacijoj


    }

    public static String[] listTextAndCsvFiles(String directoryPath) {
        FailoPavadinimasIrMasyvas book = new FailoPavadinimasIrMasyvas();
        String[] manoFailai = new String[10000];
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(directoryPath), "*.{txt,csv}")) {
            int i = 0;
            for (Path a : stream) {
                manoFailai[i] = a.getFileName().toString();
                i++;

            }

        } catch (IOException | DirectoryIteratorException ex) {
            System.err.println("Error occurred: " + ex.getMessage());
        }
        return manoFailai;
    }
//    int[] book1Masyvas = new int[10000];
//    String failoPavadinimas;

    public static FailoPavadinimasIrMasyvas priskirtiFailuDuomenis(String failoPavadinimas) throws FileNotFoundException {
        FailoPavadinimasIrMasyvas book = new FailoPavadinimasIrMasyvas();
        int[] book1Masyvas = new int[10000];
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(directoryPath + "\\" + failoPavadinimas))) {
            String line;
            int i = 0;
            while ((line = bufferedReader.readLine()) != null) {
                book1Masyvas[i] = Integer.parseInt(line);
                i++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        book.book1Masyvas = book1Masyvas;
        book.failoPavadinimas = failoPavadinimas;
        book.surusiuojam(book1Masyvas);
        return book;
    }
}
