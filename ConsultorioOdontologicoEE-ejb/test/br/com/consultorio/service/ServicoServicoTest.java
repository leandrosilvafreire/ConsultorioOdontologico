/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorio.service;

import br.com.consultorio.entity.Servico;
import com.sun.org.apache.regexp.internal.recompile;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leandro
 */
public class ServicoServicoTest {
    
    private EJBContainer container;
    private ServicoServico instance;
    private Servico servum;
    private Servico servdois;
    private Servico servtres;
    
    public ServicoServicoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws NamingException{
          container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
          instance = (ServicoServico)container.getContext().lookup("java:global/classes/ServicoServico");
          
          servum = new Servico();
          servum.setSernome("Servico Name of um" + new Random().nextInt());
          servum.setSercusto(new BigDecimal(new Random().nextFloat()));
          
          servdois = new Servico();
          servdois.setSernome("Servico Name of dois" + new Random().nextInt());
          servdois.setSercusto(new BigDecimal(new Random().nextFloat()));
          
          servtres = new Servico();
          servtres.setSernome("Servico Name of três" + new Random().nextInt());
          servtres.setSercusto(new BigDecimal(new Random().nextFloat()));
          
          servum = instance.addServico(servum);
          servdois = instance.addServico(servdois);
          servtres = instance.addServico(servtres);
          
          
    }
    
    @After
    public void tearDown() {
        instance.removeServico(servum);
        instance.removeServico(servdois);
        instance.removeServico(servtres);
        instance = null;
        container.close();
        container = null;
    }

    /**
     * Test of addService method, of class ServicoServico.
     */
    @Test
    public void testAddService() throws Exception {
        System.out.println("addService");
        Servico servico = new Servico();
        servico.setSernome("Test of add method "+ new Random().nextInt());
        servico.setSercusto(new BigDecimal(new Random().nextFloat()));
        Servico result = instance.addServico(servico);
        Servico expResult = instance.getServico(result.getSerid());
        instance.removeServico(servico);
        assertEquals(expResult, result);
    }

    /**
     * Test of setService method, of class ServicoServico.
     */
    @Test
    public void testSetService() throws Exception {
        System.out.println("setService");
        Servico servico = servum;
        String newName = "The new name of Service "+ new Random().nextInt();
        servico.setSernome(newName);
        Servico result = instance.setServico(servico);
        Servico expResult = instance.getServico(servico.getSerid());
        assertEquals(newName, expResult.getSernome());
    }

    /**
     * Test of removeService method, of class ServicoServico.
     */
    @Test
    public void testRemoveService() throws Exception {
        System.out.println("removeService");
        Servico servico = new Servico();
        servico.setSernome("The Removbed Name of "+ new Random().nextInt());
        servico.setSercusto(new BigDecimal(new Random().nextFloat()));
        Servico added = instance.addServico(servico);
        added = instance.getServico(added.getSerid());
        instance.removeServico(servico);
        Servico removedService = instance.getServico(added.getSerid());
        assertNull(removedService);
       
    }

    /**
     * Test of getService method, of class ServicoServico.
     */
    @Test
    public void testGetService() throws Exception {
        System.out.println("getService");
        int idOfService = servtres.getSerid();
        Servico expResult = servtres;
        Servico result = instance.getServico(idOfService);
        assertEquals(expResult, result);
    }

    /**
     * Test of getServices method, of class ServicoServico.
     */
    @Test
    public void testGetServices() throws Exception {
        System.out.println("getServices");
        List<Servico> result = instance.getServicos();
        assertEquals(3, result.size());
    }

    /**
     * Test of getServiceByName method, of class ServicoServico.
     */
    @Test
    public void testGetServiceByName() throws Exception {
        System.out.println("getServiceByName");
        assertEquals(3, instance.getServicosByName("Service Name of ").size());
        assertEquals(1, instance.getServicosByName("Service Name of one").size());
        assertEquals(1, instance.getServicosByName("Service Name of Two").size());
        assertEquals(1, instance.getServicosByName("Service Name of Three").size());
        assertEquals(0, instance.getServicosByName("hjhjhjhj " + new Random()).size());
       
      
    }
    
}
