package ejercicios;

import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Ejercicio1 {
	
	public static void tests(List<ParEnteros> ls) {
		ls.forEach(t -> {
			System.out.println();
			System.out.println("1) Solucion Funcional: " + funcional(t.a(), t.b()));
			System.out.println("2) Solucion Iterativo: " + iterativo(t.a(), t.b()));
			System.out.println("3) Solucion Rec. Final: " + recFinal(t.a(), t.b()));
		});
		
	}
	
	
	public static String funcional(Integer varA, Integer varB) {	
		UnaryOperator<EnteroCadena> nx = elem ->
		{
			return EnteroCadena.of(elem.a()+3,
			elem.a()%2==0?
			elem.a()+"*":
			elem.a()+"!");
			};
			return Stream
			.iterate(EnteroCadena.of(varA,"A"), elem -> elem.a() < varB, nx)
			.filter(elem -> elem.a()%10 != 0)
			.map(elem -> elem.s())
			.collect(Collectors.joining("-"));
	}

	public static String iterativo(Integer varA, Integer varB) { 
		EnteroCadena enterocadena = new EnteroCadena(varA,"A");
		String resultado = "";
		while (enterocadena.a() < varB) {
			if (enterocadena.a()%10 != 0) {
				if (resultado == "") {
					resultado = resultado + enterocadena.s();
				} else {
				resultado = resultado + "-" + enterocadena.s();
				}
			}
			if ((enterocadena.a()+3)%2 == 0) {
				enterocadena = new EnteroCadena(enterocadena.a()+3,String.valueOf(enterocadena.a()+"!"));
			} else {
			enterocadena = new EnteroCadena(enterocadena.a()+3,String.valueOf(enterocadena.a()+"*"));
			}
		}
		return resultado;
	}
	
	public static String recFinal(Integer varA, Integer varB) {
		return recFinal("",new EnteroCadena(varA,"A"),varB);
	}
	
	public static String recFinal(String res, EnteroCadena ec, Integer varB) {
		if (ec.a() < varB) {
			if (ec.a()%10 != 0) {
				if (res == "") {
					res = res + ec.s();
				} else {
					res = res + "-" + ec.s();
				}
			}
				if ((ec.a()+3)%2 == 0) {
					ec = new EnteroCadena(ec.a()+3,ec.a()+"!");
				} else {
					ec = new EnteroCadena(ec.a()+3,ec.a()+"*");
				}
				res = recFinal(res,ec,varB);
		}
		return res;
	}
}
