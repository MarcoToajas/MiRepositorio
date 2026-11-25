package ejercicio3;

public record Parentesco(Integer id) {
    private static int num = 0;

    public static Parentesco ofFormat(String[] formato) {
        return new Parentesco(num++);
    }

    @Override
    public String toString() {
        return "Relacion-" + id;
    }
}
