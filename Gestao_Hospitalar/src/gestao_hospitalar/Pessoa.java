
package gestao_hospitalar;

public class Pessoa {
    protected String nome;
    protected String identidade;
    protected String cpf;
    protected String endereco;
    protected String contato;
    protected int diaNascimento;
    protected int mesNascimento;
    protected int anoNascimento;
    
    
    public Pessoa(String nome, String id, String cpf, String end, String contato, int diaNasc, int mesNasc, int anoNasc){
        this.nome = nome;
        identidade = id;
        this.cpf = cpf;
        endereco = end;
        this.contato = contato;
        diaNascimento = diaNasc;
        mesNascimento = mesNasc;
        anoNascimento = anoNasc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
    
    public int getDiaNascimento() {
        return diaNascimento;
    }

    public void setDiaNascimento(int diaNasc) {
        this.diaNascimento = diaNasc;
    }
    
    public int getMesNascimento() {
        return mesNascimento;
    }

    public void setMesNascimento(int mesNasc) {
        this.mesNascimento = mesNasc;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNasc) {
        this.anoNascimento = anoNasc;
    }
    public void imprimir(){
        System.out.println("Nome           : " + nome);
        System.out.println("Identidade     : " + identidade);
        System.out.println("C.P.F.         : " + cpf);
        System.out.println("Endereço       : " + endereco);
        System.out.println("Contato       : " + contato);
        System.out.println("Data de Nascimento       : " + diaNascimento + "/" +mesNascimento + "/" + anoNascimento);
    }
}
