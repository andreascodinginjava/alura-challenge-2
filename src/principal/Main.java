package principal;

import model.CurrencyEnum;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    static Scanner sn = new Scanner(System.in);
    static Conversor conversor = new Conversor();

    public static void main(String[] args) {

        int option = 1;
        String menu = """
                \n\n*** CONVERSOR DE MONEDAS ***
                
                Sea bienvenido/a al conversor de monedas
                Programa: Alura
                Nombre: Laura Andrea Gómez Agudelo
                
                1 - Dólar a peso argentino
                2 - Peso argentino a dólar
                3 - Dólar a real brasileño
                4 - Real brasileño a dólar
                5 - Dólar a peso colombiano
                6 - Peso colombiano a dólar
                0 - Salir
                
                *****************************
                
                """;

        while (option != 0) {
            System.out.print(menu);
            System.out.print("Elige una opción válida: ");
            option = sn.nextInt();
            try {
                switch (option) {

                    case 1:
                        System.out.println(valueConvertedMessage(CurrencyEnum.USD, CurrencyEnum.ARS));
                        break;

                    case 2:
                        System.out.println(valueConvertedMessage(CurrencyEnum.ARS, CurrencyEnum.USD));
                        break;

                    case 3:
                        System.out.println(valueConvertedMessage(CurrencyEnum.USD, CurrencyEnum.BRL));
                        break;

                    case 4:
                        System.out.println(valueConvertedMessage(CurrencyEnum.BRL, CurrencyEnum.USD));
                        break;

                    case 5:
                        System.out.println(valueConvertedMessage(CurrencyEnum.USD, CurrencyEnum.COP));
                        break;

                    case 6:
                        System.out.println(valueConvertedMessage(CurrencyEnum.COP, CurrencyEnum.USD));
                        break;

                    default:
                        if (option != 0) System.out.println("\n\nOpción incorrecta, seleccione una opción válida.");
                }
            } catch (Exception exception) {
                System.out.println("\n\nHa ocurrido un error inesperado. Inténtelo de nuevo.");
                System.out.print(menu);
                System.out.print("Elige una opción válida: ");
                option = sn.nextInt();
            }
        }
    }

    private static Double getValueToConvert(CurrencyEnum currencyType) {
        System.out.print("Ingrese los (" + currencyType.name() + ") a convertir: ");
        return sn.nextDouble();
    }

    private static String valueConvertedMessage(CurrencyEnum incomming, CurrencyEnum converted) throws IOException {
        Double value = getValueToConvert(incomming);
        Double valueConverted = conversor.getConversionRate(incomming, converted, value);
        DecimalFormat df = new DecimalFormat("#.00");
        return "El valor " + value + " (" + incomming.name() + ") convertido a (" + converted + ") " +
                "es igual a: " + df.format(valueConverted) + " " + converted.name();
    }
}