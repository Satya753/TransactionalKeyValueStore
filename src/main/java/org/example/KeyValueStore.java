package org.example;

import java.util.HashMap;
import java.util.Map;

public class KeyValueStore {
    private Map< String , String > keyValue;

    public KeyValueStore(){
        this.keyValue = new HashMap<>();
    }
    public String get(String id){
        if (this.keyValue.containsKey(id))
            return this.keyValue.get(id);
        return null;

    }
    public void set(String id , String value){
        this.keyValue.put(id , value);
    }
    public void remove(String id){
        this.keyValue.remove(id);
    }




}
