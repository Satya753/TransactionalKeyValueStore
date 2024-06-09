package org.example;

public class Operation {

    private String type;
    private String key;
    private String value;

    public Operation(String type , String  key , String value){
        this.type = type;
        this.key = key;
        this.value = value;
    }
    public Operation(String type , String key){
        this.type = type;
        this.key = key;
    }
    public Operation(String type){
        this.type = type;
    }


    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
