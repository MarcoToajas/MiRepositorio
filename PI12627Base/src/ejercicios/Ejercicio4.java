package ejercicios;

import java.math.BigInteger;

public class Ejercicio4 {
	
	public static Double funcRecDouble(Integer a) { 
		Double r = null;
		if (a<10) {
			r = 5.0;
		} else {
			r = Math.sqrt(3*a)*funcRecDouble(a-2);
		}
        return r;
	}
	
	public static BigInteger funcRecBig(Integer a) {
		BigInteger r = BigInteger.ZERO;
		if (a<10) {
			r = BigInteger.valueOf(5);
		} else {
			r =BigInteger.valueOf(3L*a).sqrt().multiply(funcRecBig(a-2));
		}
        return r;
	}
	
	public static Double funcItDouble(Integer a) {
		Double r = 1.;
		while (a>=10) {
			r = r * Math.sqrt(3*a);
			a = a-2;
		}
        return r*5;
	}
	
	public static BigInteger funcItBig(Integer a) {
		BigInteger r = BigInteger.ONE;
		while (a>=10) {
			r = r.multiply(BigInteger.valueOf(3L*a).sqrt());
			a = a - 2;
		}
        return r.multiply(BigInteger.valueOf(5));
	}
}