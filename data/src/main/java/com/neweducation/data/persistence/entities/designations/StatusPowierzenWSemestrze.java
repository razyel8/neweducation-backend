package com.neweducation.data.persistence.entities.designations;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Transient;

public enum StatusPowierzenWSemestrze {
	WersjaRobocza(1), 
	DoAkceptacji(2), 
	Zaakceptowane(3), 
	Nieaktualne(4);
	public PowierzeniaWSemestrze powierzeniaWSemestrze;
	
    private StatusPowierzenWSemestrze(int value) {
        this.value = value;
    }
	
	@Transient
    private int value;
	
	@Transient
    private static Map<Integer ,StatusPowierzenWSemestrze> map = new HashMap<>();
    
    static {
        for (StatusPowierzenWSemestrze enumLabel : StatusPowierzenWSemestrze.values()) {
            map.put(enumLabel.value, enumLabel);
        }
    }
    
    public static StatusPowierzenWSemestrze valueOf(int enumVal) {
        return map.get(enumVal);
    }

    public int getValue() {
        return value;
    }
}