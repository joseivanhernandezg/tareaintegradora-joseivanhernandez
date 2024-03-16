import java.util.Scanner;

public class Aerolinea {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPersonas;
        System.out.println("Bienvenido a la Calculadora de Vuelos ICESI Flight 1.0.");
        System.out.println("Te presentamos las siguientes opciones, ingresa:");
        System.out.println("¿Viaja solo o con amigos? (1 - Solo, 3 - Con dos amigos)");
        numPersonas = scanner.nextInt();

        for (int i = 1; i <= numPersonas; i++) {
            System.out.println("Persona " + i + ":");
            calcularTarifa(scanner);
        }
    }

    public static void calcularTarifa(Scanner scanner) {
        final int PRECIO_BASE_XS = 175000;
        final double PORCENTAJE_S = 0.25;
        final double PORCENTAJE_M = 0.30;
        final int PRECIO_ASIENTO = 50000;
        final int PRECIO_ASIENTO_EXTRA = 15000;
        final int PRECIO_MALETAS_10KG = 50000;
        final int PRECIO_MALETAS_23KG = 100000;
        final int MAX_MALETAS_10KG = 3;
        final int MAX_MALETAS_23KG = 2;

        System.out.println("Seleccione la tarifa (XS, S, M):");
        String tarifa = scanner.next().toLowerCase();
        int precioTarifa = PRECIO_BASE_XS;
        boolean incluyeAsiento = false;

        switch (tarifa) {
            case "s":
                precioTarifa += PRECIO_BASE_XS * PORCENTAJE_S;
                break;
            case "m":
                precioTarifa += PRECIO_BASE_XS * (PORCENTAJE_S + PORCENTAJE_M);
                incluyeAsiento = true;
                break;
        }

        int precioTotal = precioTarifa;
        if (!incluyeAsiento) {
            System.out.println("¿Desea agregar selección de asiento? (S/N):");
            if (scanner.next().equalsIgnoreCase("S")) {
                precioTotal += PRECIO_ASIENTO;
                System.out.println("¿El asiento es en pasillo o ventana? (S/N):");
                if (scanner.next().equalsIgnoreCase("S")) {
                    precioTotal += PRECIO_ASIENTO_EXTRA;
                }
            }
        }

        System.out.println("¿Cuántas maletas adicionales de 10 kg desea agregar? (0-3):");
        int maletas10kg = scanner.nextInt();
        if (maletas10kg > 0 && maletas10kg <= MAX_MALETAS_10KG) {
            precioTotal += maletas10kg * PRECIO_MALETAS_10KG;
        }

        System.out.println("¿Cuántas maletas adicionales de 23 kg desea agregar? (0-2):");
        int maletas23kg = scanner.nextInt();
        if (maletas23kg > 0 && maletas23kg <= MAX_MALETAS_23KG) {
            precioTotal += maletas23kg * PRECIO_MALETAS_23KG;
        }

        System.out.println("El precio total de la tarifa " + tarifa.toUpperCase() + " es: $" + precioTotal + " COP");
    }
}
