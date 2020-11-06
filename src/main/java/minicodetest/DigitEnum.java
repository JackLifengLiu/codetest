package minicodetest;

import java.util.Arrays;

public enum DigitEnum {
	ONE(1, ""), TWO(2, "a, b, c"), THREE(3, "d, e, f"), FOUR(4, "g, h, i"), FIVE(5, "j, k, l"), SIX(6,
			"m, n, o"), SEVEN(7, "p, q, r, s"), EIGHT(8, "t, u, v"), NINE(9, "w, x, y, z"), ZERO(0, "");

	private int key;
	private String value;
	
	DigitEnum(int key, String value) {
        this.value = value;
        this.key = key;
    }

	public String getValue() {
        return value;
    }

    public int getKey() {
        return key;
    }
    
    public static String getValue(int key) { 
    	
        for (DigitEnum d : DigitEnum.values()) {  
            if (d.getKey() == key) {  
                return d.getValue();  
            }  
        }  
        return null;  
    } 
}
