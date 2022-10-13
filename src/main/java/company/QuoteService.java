package company;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public enum QuoteService {

    INSTANCE;

    public void showQuote() throws IOException, InterruptedException {
        boolean decision = true;
        Scanner scanner = new Scanner(System.in);
        String text;
        do {
            System.out.println("Type exit to close application");
            System.out.println("Type Next to see new Quote");
            System.out.println("    --- Next ---");
            text = scanner.nextLine();
            if (text.toLowerCase(Locale.ROOT).equals("exit")) {
                decision = false;
            } else if (text.toLowerCase(Locale.ROOT).equals("next")) {
                QuoteDownloader.INSTANCE.printRandomQuote();
            } else {
                decision = false;
                try {
                    throw new Exception("Wrong input try to type next or Next");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } while (decision);
    }
}
