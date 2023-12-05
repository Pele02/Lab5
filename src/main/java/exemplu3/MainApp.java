package exemplu3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import static exemplu3.PerecheNumere.calculeazaCMMMC;
import static exemplu3.PerecheNumere.isFibonacciPair;

public class MainApp {
    public static void scriere(List<PerecheNumere> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/resources/pereche.json");
            mapper.writeValue(file, lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<PerecheNumere> citire() {
        try {
            File file = new File("src/main/resources/pereche.json");
            ObjectMapper mapper = new ObjectMapper();
            List<PerecheNumere> numere = mapper.readValue(file, new TypeReference<List<PerecheNumere>>() {
            });
            return numere;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<PerecheNumere> numere = new ArrayList<>();
        numere.add(new PerecheNumere(5, 5));
        numere.add(new PerecheNumere(6, 4));
        numere.add(new PerecheNumere(3, 7));
//        scriere(numere);
//        List<PerecheNumere> numere = citire();
//        numere.forEach(System.out::println);

        for (PerecheNumere pair : numere) {
            boolean isFibonacci = isFibonacciPair(pair.getA(), pair.getB());
            System.out.println(pair + " is Fibonacci: " + isFibonacci);

            int rezultat = calculeazaCMMMC(pair.getA(), pair.getB());
            System.out.println("CMMMC pentru " + pair + " este: " + rezultat);
        }


    }

}

