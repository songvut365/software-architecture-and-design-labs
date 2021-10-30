package lab09.behavioral;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Publisher
        StringPublisher publisher = new StringPublisher();

        //Subscriber
        StringSubscriber alphabetSubscriber = new AlphabetSubscriber();
        StringSubscriber numberSubscriber = new NumberSubscriber();
        StringSubscriber symbolSubscriber = new SymbolSubscriber();

        //Publisher subscribe to subscriber
        publisher.subscribe(alphabetSubscriber);
        publisher.subscribe(numberSubscriber);
        publisher.subscribe(symbolSubscriber);

        //Publish string
        while(true) {
            System.out.println("=====================");
            System.out.print("Enter string: ");
            Scanner input = new Scanner(System.in);
            String myString = input.nextLine();
            publisher.publishString(myString);
        }
    }
}
