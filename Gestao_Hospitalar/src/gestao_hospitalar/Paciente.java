
package gestao_hospitalar;

public class Paciente extends Pessoa {
    protected String nomeConvenio;
    protected String numeroConvenio;
    
    public Paciente(String nome, String id, String cpf, String end, String contato, int diaNasc, int mesNasc,int anoNasc,
            String nomeConvenio, String numConvenio){
        super(nome, id, cpf, end, contato, diaNasc, mesNasc, anoNasc);
        
        this.nomeConvenio = nomeConvenio;
        this.numeroConvenio = numConvenio;
    }

    public String getNomeConvenio() {
        return nomeConvenio;
    }

    public void setNomeConvenio(String nomeConvenio) {
        this.nomeConvenio = nomeConvenio;
    }

    public String getNumeroConvenio() {
        return numeroConvenio;
    }

    public void setNumeroConvenio(String numeroConvenio) {
        this.numeroConvenio = numeroConvenio;
    }

    @Override
    public void imprimir(){
        super.imprimir();
        System.out.println("Nome Convênio  : " + nomeConvenio);
        System.out.println("Número Convênio: " + numeroConvenio);
    }
}
