package lab09.behavioral;

import java.util.concurrent.Flow;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberSubscriber extends StringSubscriber {
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(Object item) {
        Pattern number = Pattern.compile("[0-9]");
        Matcher hasNumber = number.matcher(item.toString());
        if(hasNumber.find()) {
            System.out.println("Number subscriber: " + item);
        }
    }
}
