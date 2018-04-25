/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Consulta;
import br.edu.ifsul.modelo.Exame;
import br.edu.ifsul.modelo.Medico;
import br.edu.ifsul.modelo.Paciente;
import br.edu.ifsul.modelo.Receituario;
import java.util.Calendar;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author romulo
 */
public class TestePersistirConsulta {
    
   EntityManager em;

    public TestePersistirConsulta() {
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
    public void teste() {
        boolean exception = false;
        try {
            Consulta con = new Consulta();
            con.setData(Calendar.getInstance());
            con.setHora(Calendar.getInstance());
            con.setPreconsulta("Teste 111, teste pré-consulta sem limites de caracteres");
            con.setPosconsulta("Teste 22222, da pós-consulta sem limites de caracteres");
            con.setMedico(em.find(Medico.class, 4));
            con.setPaciente(em.find(Paciente.class, 4));
            Exame ex = new Exame();
            ex.setNome("Sangue");
            ex.setDescricao("Hemoglobina");
            con.adicionaExame(ex);
            Receituario rec = new Receituario();
            rec.setPosologia("Teste de receituario 2");
            rec.setValidade(Calendar.getInstance());
            con.adicionaReceita(rec);
            
            em.getTransaction().begin();
            em.persist(con);
            em.getTransaction().commit();
        }catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        /*
        O método abaixo verifica se o valor esperado (false) é
        igual ao valor do atributo exception, que vai indicar se ocorreu ou não erro.
        Se não ocorrer erro o teste passa. 
         */
        Assert.assertEquals(false, exception);
    }

}