import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FailoPavadinimasIrMasyvas extends Failobazineinformacija{
    int[] book1Masyvas = new int[10000];

    public FailoPavadinimasIrMasyvas(String failoPavadinimas, int[] book1Masyvas) {
        this.failoPavadinimas = failoPavadinimas;
        this.book1Masyvas = book1Masyvas;
    }

    public FailoPavadinimasIrMasyvas() {
    }

    public void surusiuojam(int[] array) {
        boolean swapped;
        int n = array.length;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    public void arrayYFaila(int[] book2Masyvas) {
        String book2 = "C:\\MokymoDarbai\\05_13_Paskaita\\Book2.csv";
        try (FileWriter writer = new FileWriter(book2)) {
            for (int i = 0; i < book2Masyvas.length; i++) {
                writer.append(Integer.toString(book2Masyvas[i]));
                if (i != book2Masyvas.length - 1) {
                    writer.append(",");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String naujas = "Failo pavadinimas: " + failoPavadinimas + " Failo turinys: [";
        String skaiciai="";
        for (int i = 0; i < book1Masyvas.length; i++) {
            if(book1Masyvas[i] != 0) {
                skaiciai += book1Masyvas[i]+",";
            }
        }
       return naujas+skaiciai+"] ";
    }
}

