package ejercicios;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ejercicios.Ejercicio3.Tupla;


public class Ejercicio3 {
	public static record Tupla(Integer a, Integer b, Integer c) {
		public static Tupla of(Integer a, Integer b, Integer c) {
			return new Tupla(a, b, c);
		}
	}
	
	public static Set<Integer> ejercicio3RecursivoSinMemoria(Integer a, Integer b, Integer c) { 
		Set<Integer> set = new HashSet<>();
		if (a<=5 || b<=3 || c<= 2) {
			set.add(a+2);
			set.add(b*3);
			set.add(c);
		} else if (a<=8 || b<=6 || c<= 4){
			set.add(a);
			set.add(b+2);
			set.add(c*3);
		} else {
			set.addAll(ejercicio3RecursivoSinMemoria(a/2,b-3,c/4));
			set.addAll(ejercicio3RecursivoSinMemoria(a-3,b/3,c-2));
		}
		return set;
	}
	
	public static Set<Integer> ejercicio3RecursivoConMemoria(Integer a, Integer b, Integer c) {
		return ejercicio3RecursivoConMemoria(a,b,c,new HashMap<>());	
	}
	
	public static Set<Integer> ejercicio3RecursivoConMemoria(Integer a, Integer b, Integer c, HashMap<Tupla,Set<Integer>> m) {
		Set<Integer> set = new HashSet<>();
		Tupla t = Tupla.of(a, b, c);
		if (m.containsKey(t)) {
			set.addAll(m.get(t));
		} else {
			if (a<=5 || b<=3 || c<= 2) {
				set.add(a+2);
				set.add(b*3);
				set.add(c);
			} else if (a<=8 || b<=6 || c<= 4){
				set.add(a);
				set.add(b+2);
				set.add(c*3);
			} else {
				set.addAll(ejercicio3RecursivoConMemoria(a/2,b-3,c/4));
				set.addAll(ejercicio3RecursivoConMemoria(a-3,b/3,c-2));
			}
			m.put(t, set);
		}
		return set;	
	}
	
	public static Set<Integer> ejercicio3Iterativo(Integer a, Integer b, Integer c) {
		Map<Tupla,Set<Integer>> map = new HashMap<>();
		for (int i = 0;i<=a;i++) {
			for (int j = 0;j<=b;j++) {
				for (int k = 0;k<=c;k++) {
					Set<Integer> v = new HashSet<>();
					if (i<=5 || j<=3 || k<= 2) {
						v.add(i+2);
						v.add(3*j);
						v.add(k);
					} else if (i<=8 || j<=6 || k<= 4) {
						v.add(i);
						v.add(j+2);
						v.add(k*3);
					} else {
						Set<Integer> s1 = map.get(Tupla.of(i/2, j-3, k/4));
						Set<Integer> s2 = map.get(Tupla.of(i-3, j/3, k-2));
						v.addAll(s1);
						v.addAll(s2);
					}
					map.put(Tupla.of(i, j, k), v);
				}
			}
		}
		return map.get(Tupla.of(a, b, c));
	}
}
