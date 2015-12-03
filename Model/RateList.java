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
public class RateList {
    private ArrayList<Rate> rateList;
    
    public RateList()
    {
        rateList = new ArrayList<Rate>();
    }
    
    public RateList(Rate rate)
    {
        rateList = new ArrayList<Rate>();
        rateList.add(rate);
    }
    
    private ArrayList getList()
    {
        return rateList;
    }
    
}
