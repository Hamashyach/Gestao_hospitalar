
package gestao_hospitalar;
import java.util.Scanner;

public class GerenciaPacientes {
    private final Paciente pacientes[];
    private final Scanner scanner;

    public GerenciaPacientes(Paciente pats[]) {
        pacientes = pats;
        scanner = new Scanner(System.in);
    }

    public void cadastrar() {
        String nome, id, cpf, end, contato, nomeConvenio, numeroConvenio;
        int diaNasc, mesNasc, anoNasc;

        int i = 0;
        while ((i < pacientes.length) && (pacientes[i] != null)) {
            i++;
        }
        if (i < pacientes.length) {
            System.out.println("--==[Cadastro de Pacientes]==--");
            System.out.println("Nome: ");
            nome = scanner.nextLine();
            System.out.println("Identidade: ");
            id = scanner.nextLine();
            System.out.println("C.P.F.: ");
            cpf = scanner.nextLine();
            System.out.println("Endereço: ");
            end = scanner.nextLine();
            System.out.println("Contato: ");
            contato = scanner.nextLine();
            System.out.println("Dia de nascimento: ");
            diaNasc = Integer.parseInt(scanner.nextLine());
            System.out.println("Mes de nascimento: ");
            mesNasc = Integer.parseInt(scanner.nextLine());
            System.out.println("Ano de nascimento: ");
            anoNasc = Integer.parseInt(scanner.nextLine());
            System.out.println("Nome convenio: ");
            nomeConvenio = scanner.nextLine();
            System.out.println("Numero convenio: ");
            numeroConvenio = scanner.nextLine();

            pacientes[i] = new Paciente(nome, id, cpf, end, contato, diaNasc, mesNasc, anoNasc, nomeConvenio, numeroConvenio);
        } else {
            System.out.println("Vetor cheio.");
        }
    }

    public void alterar() {
        String nome, id, cpf, end, contato;
        int pos, resp;

        System.out.println("--==[Alteração de Pacientes]==--");
        System.out.println("Insira o C.P.F. que deseja alterar: ");
        cpf = scanner.nextLine();

        pos = -1;
        for (int i = 0; i < pacientes.length; i++) {
            if (pacientes[i] != null && pacientes[i].getCpf().equals(cpf)) {
                pos = i;
                break;
            }
        }

        if (pos != -1) {
            System.out.println("-=[Dados]=-");
            System.out.println("Nome atual: " + pacientes[pos].getNome());
            System.out.println("Alterar? (1-sim/2-não)");
            resp = scanner.nextInt();
            scanner.nextLine();
            if (resp == 1) {
                System.out.println("Digite o novo nome: ");
                nome = scanner.nextLine();
                pacientes[pos].setNome(nome);
            }
            System.out.println("----------------------------------");
            System.out.println("Identidade atual: " + pacientes[pos].getIdentidade());
            System.out.println("Alterar? (1-sim/2-não)");
            resp = scanner.nextInt();
            scanner.nextLine();
            if (resp == 1) {
                System.out.println("Digite a nova identidade: ");
                id = scanner.nextLine();
                pacientes[pos].setIdentidade(id);
            }
            System.out.println("----------------------------------");
            System.out.println("C.P.F. atual: " + pacientes[pos].getCpf());
            System.out.println("Alterar? (1-sim/2-não)");
            resp = scanner.nextInt();
            scanner.nextLine();
            if (resp == 1) {
                System.out.println("Digite o novo C.P.F.: ");
                cpf = scanner.nextLine();
                pacientes[pos].setCpf(cpf);
            }
            System.out.println("----------------------------------");
            System.out.println("Endereço atual: " + pacientes[pos].getEndereco());
            System.out.println("Alterar? (1-sim/2-não)");
            resp = scanner.nextInt();
            scanner.nextLine();
            if (resp == 1) {
                System.out.println("Digite o novo Endereço: ");
                end = scanner.nextLine();
                pacientes[pos].setEndereco(end);
            }
            System.out.println("----------------------------------");
            System.out.println("Contato atual: " + pacientes[pos].getContato());
            System.out.println("Alterar? (1-sim/2-não)");
            resp = scanner.nextInt();
            scanner.nextLine();
            if (resp == 1) {
                System.out.println("Digite o novo Contato: ");
                contato = scanner.nextLine();
                pacientes[pos].setContato(contato);
            }
            System.out.println("----------------------------------");

            System.out.println("Atualização realizada com sucesso.");
        } else {
            System.out.println("Paciente com o C.P.F. informado não encontrado.");
        }
    }

    public void excluir() {
        String cpf;
        int resp;

        System.out.println("--==[Exclusão de Pacientes]==--");
        System.out.println("Insira o C.P.F. que deseja excluir: ");
        cpf = scanner.nextLine();

        int pos = -1; // Inicializa a posição como -1 (não encontrado)
        for (int i = 0; i < pacientes.length; i++) {
            if (pacientes[i] != null && pacientes[i].getCpf().equals(cpf)) {
                pos = i; // Armazena a posição do paciente encontrado
                break; // Sai do loop se encontrar
            }
        }

        if (pos != -1) { // Se o paciente foi encontrado
            System.out.println("-=[Dados do Paciente]=-");
            pacientes[pos].imprimir();
            System.out.println("\nConfirma exclusão? (1-sim/2-não)");
            resp = scanner.nextInt();
            scanner.nextLine();

            if (resp == 1) {
                pacientes[pos] = null;
                System.out.println("Exclusão efetuada com sucesso.");
            } else {
                System.out.println("Exclusão não efetuada.");
            }
        } else {
            System.out.println("Paciente com o C.P.F. informado não encontrado.");
        }
    }

    public void consultar() {
        String cpf;

        System.out.println("--==[Consulta de Pacientes]==--");
        System.out.println("Insira o C.P.F. que deseja consultar: ");
        cpf = scanner.nextLine();

        int pos = -1;
        for (int i = 0; i < pacientes.length; i++) {
            if (pacientes[i] != null && pacientes[i].getCpf().equals(cpf)) {
                pos = i; // Armazena a posição do paciente encontrado
                break; // Sai do loop se encontrar
            }
        }

        if (pos != -1) { // Se o paciente foi encontrado
            System.out.println("-=[Dados do Paciente]=-");
            pacientes[pos].imprimir();
        } else {
            System.out.println("Paciente com o C.P.F. informado não encontrado.");
        }
    }

    public void relatorio() {
        System.out.println("--==[Relatório de Pacientes]==--");

        boolean found = false;
        for (Paciente paciente : pacientes) {
            if (paciente != null) {
                paciente.imprimir();
                System.out.println("\n-----------------------------------\n");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Nenhum paciente cadastrado.");
        }
    }

    public String retorna() {
        int pos;
        String nome;

        pos = scanner.nextInt();
        scanner.nextLine();

        if (pacientes[pos] != null) {
            nome = pacientes[pos].getNome();
            return nome;
        } else {
            return null;
        }
    }
}