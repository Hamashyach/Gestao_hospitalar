
package gestao_hospitalar;
import java.util.Scanner;

public class GerenciaMedicos {
    private final Medico medicos[];
    private Scanner scanner;
    
    public GerenciaMedicos(Medico meds[]){
        medicos = meds;
        scanner = new Scanner(System.in);
    }
    
    public void cadastrar(){
        String nome, id, cpf, end, contato, crm, esp;
        int diaNasc, mesNasc, anoNasc;
       
        int i = 0;
        while((i < medicos.length) && (medicos[i] != null)){
            i++;
        }
        if(i < medicos.length){
            System.out.println("--==[Cadastro de Médicos]==--");
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
            System.out.println("ano de nascimento: ");
            anoNasc = Integer.parseInt(scanner.nextLine());
            System.out.println("C.R.M.: ");
            crm = scanner.nextLine();
            System.out.println("Especialidade: ");
            esp = scanner.nextLine();
            
            medicos[i] = new Medico(nome, id, cpf, end, contato, diaNasc, mesNasc, anoNasc, crm, esp);
        }
        else{
            System.out.println("Vetor cheio.");
        }
    }
    
    public void alterar(){
        String nome, id, cpf, end, contato, crm, esp;
        int pos, resp;
        
        System.out.println("--==[Alteração de Médicos]==--");
        System.out.println("Insira o C.R.M. que deseja alterar: ");
        crm = scanner.nextLine();
        
        pos = -1;
        for (int i = 0; i < medicos.length; i++) {
            if (medicos[i] != null && medicos[i].getCrm().equals(crm)) {
                pos = i;
                break;
            }
        }
        
        if (pos != -1) {
            System.out.println("-=[Dados]=-");
            System.out.println("Nome atual: " + medicos[pos].getNome());
            System.out.println("Alterar? (1-sim/2-não)");
            resp = scanner.nextInt();
            scanner.nextLine();
            if(resp == 1){
                System.out.println("Digite o novo nome: ");
                nome = scanner.nextLine();
                medicos[pos].setNome(nome);
            }
            System.out.println("----------------------------------");
            System.out.println("Identidade atual: " + medicos[pos].getIdentidade());
            System.out.println("Alterar? (1-sim/2-não)");
            resp = scanner.nextInt();
            scanner.nextLine();
            if(resp == 1){
                System.out.println("Digite a nova identidade: ");
                id = scanner.nextLine();
                medicos[pos].setIdentidade(id);
            }
            System.out.println("----------------------------------");
            System.out.println("C.P.F. atual: " + medicos[pos].getCpf());
            System.out.println("Alterar? (1-sim/2-não)");
            resp = scanner.nextInt();
            scanner.nextLine();
            if(resp == 1){
                System.out.println("Digite o novo C.P.F.: ");
                cpf = scanner.nextLine();
                medicos[pos].setCpf(cpf);
            }
            System.out.println("----------------------------------");
            System.out.println("Endereço atual: " + medicos[pos].getEndereco());
            System.out.println("Alterar? (1-sim/2-não)");
            resp = scanner.nextInt();
            scanner.nextLine();
            if(resp == 1){
                System.out.println("Digite o novo Endereço: ");
                end = scanner.nextLine();
                medicos[pos].setEndereco(end);
            }
            System.out.println("----------------------------------");
            System.out.println("Contato atual: " + medicos[pos].getContato());
            System.out.println("Alterar? (1-sim/2-não)");
            resp = scanner.nextInt();
            scanner.nextLine();
            if(resp == 1){
                System.out.println("Digite o novo Contato: ");
                contato = scanner.nextLine();
                medicos[pos].setContato(contato);
            }
            System.out.println("----------------------------------");
            System.out.println("C.R.M. atual: " + medicos[pos].getCrm());
            System.out.println("Alterar? (1-sim/2-não)");
            resp = scanner.nextInt();
            scanner.nextLine();
            if(resp == 1){
                System.out.println("Digite o novo C.R.M.: ");
                crm = scanner.nextLine();
                medicos[pos].setCrm(crm);
            }
            System.out.println("----------------------------------");
            System.out.println("Especialidade atual: " + medicos[pos].getEspecialidade());
            System.out.println("Alterar? (1-sim/2-não)");
            resp = scanner.nextInt();
            scanner.nextLine();
            if(resp == 1){
                System.out.println("Digite a nova Especialidade: ");
                esp = scanner.nextLine();
                medicos[pos].setEspecialidade(esp);
            }
            System.out.println("----------------------------------");
            
            System.out.println("Atualização realizada com sucesso.");
        }
        else {
            System.out.println("Médico com o C.R.M. informado não encontrado.");
        }
    }
    
    public void excluir(){
        String crm;
        int resp;
        
        System.out.println("--==[Exclusão de Médicos]==--");
        System.out.println("Insira o C.R.M. que deseja excluir: ");
        crm = scanner.nextLine();
        
        int pos = -1; 
        for (int i = 0; i < medicos.length; i++) {
            if (medicos[i] != null && medicos[i].getCrm().equals(crm)) {
                pos = i; 
                break; 
            }
        }
        
        if(pos != -1) { 
            System.out.println("-=[Dados do Médico]=-");
            medicos[pos].imprimir();
            System.out.println("\nConfirma exclusão? (1-sim/2-não)");
            resp = scanner.nextInt();
            scanner.nextLine();
            
            if(resp == 1){
                medicos[pos] = null;
                System.out.println("Exclusão efetuada com sucesso.");
            }
            else{
                System.out.println("Exclusão não efetuada.");
            }
        }
        else{
            System.out.println("Médico com o C.R.M. informado não encontrado.");
        }
    }
    
    public void consultar(){
        String crm;
        
        System.out.println("--==[Consulta de Médicos]==--");
        System.out.println("Insira o C.R.M. que deseja consultar: ");
        crm = scanner.nextLine();
        
        int pos = -1;
        for (int i = 0; i < medicos.length; i++) {
            if (medicos[i] != null && medicos[i].getCrm().equals(crm)) {
                pos = i; 
                break; 
            }
        }
        
        if(pos != -1) { 
            System.out.println("-=[Dados do Médico]=-");
            medicos[pos].imprimir();
        }
        else{
            System.out.println("Médico com o C.R.M. informado não encontrado.");
        }
    }
    
    public void relatorio(){
        System.out.println("--==[Relatório de Médicos]==--");
        
        boolean found = false;
        for (Medico medico : medicos) {
            if (medico != null) {
                medico.imprimir();
                System.out.println("\n-----------------------------------\n");
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("Nenhum médico cadastrado.");
        }
    }
    
    public String retorna(){
        int pos;
        String nome;
        
        pos = scanner.nextInt();
        scanner.nextLine();
        
        if(medicos[pos] != null){
           nome =  medicos[pos].getNome();
            return nome;
        }
        else{
            return null;
        }
    

    }
}
