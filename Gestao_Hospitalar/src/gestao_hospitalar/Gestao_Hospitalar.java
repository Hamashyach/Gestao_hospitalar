package gestao_hospitalar;

import java.util.Scanner;

public class Gestao_Hospitalar {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Paciente[] pacientes = new Paciente[100];
        Medico[] medicos = new Medico[100];
        Atendimento[] atendimentos = new Atendimento[100];

        GerenciaMedicos gm = new GerenciaMedicos(medicos);
        GerenciaPacientes gp = new GerenciaPacientes(pacientes);
        GerenciaAtendimentos ga = new GerenciaAtendimentos(atendimentos);

        int op1, op2;

        do {
            System.out.println("--==[Gestão Hospitalar]==--");
            System.out.println("1 - Médicos");
            System.out.println("2 - Pacientes");
            System.out.println("3 - Atendimentos");
            System.out.println("4 - Sair");
            System.out.print("Opção: ");
            op1 = scanner.nextInt();
            scanner.nextLine();

            switch (op1) {
                case 1:
                    do {
                        System.out.println("--==[Médicos]==--");
                        System.out.println("1 - Cadastrar");
                        System.out.println("2 - Alterar");
                        System.out.println("3 - Excluir");
                        System.out.println("4 - Consultar");
                        System.out.println("5 - Relatório");
                        System.out.println("6 - Voltar ao menu principal");
                        System.out.print("Opção: ");
                        op2 = scanner.nextInt();
                        scanner.nextLine();

                        switch (op2) {
                            case 1:
                                gm.cadastrar();
                                break;
                            case 2:
                                gm.alterar();
                                break;
                            case 3:
                                gm.excluir();
                                break;
                            case 4:
                                gm.consultar();
                                break;
                            case 5:
                                gm.relatorio();
                                break;
                            case 6:
                            break;
                            default:
                                System.out.println("ERRO TENTE NOVAMENTE");
                                break;
                        }
                    } while (op2 != 6);
                    break;
                case 2:
                    do {
                        System.out.println("--==[Pacientes]==--");
                        System.out.println("1 - Cadastrar");
                        System.out.println("2 - Alterar");
                        System.out.println("3 - Excluir");
                        System.out.println("4 - Consultar");
                        System.out.println("5 - Relatório");
                        System.out.println("6 - Voltar ao menu principal");
                        System.out.print("Opção: ");
                        op2 = scanner.nextInt();
                        scanner.nextLine();

                        switch (op2) {
                            case 1:
                                gp.cadastrar();
                                break;
                            case 2:
                                gp.alterar();
                                break;
                            case 3:
                                gp.excluir();
                                break;
                            case 4:
                                gp.consultar();
                                break;
                            case 5:
                                gp.relatorio();
                                break;
                            case 6:
                            break;
                            default:
                                System.out.println("ERRO TENTE NOVAMENTE");
                                break;
                        }
                    } while (op2 != 6);
                    break;
                case 3:
                    do {
                        System.out.println("----[Atendimentos]----");
                        System.out.println("1 - Cadastrar atendimento");
                        System.out.println("2 - Alterar estado de atendimento");
                        System.out.println("3 - Listar atendimentos");
                        System.out.println("4 - Excluir atendimentos");
                        System.out.println("5 - Voltar ao menu principal");
                        System.out.print("Opção: ");
                        op2 = scanner.nextInt();
                        scanner.nextLine();

                        switch (op2) {
                            case 1:
                                ga.cadastrar();
                                break;
                            case 2:
                                ga.alterar();
                                break;
                            case 3:
                                ga.listar();
                                break;
                            case 4:
                                ga.excluir();
                                break;
                            case 5:
                            break;1
                            
                            default:
                                System.out.println("ERRO TENTE NOVAMENTE");
                                break;
                        }

                    } while (op2 != 5);
                    break;
                default:
                    System.out.println("ERRO TENTE NOVAMENTE");
                    break;
            }
        } while (op1 != 4);
    }
}
