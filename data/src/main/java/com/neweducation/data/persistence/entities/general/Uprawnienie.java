package com.neweducation.data.persistence.entities.general;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Transient;

public enum Uprawnienie {
    STUDENT(1), PROWADZACY(2), PELNOMOCNIK(3);
    
    private Uprawnienie(int value) {
        this.value = value;
    }
	
	@Transient
    private int value;
	
	@Transient
    private static Map<Integer ,Uprawnienie> map = new HashMap<>();
    
    static {
        for (Uprawnienie enumLabel : Uprawnienie.values()) {
            map.put(enumLabel.value, enumLabel);
        }
    }
    
    public static Uprawnienie valueOf(int enumVal) {
        return map.get(enumVal);
    }

    public int getValue() {
        return value;
    }
}