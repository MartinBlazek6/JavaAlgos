package implementations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClosestNumber {
    public static void main(String[] args) {
        int[] numbers = {3, 0, -1, 7, 2, 1, -8, 2};
        System.out.println("Closest Number to 0 is:  " + algo(numbers));
    }

    static int algo(int[] input) {

        // Dám si pole do listu, lebo sa mi s ním lepšie robí
        List<Integer> numbers = new ArrayList<>();
        Arrays.stream(input).forEach(numbers::add);
        //List si zoradím od najmenšieho po najvačšie
        Collections.sort(numbers);
        // pole pre najbližšie číslo zo zápornej a kladnej hodnoty
        int[] posAndNeg = new int[2];

        //hľadám najblišie kladné číslo
        for (var x : numbers) {
            if (x > 0) {
               // keď nájdem uložím si a vyskočím z loopu
                posAndNeg[0] = x;
                break;
            }
        }
        //otočím si zoradenie listu čísel
        //hľadám najblišie záporné číslo
        Collections.reverse(numbers);
        for (var x : numbers) {
            if (x < 0) {
                // keď nájdem uložím si a vyskočím z loopu, ešte prehodím na pozitívnu hodnotu
                posAndNeg[1] = (x * (-1));
                break;
            }
        }
        // ak je pozitívne číslo menšie alebo rovné tak returnem pozitívne číslo, v opačnom prípade vrátim záporné
        //zas do zápornej hodnoty a returnem to. Takto sa uistím že má prednost vždy pozitívne
        return posAndNeg[0] <= posAndNeg[1] ? posAndNeg[0] : posAndNeg[1] * (-1);
    }
}
