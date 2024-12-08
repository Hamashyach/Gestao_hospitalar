package gestao_hospitalar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GerenciaAtendimentos {
    private final Atendimento[] atendimentos;
    private Scanner scanner;

    public GerenciaAtendimentos(Atendimento[] atendimentos) {
        this.atendimentos = atendimentos;
        this.scanner = new Scanner(System.in);
    }

    public void cadastrar() {
        int i = 0;
        while ((i < atendimentos.length) && (atendimentos[i] != null)) {
            i++;
        }
        if (i < atendimentos.length) {
            System.out.println("--- Cadastro Atendimento ---");
            System.out.print("Nome do médico: ");
            String nomeMedico = scanner.nextLine();
            System.out.print("Nome do paciente: ");
            String nomePaciente = scanner.nextLine();
            System.out.println("Selecione o estado do atendimento:");
            System.out.println("0 - ENTRADA");
            System.out.println("1 - TRATAMENTO CLINICO GERAL");
            System.out.println("2 - PREPARAÇÃO PRÉ CIRURGIA");
            System.out.println("3 - CIRURGIA");
            System.out.println("4 - PÓS CIRURGIA");
            System.out.println("5 - ALTA CLÍNICA");
            int estadoIndex = scanner.nextInt();
            scanner.nextLine();
            String estado = "";
            switch (estadoIndex) {
                case 0: estado = "ENTRADA"; break;
                case 1: estado = "TRATAMENTO CLINICO GERAL"; break;
                case 2: estado = "PREPARAÇÃO PRÉ CIRURGIA"; break;
                case 3: estado = "CIRURGIA"; break;
                case 4: estado = "PÓS CIRURGIA"; break;
                case 5: estado = "ALTA CLÍNICA"; break;
                default: 
                    System.out.println("Estado inválido.");
                    return;
            }
            System.out.print("Data do atendimento: (dd/MM/yyyy) ");
            String dataString = scanner.nextLine();

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date dataAtendimento = null;

            try {
                dataAtendimento = formatter.parse(dataString);
            } catch (Exception e) {
                System.out.println("Erro ao converter a data. Formato esperado: dd/MM/yyyy");
                return; 
            }

            atendimentos[i] = new Atendimento(nomeMedico, nomePaciente, estado, dataAtendimento);
            System.out.println("Atendimento cadastrado com sucesso!");
        } else {
            System.out.println("Vetor cheio.");
        }
    }

    public void alterar() {
        System.out.println("---- Alteração de Atendimentos ----");
        System.out.print("Digite o nome do paciente: ");
        String nomePaciente = scanner.nextLine();

        Atendimento atendimento = buscarAtendimentoPorPaciente(nomePaciente);
        if (atendimento == null) {
            System.out.println("Atendimento não encontrado para o paciente especificado.");
            return;
        }

        System.out.print("Digite o nome do médico: ");
        String nomeMedico = scanner.nextLine();

        if (!atendimento.getMedico().equals(nomeMedico)) {
            System.out.println("Apenas o médico que cadastrou o atendimento pode alterar o estado!");
            return;
        }

        System.out.println("-=[ Dados Atuais ]=-");
        System.out.println("Nome do Médico: " + atendimento.getMedico());
        System.out.println("Nome do Paciente: " + atendimento.getPaciente());
        System.out.println("Estado atual: " + atendimento.getEstado());

        System.out.println("Selecione o novo estado do atendimento:");
        System.out.println("0 - ENTRADA");
        System.out.println("1 - TRATAMENTO CLINICO GERAL");
        System.out.println("2 - PREPARAÇÃO PRÉ CIRURGIA");
        System.out.println("3 - CIRURGIA");
        System.out.println("4 - PÓS CIRURGIA");
        System.out.println("5 - ALTA CLÍNICA");
        int novoEstadoIndex = scanner.nextInt();
        scanner.nextLine();
        String novoEstado = "";
        switch (novoEstadoIndex) {
            case 0: novoEstado = "ENTRADA "; break;
            case 1: novoEstado = "TRATAMENTO CLINICO GERAL"; break;
            case 2: novoEstado = "PREPARAÇÃO PRÉ CIRURGIA"; break;
            case 3: novoEstado = "CIRURGIA"; break;
            case 4: novoEstado = "PÓS CIRURGIA"; break;
            case 5: novoEstado = "ALTA CLÍNICA"; break;
            default: 
                System.out.println("Estado inválido.");
                return;
        }
        atendimento.setEstado(novoEstado);
        System.out.println("Estado de atendimento alterado para: " + novoEstado);
    }

    public void excluir() {
        System.out.println("--==[Excluir Atendimento]==--");
        System.out.print("Digite o nome do paciente: ");
        String nomePaciente = scanner.nextLine();

        Atendimento atendimento = buscarAtendimentoPorPaciente(nomePaciente);
        if (atendimento == null) {
            System.out.println("Atendimento não encontrado para o paciente especificado.");
            return;
        }

        for (int i = 0; i < atendimentos.length; i++) {
            if (atendimentos[i] != null && atendimentos[i].getPaciente().equals(nomePaciente)) {
                atendimentos[i] = null;
                System.out.println("Atendimento do paciente " + nomePaciente + " excluído com sucesso!");
                return;
            }
        }
    }

    private Atendimento buscarAtendimentoPorPaciente(String nomePaciente) {
        for (Atendimento atendimento : atendimentos) {
            if (atendimento != null && atendimento.getPaciente().equals(nomePaciente)) {
                return atendimento;
            }
        }
        return null;
    }

    public void listar() {
        System.out.println("--==[Lista de Atendimentos]==--");
        for (Atendimento atendimento : atendimentos) {
            if (atendimento != null) {
                System.out.println("Médico: " + atendimento.getMedico());
                System.out.println("Paciente: " + atendimento.getPaciente());
                System.out.println("Estado: " + atendimento.getEstado());
                System.out.println("Data: " + atendimento.getDataAtendimento());
                System.out.println("--------------------------------");
            }
        }
    }
}