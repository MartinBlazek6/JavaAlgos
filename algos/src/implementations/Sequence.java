package implementations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sequence {
    public static void main(String[] args) {
        int[] numbers = {5, 4, 0, 0, -1, 0, 2, 0, 0, 5, 5, 0, 0, 0, 9};
        System.out.println("There are: " + algo(numbers) + " sequences in this array");

    }

    static int algo(int[] input) {
        //hodím si pole čísel ako jeden String
        final String[] numbersAsString = {""};
        Arrays.stream(input).forEach(x -> numbersAsString[0] += x + ""); // <- loopujem každý znak a pripojím k strungu.
        //Dá sa použiť aj stringbuilder, ale nejak som sa rozhodol takto :D

        // Vytvorím aj List sekvencii, kde budem mat jednotlivé sekvencie, stane sa ale že ak je napr
        // 00 tak to medzi nulou sa zaradí ako sekvencia s hodnotou "". Pre toto mám List Cleared, kde to prečistím
        List<String> ListOfSequences;
        List<String> ListOfSequencesCleared = new ArrayList<>();
        // cez .split si rozdelím hodnoty v liste oddelovákom čo je regex: "0"
        ListOfSequences = List.of(numbersAsString[0].split("0"));
        // loopujem celý list a ukladám do čistého len to kde nie je "". Takže sekvencia, ktorá vznikla, tak
        // že maḿ 00 a nie napr 050560 atď.
        for (var x : ListOfSequences) {
            if (!x.equals("")) {
                ListOfSequencesCleared.add(x);
            }
        }
        //Teraz mám List kde sú sekvencie napr 54,-1,2,55,9. To znamená že .size mi napíše že je tam 5 sekvencii.
        return ListOfSequencesCleared.size();
    }
}
