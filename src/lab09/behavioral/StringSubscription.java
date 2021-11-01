package lab09.behavioral;

import java.util.concurrent.Flow;

public class StringSubscription implements Flow.Subscription {
    Flow.Subscriber subscriber;
    String item;
    public long counter;

    public StringSubscription(Flow.Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public void request(long n) {
        if (n < 0) {
            this.subscriber.onError(new IllegalStateException());
        }
        else {
            this.counter = n;
        }
    }

    @Override
    public void cancel() {
        System.out.println("Cancel");
    }

    public void publishItem(String str) {
        this.item = str;

        //request counter
        for(int i=0; i<counter; i++) {
            subscriber.onNext(item);
        }
        subscriber.onComplete();
    }
}
