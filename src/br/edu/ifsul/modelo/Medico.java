/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import br.edu.ifsul.modelo.Paciente;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author romulo
 */
@Entity
@Table(name="medico")
@Inheritance(strategy = InheritanceType.JOINED)
public class Medico extends Paciente implements Serializable{
    
    @NotNull(message = "O CRM deve ser informado")
    @NotBlank(message = "O CRM não pode ser branco")
    @Length(max = 15, message = "O CRM não pode ter mais que {max} caracteres")
    @Column(name = "crm", length = 15, nullable = false,unique = true)
    private String crm;
    
    @NotNull(message = "A especialidade deve ser informada")
    @ManyToOne
    @JoinColumn(name = "especialidade", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_medico_especialidade")
    private Especialidade especialidade;
    
    public Medico(){
        
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    
    
}
