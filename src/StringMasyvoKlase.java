import java.util.Objects;

public class StringMasyvoKlase {
    String[] book1Masyvas = new String[10000];

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
}
