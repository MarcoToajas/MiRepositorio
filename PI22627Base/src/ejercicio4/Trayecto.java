package ejercicio4;

public record Trayecto(Integer id, Double precio, Double duracion) {
    private static int num = 0;

    public Trayecto {
        if (!Double.isFinite(precio) || !Double.isFinite(duracion) || precio < 0 || duracion < 0)
            throw new IllegalArgumentException("El precio y la duración deben ser finitos y no negativos");
    }

    public static Trayecto ofFormat(String[] formato) {
        double precio = Double.parseDouble(formato[2].replace("euros", "").trim());
        double duracion = Double.parseDouble(formato[3].replace("min", "").trim());
        return new Trayecto(num++, precio, duracion);
    }

    @Override
    public String toString() {
        return precio + " euros, " + duracion + " min";
    }
}
