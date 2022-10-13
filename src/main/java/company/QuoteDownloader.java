package company;


import com.google.gson.Gson;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

public enum QuoteDownloader {

    INSTANCE;

    private static final int QUOTE_LIMIT;
    private static final String ALL_QUOTES_URL = "https://github.com/ajzbc/kanye.rest/blob/master/quotes.json";
    private static final String RANDOM_QUOTE_URL = "https://api.kanye.rest/";

    private final Gson gson = new Gson();
    private final QuoteRepo quoteRepo = QuoteRepo.INSTANCE;

    static {
        int limit = 0;
        try {
            HttpResponse<String> response = ApiFetcher.INSTANCE.downloadQuote(ALL_QUOTES_URL);
            String body = response.body();
            List<String> quotes = List.of(body.substring(2, body.length() - 2).split(","));
            limit = quotes.size();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        QUOTE_LIMIT = limit;
    }

    private QuoteResponse downloadQuote() throws IOException, InterruptedException {
        HttpResponse<String> response = ApiFetcher.INSTANCE.downloadQuote(RANDOM_QUOTE_URL);
        return gson.fromJson(response.body(), QuoteResponse.class);
    }

    public void printRandomQuote() throws IOException, InterruptedException {
        if (quoteRepo.size() >= QUOTE_LIMIT) {
            System.out.println("All quotes downloaded");
            return;
        }
        String quote = "";
        do {
            QuoteResponse quoteResponse = downloadQuote();
            quote = quoteResponse.getQuote();
        } while (quoteRepo.contains(quote));
        quoteRepo.save(quote);
        System.out.println(quote);
    }
}
