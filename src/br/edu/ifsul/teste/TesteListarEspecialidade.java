/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.teste;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Especialidade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.validator.constraints.CreditCardNumber;

/**
 *
 * @author romulo
 */
public class TesteListarEspecialidade {

    public static void main(String[] args) {
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        List<Especialidade> lista = em.createQuery("from Especialidade order by descricao").getResultList();
        
        for(Especialidade esp:lista){
            System.out.println("ID: "+ esp.getId()+ " Descrição: "+esp.getDescricao());
        }
    }
    
}
