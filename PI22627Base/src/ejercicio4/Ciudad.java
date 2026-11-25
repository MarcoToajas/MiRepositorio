package ejercicio4;

public record Ciudad(String nombre, Integer puntuacion) {

    public Ciudad {
        if (puntuacion < 1 || puntuacion > 5)
            throw new IllegalArgumentException("La puntuación debe pertenecer a [1,5]");
    }

    public static Ciudad ofFormat(String[] formato) {
        return new Ciudad(formato[0].trim(), Integer.valueOf(formato[1].replace("p", "").trim()));
    }

    @Override
    public String toString() {
        return nombre;
    }
}
