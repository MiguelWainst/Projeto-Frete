package util;

import java.util.InputMismatchException;
import java.util.List;
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

    public static Object lerLista(Scanner sc, List<?> lista, String msgPrompt, String msgErro) {
        int escolha;
        while (true) {
            try {
                System.out.print(msgPrompt); // Pede qual escolha será feita.
                escolha = sc.nextInt();
                if (escolha <=0 || escolha > lista.size()) {
                    throw new IllegalArgumentException();
                }
                return escolha;
            } catch (InputMismatchException e) {
                System.out.println("ERRO: Formato inválido\n...");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.print(msgErro);
                sc.nextLine();
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
    }

    public static char lerChar(Scanner sc, String msgPrompt, String msgErro) {
        char resp;
        while (true) {
            try {
                System.out.println(msgPrompt);
                resp = sc.next().charAt(0);
                if (resp != 's' && resp != 'n')
                    throw new IllegalArgumentException();
                return resp;
            } catch (InputMismatchException e) {
                System.out.println("ERRO: Input é inválido.\n...");
            } catch (IllegalArgumentException e) {
                System.out.println(msgErro);
            }
        }
    }
}
