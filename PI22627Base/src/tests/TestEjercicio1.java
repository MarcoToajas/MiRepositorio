package tests;

import ejercicio1.Ejercicio1Binary;
import ejercicio1.Ejercicio1Nary;
import us.lsi.common.String2;
import java.util.stream.Stream;
import us.lsi.streams.Stream2;
import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.Tree;

public class TestEjercicio1 {

    public static void main(String[] args) {
        testEjercicio1Binary();
        testEjercicio1Nary();
    }

    private static void testEjercicio1Binary() {
        String2.toConsole("\nEJERCICIO 1 - Binary");
        try (Stream<String> lineas = Stream2.file("resources/Ejercicio1.txt")) {
            lineas.forEach(linea -> {
                BinaryTree<Character> tree = BinaryTree.parse(linea, s -> s.charAt(0));
                String2.toConsole("Árbol: %s\nResultado: %s", tree, Ejercicio1Binary.palindromos(tree));
            });
        }
    }

    private static void testEjercicio1Nary() {
        String2.toConsole("\nEJERCICIO 1 - Nary");
        try (Stream<String> lineas = Stream2.file("resources/Ejercicio1.txt")) {
            lineas.forEach(linea -> {
                Tree<Character> tree = Tree.parse(linea, s -> s.charAt(0));
                String2.toConsole("Árbol: %s\nResultado: %s", tree, Ejercicio1Nary.palindromos(tree));
            });
        }
    }
}
