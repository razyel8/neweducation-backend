package com.neweducation.data.persistence.entities.designations;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Transient;

import com.neweducation.data.persistence.entities.general.Powierzenie;

public enum StatusPowierzenia {
	Proponowane(1), 
	Zaakceptowane(2), 
	Niezaakceptowane(3), 
	WPrzygotowaniu(4);
	public Powierzenie powierzenie;
	
    private StatusPowierzenia(int value) {
        this.value = value;
    }
    
	@Transient
    private int value;
	
	@Transient
    private static Map<Integer ,StatusPowierzenia> map = new HashMap<>();
    
    static {
        for (StatusPowierzenia enumLabel : StatusPowierzenia.values()) {
            map.put(enumLabel.value, enumLabel);
        }
    }
    
    public static StatusPowierzenia valueOf(int enumVal) {
        return map.get(enumVal);
    }

    public int getValue() {
        return value;
    }
}