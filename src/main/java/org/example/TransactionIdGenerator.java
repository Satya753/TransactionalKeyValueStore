package org.example;

import java.util.Random;

public class TransactionIdGenerator implements  IdGenerator{

    private Random random = new Random();
    @Override
    public String generateId() {
        int t = random.nextInt();
        return Integer.toString(t);
    }
}
