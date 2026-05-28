package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI {
    public static Double lerDouble(Scanner sc, String msgPrompt, String msgErro, double min, double max) {
        while (true) {
            try {
                System.out.print(msgPrompt);
                Double valor = sc.nextDouble();
                if (valor < min || valor > max) throw new IllegalArgumentException();
                sc.nextLine();
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("ERRO: Formato inválido.\n...");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.printf(msgErro);
                sc.nextLine();
            }
        }
    }

    public static <T extends Enum<T>> T lerEnum(Scanner sc, Class<T> enumGenerico, String msgPrompt, String msgErro) {
        while (true) {
            try {
                System.out.print(msgPrompt);
                String entrada = sc.next().toUpperCase();
                return Enum.valueOf(enumGenerico, entrada);
            } catch (IllegalArgumentException e) {
                System.out.println(msgErro);
                sc.nextLine();
            }
        }
    }
}
