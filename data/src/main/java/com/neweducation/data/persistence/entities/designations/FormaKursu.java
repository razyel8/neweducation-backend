package com.neweducation.data.persistence.entities.designations;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Transient;

public enum FormaKursu {
	Laboratorium(1), Wyklad(2), Cwiczenia(3), Projekt(4), Seminarium(5);
	
	@Transient
    private int value;
	
	@Transient
    private static Map<Integer ,FormaKursu> map = new HashMap<>();
    
    static {
        for (FormaKursu pageType : FormaKursu.values()) {
            map.put(pageType.value, pageType);
        }
    }
    
    public static FormaKursu valueOf(int pageType) {
        return map.get(pageType);
    }
    
    private FormaKursu(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}