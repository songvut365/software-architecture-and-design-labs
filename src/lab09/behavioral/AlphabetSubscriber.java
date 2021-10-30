package lab09.behavioral;

import java.util.concurrent.Flow;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlphabetSubscriber extends StringSubscriber {
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(Object item) {
        Pattern alphabet = Pattern.compile("[a-zA-z]");
        Matcher hasAlphabet = alphabet.matcher(item.toString());
        if(hasAlphabet.find()) {
            System.out.println("Alphabet subscriber: " + item);
        }
    }
}