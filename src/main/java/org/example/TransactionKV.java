package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class TransactionKV{

    private Queue< Operation > operationQueue;
    private  KeyValueStore globalStore;
    private KeyValueStore localStore;


    public TransactionKV(String tid , KeyValueStore globalstore){
        operationQueue = new LinkedList<>();
        this.globalStore = globalstore;
        this.localStore = new KeyValueStore();
    }
    public void executeTransaction(){
        // Once commited write all the values to the global store from the local store and in order execution
        while(!operationQueue.isEmpty()){
            Operation op = operationQueue.poll();
            switch (op.getType()){
                case  "GET":
                    getGlobalValue(op.getKey());
                    break;
                case "SET":
                    setGlobalKey(op.getKey() , op.getValue());
                    break;
                case "DEL":
                    removeGlobalKey(op.getValue());
                    break;
            }
        }
    }
    public void removeAll(){
        this.localStore = new KeyValueStore();
    }
    public String getLocalValue(String key){
        String value = this.localStore.get(key);
        if (value!=null)
            return value;
        return this.globalStore.get(key);
    }
    public void removeLocalValue(String key){
        this.localStore.remove(key);
    }
    public void setLocalValue(String key , String value){
        this.localStore.set(key  , value);
    }

    public String getGlobalValue(String key){
        return this.globalStore.get(key);
    }

    public void setGlobalKey(String key , String value){
        this.globalStore.set(key , value);
    }
    public void removeGlobalKey(String key){
        this.globalStore.remove(key);
    }

    public void addOperation(Operation op){
        operationQueue.offer(op);
        switch (op.getType()){
            case "GET":
                System.out.println(getLocalValue(op.getKey()));
                break;
            case "SET":
                setLocalValue(op.getKey() , op.getValue());
                break;
            case "DEL":
                removeLocalValue(op.getKey());
                break;
        }
    }

}
