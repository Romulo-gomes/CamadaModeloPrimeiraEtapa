/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.teste;

import br.edu.ifsul.modelo.Especialidade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author romulo
 */
public class TestePersistirEspecialidade {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2018-1-5N1-TrabalhoPU");
        EntityManager em = emf.createEntityManager();
        
        Especialidade esp = new Especialidade();
        esp.setDescricao("Ginecologista");
        
        em.getTransaction().begin();
        em.persist(esp);
        em.getTransaction().commit();
    }
    
}
