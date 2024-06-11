package org.example;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TransactionStack implements  Transaction {

    private Stack< String > transactionStack ;
    private KeyValueStore globalStore;

    private Map< String , TransactionKV > transactionMap;
    public TransactionStack(KeyValueStore globalStore){
        transactionStack = new Stack<>();
        transactionMap = new HashMap<>();
        this.globalStore = globalStore;
    }
    public void beginTransaction(String tid){
        transactionMap.put(tid, new TransactionKV(tid, this.globalStore));
        transactionStack.push(tid);
    }
    public void rollbackTransaction(){
        transactionMap.get(transactionStack.peek()).removeAll();
        transactionStack.pop();
    }
    public void endTransaction(){
        transactionStack.pop();
    }

    public void commitTransaction(String tid){
        transactionMap.get(transactionStack.peek()).executeTransaction();
        transactionStack.pop();
    }
    public void addOperation(String tid , Operation op){

        if (op.getType().equals("BEGIN")){
            beginTransaction(tid);
        }
        else if (op.getType().equals("COMMIT")){
            commitTransaction(tid);
        }
        else if (op.getType().equals("END")){
            endTransaction();
        }
        else if (op.getType().equals("ROLLBACK")){
            rollbackTransaction();
        }
        else {
            transactionMap.get(tid).addOperation(op);
        }
    }



}
