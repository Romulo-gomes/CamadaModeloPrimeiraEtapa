/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Consulta;
import br.edu.ifsul.modelo.Medicamento;
import br.edu.ifsul.modelo.Receituario;
import java.util.Calendar;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author romulo
 */
public class TestePersistirReceituario {
    EntityManager em;
    
    public TestePersistirReceituario() {
    }
    
    @Before
    public void setUp() {
        em= EntityManagerUtil.getEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
    }
    
    
    @Test
    public void teste(){
        Boolean exception = false;
        try {
            Receituario rec = new Receituario();
            rec.setConsulta(em.find(Consulta.class, 2));
            rec.setPosologia("Teste de receitas222");
            rec.setValidade(Calendar.getInstance());
            rec.getRemedio().add(em.find(Medicamento.class, 1));
            em.getTransaction().begin();
            em.persist(rec);
            em.getTransaction().commit();
            
        } catch (Exception e){
            exception = true;
            e.printStackTrace();
    }
        // aqui comparo o resultado experado com o que ocorreu
        Assert.assertEquals(false, exception);
    }
}
