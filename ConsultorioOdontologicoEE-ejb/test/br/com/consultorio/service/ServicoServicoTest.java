/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorio.service;

import br.com.consultorioee.entity.Servico;
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
          servum.setSernome("Service Name of um" + new Random().nextInt());
          servum.setSercusto(new BigDecimal(new Random().nextFloat()));
          
          servdois = new Servico();
          servdois.setSernome("Service Name of dois" + new Random().nextInt());
          servdois.setSercusto(new BigDecimal(new Random().nextFloat()));
          
          servtres = new Servico();
          servtres.setSernome("Service Name of três" + new Random().nextInt());
          servtres.setSercusto(new BigDecimal(new Random().nextFloat()));
          
          servum = instance.addService(servum);
          servdois = instance.addService(servdois);
          servtres = instance.addService(servtres);
          
          
    }
    
    @After
    public void tearDown() {
        instance.removeService(servum);
        instance.removeService(servdois);
        instance.removeService(servtres);
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
        Servico result = instance.addService(servico);
        Servico expResult = instance.getService(result.getSerid());
        instance.removeService(servico);
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
        Servico result = instance.setService(servico);
        Servico expResult = instance.getService(servico.getSerid());
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
        Servico added = instance.addService(servico);
        added = instance.getService(added.getSerid());
        instance.removeService(servico);
        Servico removedService = instance.getService(added.getSerid());
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
        Servico result = instance.getService(idOfService);
        assertEquals(expResult, result);
    }

    /**
     * Test of getServices method, of class ServicoServico.
     */
    @Test
    public void testGetServices() throws Exception {
        System.out.println("getServices");
        List<Servico> result = instance.getServices();
        assertEquals(3, result.size());
    }

    /**
     * Test of getServiceByName method, of class ServicoServico.
     */
    @Test
    public void testGetServiceByName() throws Exception {
        System.out.println("getServiceByName");
        assertEquals(3, instance.getServiceByName("Service Name of ").size());
        assertEquals(1, instance.getServiceByName("Service Name of one").size());
        assertEquals(1, instance.getServiceByName("Service Name of Two").size());
        assertEquals(1, instance.getServiceByName("Service Name of Three").size());
        assertEquals(0, instance.getServiceByName("hjhjhjhj " + new Random()).size());
       
      
    }
    
}
