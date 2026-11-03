package ejercicios;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 {
	public static List<String> ejercicio2RecursivoNoFinal(Integer a, String s){
		List<String> res = new ArrayList<>();
		if (a<=2 || s.length()<=2) {
			res.add(a.toString() + s);
		} else if (a%2==0) {
			res.addAll(ejercicio2RecursivoNoFinal(a/2,s.substring(0, s.length()-2)));
			res.add(a.toString());
		} else {
			res.addAll(ejercicio2RecursivoNoFinal(a/3,s.substring(0, s.length()-1)));
			res.add(a.toString()+s.substring(0,a%s.length()));
		}
		return res;
	}
	
	public static List<String> ejercicio2Iterativo(Integer a, String s){
		List<String> res = new ArrayList<>();
		List<String> aux = new ArrayList<>();
		while (a>2 && s.length()>2) {
			if (a%2 == 0) {
				aux.add(a.toString());
				
				a = a/2;
				s = s.substring(0,s.length()-2);
			} else {
				aux.add(a.toString()+s.substring(0,a%s.length()));
				
				a = a/3;
				s = s.substring(0,s.length()-1);
			}
		}
		
		res.add(a.toString()+s);
		
		for (int i = aux.size()-1; i >= 0; i--) {
			res.add(aux.get(i));
		}
		return res;
	}
	
	public static List<String> ejercicio2RecursivoFinal(Integer a, String s) {
		List<String> res = new ArrayList<>();
		return ejercicio2RecursivoFinal(a,s,res);
	}
	
	public static List<String> ejercicio2RecursivoFinal(Integer a, String s, List<String> ac) {
		if (a<=2 || s.length()<=2) {
			ac.add(0,a.toString() + s);
			return ac;
		} else if (a%2==0) {
			ac.add(0,a.toString());
			return ejercicio2RecursivoFinal(a/2,s.substring(0,s.length()-2),ac);
		} else {
			ac.add(0,a.toString()+s.substring(0,a%s.length()));
			return ejercicio2RecursivoFinal(a/3,s.substring(0,s.length()-1),ac);
		}
	}

	public static List<String> ejercicio2NotacionFuncional(Integer a, String s){
		return null;
	}
	
}
