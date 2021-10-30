package lab09.behavioral;

import java.util.concurrent.Flow;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SymbolSubscriber extends StringSubscriber {
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(Object item) {
        Pattern symbol = Pattern.compile("[,!@#$%&*()_+=|<>?{}\\\\[\\\\]~-]");
        Matcher hasSymbol = symbol.matcher(item.toString());
        if(hasSymbol.find()) {
            System.out.println("Symbol subscriber: " + item);
        }
    }
}
