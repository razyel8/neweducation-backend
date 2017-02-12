package com.neweducation.data.persistence.entities.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Transient;

public enum RodzajStudiow {
	Stacjonarne(1), Niestacjonarne(2);
	public ArrayList<Kierunek> kierunki = new ArrayList<Kierunek>();
    
    private RodzajStudiow(int value) {
        this.value = value;
    }
	
	@Transient
    private int value;
	
	@Transient
    private static Map<Integer ,RodzajStudiow> map = new HashMap<>();
    
    static {
        for (RodzajStudiow enumLabel : RodzajStudiow.values()) {
            map.put(enumLabel.value, enumLabel);
        }
    }
    
    public static RodzajStudiow valueOf(int enumVal) {
        return map.get(enumVal);
    }


    public int getValue() {
        return value;
    }
}