/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Medicamento;
import br.edu.ifsul.modelo.Receituario;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author romulo
 */
public class TestePersistirMedicamentos {
    EntityManager em;
    
    public TestePersistirMedicamentos() {
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
            Medicamento med = new Medicamento();
            med.setNome("Dorflex");
            med.getReceita().add(em.find(Receituario.class, 1));
            em.getTransaction().begin();
            em.persist(med);
            em.getTransaction().commit();
            
        } catch (Exception e){
            exception = true;
            e.printStackTrace();
    }
        // aqui comparo o resultado experado com o que ocorreu
        Assert.assertEquals(false, exception);
    }
}
