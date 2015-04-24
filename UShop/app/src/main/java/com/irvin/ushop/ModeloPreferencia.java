package com.irvin.ushop;

/**
 * Created by Irvin on 23/04/2015.
 */
public class ModeloPreferencia {
    String name;
    int value;

    ModeloPreferencia(String name, int value){
        this.name = name;
        this.value = value;
    }

    public String getName(){
        return this.name;
    }

    public int getValue(){
        return this.value;
    }
}
