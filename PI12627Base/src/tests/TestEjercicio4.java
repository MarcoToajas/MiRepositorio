package tests;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.math3.fitting.WeightedObservedPoint;

import ejercicios.Ejercicio4;
import us.lsi.common.Pair;
import us.lsi.common.String2;
import us.lsi.curvefitting.DataFile;
import us.lsi.curvefitting.Fit;
import us.lsi.curvefitting.GenData;
import us.lsi.curvefitting.PowerLog;
import us.lsi.graphics.MatPlotLib;

public class TestEjercicio4 {
	
	private static Integer nMin = 500; // n mínimo para el cálculo de potencia
	private static Integer nMax = 200000; // n máximo para el cálculo de potencia
	private static Integer razon = 6770; // incremento en los valores de n del cálculo de potencia
	private static Integer nIter = 20; // número de iteraciones para cada medición de tiempo
	private static Integer nIterWarmup = 1000; // número de iteraciones para warmup
	
private static Double a = 3.;
	
	public static void genData (Consumer<Integer> algorithm, String file) {
		Function<Integer,Long> f1 = GenData.time(algorithm);
		GenData.tiemposEjecucionAritmetica(f1,file,nMin,nMax,razon,nIter,nIterWarmup);

	}
	
	public static void show(Fit pl, String file, String label) {
		List<WeightedObservedPoint> data = DataFile.points(file);
		pl.fit(data);
		MatPlotLib.show(file, pl.getFunction(), String.format("%s = %s",label,pl.getExpression()));
	}
	
	public static void showCombined() {
		MatPlotLib.showCombined("Tiempos",
				List.of("\PI12627Base\resources\datos\salida",
						"C:\\Users\\marco\\OneDrive\\Documentos\\UNIVERSIDAD\\Asignaturas 2º\\ADDA\\LAB\\PI12627Base\\resources\\datos\\salida",
						"C:\\Users\\marco\\OneDrive\\Documentos\\UNIVERSIDAD\\Asignaturas 2º\\ADDA\\LAB\\PI12627Base\\resources\\datos\\salida"
						"C:\\Users\\marco\\OneDrive\\Documentos\\UNIVERSIDAD\\Asignaturas 2º\\ADDA\\LAB\\PI12627Base\\resources\\datos\\salida"), 
				List.of("RecDouble",
						"RecBig",
						"ItDouble",
						"ItBig"));
	}

	public static void main(String[] args) {
		
		
		
	}

}