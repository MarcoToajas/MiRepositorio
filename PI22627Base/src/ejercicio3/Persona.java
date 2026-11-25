package ejercicio3;

public record Persona(Integer id, String nombre, Integer nacimiento, String ciudad) {

    public static Persona ofFormat(String[] formato) {
        return new Persona(Integer.valueOf(formato[0].trim()), formato[1].trim(),
                Integer.valueOf(formato[2].trim()), formato[3].trim());
    }

    @Override
    public String toString() {
        return nombre + " (" + id + ")";
    }
}
