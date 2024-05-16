import java.util.Objects;

public class StringMasyvoKlase extends Failobazineinformacija{
    String[] book1Masyvas = new String[10000];

    public StringMasyvoKlase(String failoPavadinimas, String[] book1Masyvas) {
        this.failoPavadinimas = failoPavadinimas;
        this.book1Masyvas = book1Masyvas;
    }
    public StringMasyvoKlase() {
    }


    public void surusiuojam(String[] array) {
        boolean swapped;
        int n = array.length;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (Objects.equals(array[i - 1], array[i])) {
                    String temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }
    @Override
    public String toString() {
        String naujas = "Failo pavadinimasStri: " + failoPavadinimas + " Failo turinys: [";
        String skaiciai=" ";
        for (int i = 0; i < book1Masyvas.length; i++) {
            if(book1Masyvas[i] != null) {
                skaiciai += book1Masyvas[i]+" ";
            }
        }
        return naujas+skaiciai+"] ";
    }
}
