    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Medicamento;
import br.edu.ifsul.modelo.Receituario;
import java.util.Calendar;
import javax.persistence.EntityManager;
import org.jsoup.nodes.Entities;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author romulo
 */
public class TestePersistirReceita {
    
    EntityManager em;
    
    public TestePersistirReceita() {
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
        try{
            Receituario rec = em.find(Receituario.class, 1);
            Medicamento med = em.find(Medicamento.class, 1);
            rec.getRemedio().add(med);
            em.getTransaction().begin();
            em.persist(rec);
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
    }
        // aqui comparo o resultado experado com o que ocorreu
        Assert.assertEquals(false, exception);
    }
}
