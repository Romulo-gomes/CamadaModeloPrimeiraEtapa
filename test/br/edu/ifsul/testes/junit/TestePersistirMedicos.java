/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Medico;
import java.util.Calendar;
import java.util.Locale;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author romulo
 */
public class TestePersistirMedicos {
    
    EntityManager em;
    
    public TestePersistirMedicos() {
    }
    
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
    }
    
    @Test
    public void teste(){
        Boolean exception = false;
        
        try {
            Medico med = new Medico();
            med.setCrm("CRM-RS 1200");
            med.setEspecialidade(em.find(Especialidade.class, 1));
            med.setNome("Cecilia");
            med.setDataNascimento(Calendar.getInstance());
            med.setTelefone("(54)99999-1111");
            med.setSexo("Feminino");
            med.setHistorico("Nesse campo é colocado um resumo do que esta acontecendo com o paciente, ficando assim sem limite de caracter, assim segue tudo normal");
            med.setPeso(69.9);
            med.setAltura(1.78);
            
            em.getTransaction().begin();
            em.persist(med);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
    }
}