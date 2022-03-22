package lab09.behavioral;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Flow;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberSubscriber extends StringSubscriber {
    private Flow.Subscription subscription;
    public String pattern = "[0-9]";

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(Object item) {
        //PrintString
        try {
            FileWriter numberWriter = new FileWriter("number.txt", true);
            numberWriter.write(item.toString());
            numberWriter.close();
            System.out.println("Number subscriber: " + item);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
