package ex4;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Robo[] robos = new Robo[2];

        for (int i = 0; i < 2; i++) {
            robos[i] = new Robo();
        }

        System.out.println();

        int opc = 0;
        boolean quit = false;

        for (int i = 0; i < 2; i++) {
            quit = false;
            while (!quit) {
                if (robos[i].getStatusAtual().equals("DESLIGADO")) {

                    System.out.println("Ligar robo " + (i + 1) + "?" +
                            "\n(1)Sim" +
                            "\n(2)Não");

                    opc = sc.nextInt();
                    sc.nextLine();

                    if (opc == 1) {
                        robos[i].ligar();
                    } else if (opc == 2) {
                        quit = true;
                    }

                    System.out.println(robos[i]);
                }

                if (robos[i].getStatusAtual().equals("LIGADO") || robos[i].getStatusAtual().equals("PARADO")) {

                    System.out.println("\nRobo " + (i + 1));
                    System.out.println("(1)Andar" +
                            "\n(2)Desligar");
                    opc = sc.nextInt();
                    sc.nextLine();

                    if (opc == 1) {
                        System.out.print("\nCoordenadas para onde o robo " + (i + 1) + " deve ir (x,y)?" +
                                "\nX: ");
                        int x = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Y: ");
                        int y = sc.nextInt();
                        sc.nextLine();
                        robos[i].andar(x, y);

                    } else {
                        robos[i].desligar();
                        quit = true;
                    }

                    System.out.println(robos[i]);

                }

                if (robos[i].getStatusAtual().equals("ANDANDO")) {
                    System.out.println("\nRobo " + (i + 1));
                    System.out.println("(1)Aspirar" +
                            "\n(2)Parar");
                    opc = sc.nextInt();
                    sc.nextLine();

                    if (opc == 1) {
                        System.out.println("\nQuantidade que o robo " + (i + 1) + " deve aspirar?" +
                                "\n(Limite máximo = " + robos[i].getLimPo() + ")");
                        int qtd = sc.nextInt();
                        sc.nextLine();

                        for (int j = 0; j < qtd; j++) {
                            boolean sucesso = robos[i].aspirar(1);
                            if (!sucesso) {
                                break;
                            }
                        }

                    }

                    System.out.println(robos[i]);
                    robos[i].parar();
                }
            }
        }
    }
}
