
package gestao_hospitalar;

public class Medico extends Pessoa{
    protected String crm;
    protected String especialidade;
    
    public Medico(String nome, String id, String cpf, String end, String contato,int diaNasc, int mesNasc,int anoNasc,
            String crm, String esp){
        super(nome, id, cpf, end, contato, diaNasc, mesNasc, anoNasc);
        this.crm = crm;
        especialidade = esp;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

        
    @Override
    public void imprimir(){
        super.imprimir();
        System.out.println("C.R.M.         : " + crm);
        System.out.println("Especialidade  : " + especialidade);
     
    }
}
