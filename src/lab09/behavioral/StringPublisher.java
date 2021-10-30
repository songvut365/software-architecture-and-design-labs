package lab09.behavioral;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class StringPublisher implements Flow.Publisher {
    List<StringSubscription> subscriptions = new ArrayList<>();

    @Override
    public void subscribe(Flow.Subscriber subscriber) {
        StringSubscription subscription = new StringSubscription(subscriber);
        subscriptions.add(subscription);
        subscriber.onSubscribe(subscription);
    }

    public void publishString(String str) {
        for(StringSubscription subscription : subscriptions) {
            subscription.publishItem(str);
        }
    }
}
