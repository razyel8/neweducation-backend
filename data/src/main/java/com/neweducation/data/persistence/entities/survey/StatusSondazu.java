package com.neweducation.data.persistence.entities.survey;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Transient;

import com.neweducation.data.persistence.entities.general.Sondaz;

public enum StatusSondazu {
	Aktywny(1), 
	Nieaktywny(2), 
	Zakonczony(3);
	
	
    private StatusSondazu(int value) {
        this.value = value;
    }
	
	@Transient
    private int value;
	
	@Transient
    private static Map<Integer ,StatusSondazu> map = new HashMap<>();
    
    static {
        for (StatusSondazu enumLabel : StatusSondazu.values()) {
            map.put(enumLabel.value, enumLabel);
        }
    }
    
    public static StatusSondazu valueOf(int enumVal) {
        return map.get(enumVal);
    }

    public int getValue() {
        return value;
    }
}