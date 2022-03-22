package lab09.behavioral;

import java.io.FileWriter;
import java.io.IOException;
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
        //PrintString
        try {
            FileWriter alphabetWriter = new FileWriter("alphabet.txt", true);
            alphabetWriter.write(item.toString());
            alphabetWriter.close();
            System.out.println("Alphabet subscriber: " + item);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}