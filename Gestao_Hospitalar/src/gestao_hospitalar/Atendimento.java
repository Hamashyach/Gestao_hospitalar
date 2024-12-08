
package gestao_hospitalar;

import java.util.Date;


public class Atendimento {
    private String medico;
    private String paciente;
    private String estado;
    private Date dataAtendimento;
    
    public Atendimento(String medico, String paciente, String estado, Date dataAtendimento){
       this.medico = medico;
       this.paciente = paciente;
       this.estado = estado;
       this.dataAtendimento = dataAtendimento;
    }
    
    public String getMedico() { 
        return medico; 
    }
    
    public void setMedico(String medico) { 
        this.medico = medico; 
    }
    
   
    public String getPaciente() { 
        return paciente; 
    }
  
    public void setPaciente(String paciente) { 
        this.paciente = paciente; 
    }
    
    public String getEstado() { 
        return estado; 
    }
    
    public void setEstado(String estado) { 
        this.estado = estado; 
    }
    
    public Date getDataAtendimento(){
        return dataAtendimento;
    }
    
    public void setDataAtendimento(Date dataAtendimento){
        this.dataAtendimento = dataAtendimento;
    }
    
    public void imprimir(){
        System.out.println("Medico.         : " + medico);
        System.out.println("Paciente  : " + paciente);
        System.out.println("Estado  :" + estado);
        System.out.println("Data do atendimento  : " + dataAtendimento);
    }

   
     
    
}
