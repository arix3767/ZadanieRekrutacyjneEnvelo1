package company;

import java.util.Arrays;

public class SearchService {

    protected static boolean search(int[] numbers, int x) {
        boolean exist = false;
        Arrays.sort(numbers);
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] != x) {
                continue;
            } else {
                exist = true;
            }
        }
        return exist;
    }
    // szacowana złożoność obliczeniowa: O(n)
    // szacowana złożoność pamięciowa: O(n)
}
