/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Teddy
 */
public class StorageList {
    private ArrayList<Storage> storageList;
    
    public StorageList()
    {
        storageList = new ArrayList<Storage>();
    }
    
    public StorageList(Storage storage)
    {
        storageList = new ArrayList<Storage>();
        storageList.add(storage);
    }
    
    public void addStorage(Storage addstorage)
    {
        storageList.add(addstorage);
    }
    
    public ArrayList getList()
    {
        return storageList;
    }
}
