package company;

import java.util.HashSet;
import java.util.Set;

public enum QuoteRepo {

    INSTANCE;
    
    private final Set<String> quotes = new HashSet<>();

    public void save(String quote) {
        quotes.add(quote);
    }

    public boolean contains(String quote) {
        return quotes.contains(quote);
    }

    public int size() {
        return quotes.size();
    }

}
