package lab09.behavioral;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPublisher implements Flow.Publisher {
    List<StringSubscription> subscriptions = new ArrayList<>();
    private String StringBuffer;

    @Override
    public void subscribe(Flow.Subscriber subscriber) {
        StringSubscription subscription = new StringSubscription(subscriber);
        subscriptions.add(subscription);
        subscriber.onSubscribe(subscription);
    }

    //Publish String
    public void publishString(String str) {
        StringBuffer = str;

        //loop all subscription
        for(StringSubscription subscription : subscriptions) {

            //check subscriber type
            if(subscription.subscriber instanceof AlphabetSubscriber && hasPattern("[a-zA-z]")) {
                subscription.publishItem(StringBuffer);
            }
            if(subscription.subscriber instanceof NumberSubscriber && hasPattern("[0-9]")) {
                subscription.publishItem(StringBuffer);
            }
            if(subscription.subscriber instanceof SymbolSubscriber && hasPattern("[,!@#$%&*()_+=|<>?{}\\\\[\\\\]~-]")) {
                subscription.publishItem(StringBuffer);
            }
        }
    }

    private boolean hasPattern( String pattern) {
        Pattern stringItem = Pattern.compile(pattern);
        Matcher result = stringItem.matcher(StringBuffer);
        return result.find();
    }

}
