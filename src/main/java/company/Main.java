package company;


import java.io.IOException;

import static company.SearchService.search;

public class Main {

    public static void main(String[] args) {
        int[] num = {45, 2, 100, 3, 1};
        System.out.println(search(num, 100));
        try {
            QuoteService.INSTANCE.showQuote();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}