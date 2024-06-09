package org.example;

public interface Transaction {

    public void beginTransaction(String id);

    public void rollbackTransaction();

    public void endTransaction();
    public void commitTransaction(String tid);


}
