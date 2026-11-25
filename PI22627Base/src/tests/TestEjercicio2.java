package tests;

import ejercicio2.Ejercicio2Binary;
import ejercicio2.Ejercicio2Nary;
import us.lsi.common.String2;
import java.util.stream.Stream;
import us.lsi.streams.Stream2;
import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.Tree;

public class TestEjercicio2 {

    public static void main(String[] args) {
        testEjercicio2Binary();
        testEjercicio2Nary();
    }

    private static void testEjercicio2Binary() {
        String2.toConsole("\nEJERCICIO 2 - Binary");
        try (Stream<String> lineas = Stream2.file("resources/Ejercicio2.txt")) {
            lineas.forEach(linea -> {
                BinaryTree<Integer> tree = BinaryTree.parse(linea, Integer::valueOf);
                String2.toConsole("Árbol: %s\nResultado: %s", tree, Ejercicio2Binary.etiquetasPorParidad(tree));
            });
        }
    }

    private static void testEjercicio2Nary() {
        String2.toConsole("\nEJERCICIO 2 - Nary");
        try (Stream<String> lineas = Stream2.file("resources/Ejercicio2.txt")) {
            lineas.forEach(linea -> {
                Tree<Integer> tree = Tree.parse(linea, Integer::valueOf);
                String2.toConsole("Árbol: %s\nResultado: %s", tree, Ejercicio2Nary.etiquetasPorParidad(tree));
            });
        }
    }
}
