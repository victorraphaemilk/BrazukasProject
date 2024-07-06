package projeto;

import projeto.Gerente;
import projeto.Jogador;
import projeto.Tecnico;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    
    static Scanner sc = new Scanner(System.in);
    static Gerente gerente = new Gerente();
    static Tecnico tecnico = new Tecnico();
    
    public static void main(String[] args) throws InterruptedException {

        Gerente.CarregarTimes();
        int opcao = 0;

        do {
            menuInicial();
            System.out.print("Digite sua opção: ");
            
            while (true) {
                try {
                    opcao = sc.nextInt();
                    break; // Se a entrada for válida, sair do loop
                } catch (Exception e) {
                    System.out.println("Digite um inteiro: ");
                    sc.next(); // Consumir a entrada inválida
                }
            }
            

            switch (opcao) {
                case 1:
                    int opcaoGerente = 0;
                    do {
                        menuGerente();
                        try {
                        opcaoGerente = sc.nextInt();

                        switch (opcaoGerente) {
                            case 1:
                                gerente.mostrarJogadores();
                                Thread.sleep(2000);
                                break;
                            case 2:
                                gerente.adicionarAoTime(Jogador.CriarJogador());
                                break;
                            case 3:
                                removerJogador();
                                //gerente.removerDoTime(nome);
                                break;
                            case 0:
                                System.out.println("Voltando para o menu inicial...");
                                Thread.sleep(1500);
                                break;
                            default:
                                System.err.println("Opção inválida, digite novamente");
                                Thread.sleep(2000);
                                break;
                        }
                        } catch (InputMismatchException e) {
                            System.err.println("Entrada inválida. Por favor, insira um número.");
                            sc.next(); // Limpa a entrada inválida
                        }
                    } while (opcaoGerente != 0);

                    break;
                case 2:
                    int opcaoTecnico = 0;
                    do {
                        menuTecnico();
                        try {
                        opcaoTecnico = sc.nextInt();

                        switch (opcaoTecnico) {
                            case 1:
                                adcionarTiular();
                                break;
                            case 2:
                                removerTiular();
                                break;
                            case 3:
                                tecnico.mostrarJogadores();
                                Thread.sleep(1500);
                                break;
                            case 0:
                                System.out.println("Voltando para o menu inicial...");
                                Thread.sleep(1500);
                                break;
                            default:
                                System.err.println("Opção inválida, digite novamente");
                                Thread.sleep(2000);
                                break;

                        }
                        } catch (InputMismatchException e) {
                            System.err.println("Entrada inválida. Por favor, insira um número.");
                            sc.next(); // Limpa a entrada inválida
                        }
                    } while (opcaoTecnico != 0);
                    break;
                case 0:
                    System.out.println("Finalizando o programa...");
                    Thread.sleep(1500);
                    break;
                default:
                    System.err.println("Opção inválida, digite novamente");
                    Thread.sleep(2000);
            }
        } while (opcao != 0);
       gerente.GravarTimes(gerente);
    } // End static method main

    public static void menuInicial() {
        System.out.println("                    $$$$$$$\\  $$$$$$$\\   $$$$$$\\  $$$$$$$$\\ $$\\   $$\\ $$\\   $$\\  $$$$$$\\   $$$$$$\\  $$$$$$$$\\  $$$$$$\\   $$$$$$\\ $$$$$$$$\\ \n" +
                "                  $$  __$$\\ $$  __$$\\ $$  __$$\\ \\____$$  |$$ |  $$ |$$ | $$  |$$  __$$\\ $$  __$$\\ $$  _____|$$  __$$\\ $$  __$$\\\\__$$  __|\n" +
                "                  $$ |  $$ |$$ |  $$ |$$ /  $$ |    $$  / $$ |  $$ |$$ |$$  / $$ /  $$ |$$ /  \\__|$$ |      $$ /  $$ |$$ /  $$ |  $$ |   \n" +
                "                  $$$$$$$\\ |$$$$$$$  |$$$$$$$$ |   $$  /  $$ |  $$ |$$$$$  /  $$$$$$$$ |\\$$$$$$\\  $$$$$\\    $$ |  $$ |$$ |  $$ |  $$ |   \n" +
                "                  $$  __$$\\ $$  __$$< $$  __$$ |  $$  /   $$ |  $$ |$$  $$<   $$  __$$ | \\____$$\\ $$  __|   $$ |  $$ |$$ |  $$ |  $$ |   \n" +
                "                  $$ |  $$ |$$ |  $$ |$$ |  $$ | $$  /    $$ |  $$ |$$ |\\$$\\  $$ |  $$ |$$\\   $$ |$$ |      $$ |  $$ |$$ |  $$ |  $$ |   \n" +
                "                  $$$$$$$  |$$ |  $$ |$$ |  $$ |$$$$$$$$\\ \\$$$$$$  |$$ | \\$$\\ $$ |  $$ |\\$$$$$$  |$$ |       $$$$$$  | $$$$$$  |  $$ |   \n" +
                "                  \\_______/ \\__|  \\__|\\__|  \\__|\\________| \\______/ \\__|  \\__|\\__|  \\__| \\______/ \\__|       \\______/  \\______/   \\__|   \n" +
                "                                                                                                                       \n" +
                "                                                           SEU SISTEMA DE GERENCIAMENTO FAVORITO!!                                                       \n" +
                "                                                                                                                       ");

        System.out.println("1 - Entrar como gerente");
        System.out.println("2 - Entrar como técnico");
        System.out.println("0 - Sair");
    }

    public static void menuGerente() {
        System.out.println("\n=== Menu do Gerente ===");
        System.out.println("1 - Visualizar Jogadores");
        System.out.println("2 - Adicionar Jogador");
        System.out.println("3 - Remover Jogador");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void removerNomeOuCamisa() {
        System.out.println("Escolha se deseja pesquisar por Nome ou Camisa");
        System.out.println("1 - Remover por nome ");
        System.out.println("2 - Remover por numero da camisa ");
        System.out.print("Digite sua opção: ");
    }

    public static void adicionarNomeOuCamisa() {
        System.out.println("Escolha se deseja pesquisar por Nome ou Camisa");
        System.out.println("1 - Adcionar por nome ");
        System.out.println("2 - Adcionar por numero da camisa ");
        System.out.print("Digite sua opção: ");
    }

    public static void removerJogador() {

        int opcao;
        boolean loop = true;
        while (loop) {
        	try {
            removerNomeOuCamisa();
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.print("Diga o nome do jogador: ");
                    String nome = sc.next();
                    gerente.removerDoTime(nome);
                    loop = false;
                    break;
                case 2:
                    System.out.print("Diga o numero do jogador: ");
                    int numero = sc.nextInt();
                    gerente.removerDoTime(numero);
                    loop = false;
                    break;
                default:
                    System.out.println("Opção inválida, digite novamente!!");

            }
        	} catch (InputMismatchException e) {
                System.err.println("Entrada inválida. Por favor, insira um número.");
                sc.next(); // Limpa a entrada inválida
            }
        }
    }

    public static void adcionarTiular() {
        int opcao;
        boolean loop = true;
        while (loop) {
        	try {
            adicionarNomeOuCamisa();
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.print("Diga o nome do jogador: ");
                    String nome = sc.next();
                    tecnico.adicionarTitular(nome);
                    loop = false;
                    break;
                case 2:
                    System.out.print("Diga o numero do jogador: ");
                    int numero = sc.nextInt();
                    tecnico.adicionarTitular(numero);
                    loop = false;
                    break;
                default:
                    System.out.println("Opção inválida, digite novamente!!");

            }
        	} catch (InputMismatchException e) {
                System.err.println("Entrada inválida. Por favor, insira um número.");
                sc.next(); // Limpa a entrada inválida
            }
        }
    }

    public static void removerTiular() {
        int opcao;
        boolean loop = true;
        while (loop) {
        	try {
            removerNomeOuCamisa();
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.print("Diga o nome do jogador: ");
                    String nome = sc.next();
                    tecnico.removerTitular(nome);
                    loop = false;
                    break;
                case 2:
                    System.out.print("Diga o numero do jogador: ");
                    int numero = sc.nextInt();
                    tecnico.removerTitular(numero);
                    loop = false;
                    break;
                default:
                    System.out.println("Opção inválida, digite novamente!!");

            }
        	} catch (InputMismatchException e) {
                System.err.println("Entrada inválida. Por favor, insira um número.");
                sc.next(); // Limpa a entrada inválida
            }
        }
    }

    public static void menuTecnico() {
        System.out.println("\n=== Menu do Técnico ===");
        System.out.println("1 - Adicionar Jogador titular");
        System.out.println("2 - Remover Jogador titular");
        System.out.println("3 - Visualizar jogadores");
        System.out.println("0 - Sair");
    }
} // End class Main
