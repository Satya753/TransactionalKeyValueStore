package org.example;

import java.util.Scanner;

public class Client {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
         KeyValueStore keyValueStore = new KeyValueStore();
        TransactionStack transactionStack = new TransactionStack(keyValueStore);
        TransactionIdGenerator generator  = new TransactionIdGenerator();

        System.out.println("Starting new DB Connection");
        String tid = null;
        while(true){
            String inputString = scanner.nextLine();
            String[] op = inputString.split("\\s+");
            Operation operation = null;
            if (op.length==3) {
                operation = new Operation(op[0], op[1], op[2]);
                System.out.println(op[0] + " " + op[1]  + " " + op[2]);
            }
            else if (op.length==2)
                operation = new Operation(op[0] , op[1]);
            else{
                operation = new Operation(op[0]);
            }

            if (op[0].equals("end"))
                break;
            if (op[0].equals("BEGIN"))
                tid = generator.generateId();
            transactionStack.addOperation(tid , operation);

        }
    }
}
