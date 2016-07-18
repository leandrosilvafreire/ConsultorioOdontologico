/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorio.service;

import br.com.consultorio.entity.Usuario;
import java.util.List;
import java.util.Random;
import javax.ejb.embeddable.EJBContainer;
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
public class UsuarioServicoTest {
    
    private Usuario usuarioUm;
    private Usuario usuarioDois;
    private Usuario usuarioTres;
    private EJBContainer container;
    private UsuarioServico instance;
    
    
    public UsuarioServicoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception{
        container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        instance = (UsuarioServico)container.getContext().lookup("java:global/classes/UsuarioServico");
        
        usuarioUm = new Usuario();
        usuarioUm.setUsuadministrador(new Random().nextBoolean());
        usuarioUm.setUsudentista(new Random().nextBoolean());
        usuarioUm.setUsulogin("testLoginUm" + new Random().nextBoolean());
        usuarioUm.setUsunome("testNameUm" +  new Random().nextInt());
        usuarioUm.setUspassword(usuarioUm.getUsulogin());
        
        usuarioDois = new Usuario();
        usuarioDois.setUsuadministrador(new Random().nextBoolean());
        usuarioDois.setUsudentista(new Random().nextBoolean());
        usuarioDois.setUsulogin("testLoginDois" + new Random().nextBoolean());
        usuarioDois.setUsunome("testNameDois" +  new Random().nextInt());
        usuarioDois.setUspassword(usuarioDois.getUsulogin());
        
        usuarioTres = new Usuario();
        usuarioTres.setUsuadministrador(new Random().nextBoolean());
        usuarioTres.setUsudentista(new Random().nextBoolean());
        usuarioTres.setUsulogin("testLoginTres" + new Random().nextBoolean());
        usuarioTres.setUsunome("testNameTres" +  new Random().nextInt());
        usuarioTres.setUspassword(usuarioTres.getUsulogin());
        
        usuarioUm =  instance.addUsuario(usuarioUm);
        usuarioDois = instance.addUsuario(usuarioDois);
        usuarioTres =  instance.addUsuario(usuarioTres);
    }
    
    @After
    public void tearDown() {
        instance.removeUsuario(usuarioUm);
        instance.removeUsuario(usuarioDois);
        instance.removeUsuario(usuarioTres);
        instance = null;
        
        usuarioUm = null;
        usuarioDois = null;
        usuarioTres = null;
        container.close();
        container = null;
    }

    /**
     * Test of getUsuario method, of class UsuarioServico.
     */
    @Test
    public void testGetUsuario() throws Exception {
        System.out.println("getUsuario");
       
        
        
       
        
        Usuario expResult = null;
        Usuario result = instance.getUsuario(usuarioDois.getUsid());
        assertEquals(expResult, result);
        
        
        
       
    }

    /**
     * Test of setUsuario method, of class UsuarioServico.
     */
    @Test
    public void testSetUsuario() throws Exception {
        System.out.println("setUsuario");
        Usuario usuario = usuarioTres;
        Usuario expResult = usuarioTres;
        usuario.setUsunome("ChangedUsuarioName " + new Random().nextInt());
        Usuario result = instance.setUsuario(usuario);
        Usuario resultFromGet = instance.getUsuario(usuario.getUsid());
        assertEquals(expResult.getUsunome(), result.getUsunome());
        assertEquals(resultFromGet, result);
        assertEquals(resultFromGet.getUsunome(), result.getUsunome());
        
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of removeUsuario method, of class UsuarioServico.
     */
    //@Test
    public void testRemoveUsuario() throws Exception {
        System.out.println("removeUsuario");
        Usuario usuario = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsuarioServico instance = (UsuarioServico)container.getContext().lookup("java:global/classes/UsuarioServico");
        instance.removeUsuario(usuario);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class UsuarioServico.
     */
    //@Test
    public void testSetPassword() throws Exception {
        System.out.println("setPassword");
        int idofUsuario = 0;
        String password = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsuarioServico instance = (UsuarioServico)container.getContext().lookup("java:global/classes/UsuarioServico");
        instance.setPassword(idofUsuario, password);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUsuario method, of class UsuarioServico.
     */
    //@Test
    public void testAddUsuario() throws Exception {
        System.out.println("addUsuario");
        Usuario usuario = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsuarioServico instance = (UsuarioServico)container.getContext().lookup("java:global/classes/UsuarioServico");
        Usuario expResult = null;
        Usuario result = instance.addUsuario(usuario);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsuarioByLoginPassword method, of class UsuarioServico.
     */
    //@Test
    public void testGetUsuarioByLoginPassword() throws Exception {
        System.out.println("getUsuarioByLoginPassword");
        String login = "";
        String password = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsuarioServico instance = (UsuarioServico)container.getContext().lookup("java:global/classes/UsuarioServico");
        Usuario expResult = null;
        Usuario result = instance.getUserByLoginPassword(login, password);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsuarios method, of class UsuarioServico.
     */
    //@Test
    public void testGetUsuarios() throws Exception {
        System.out.println("getUsuarios");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsuarioServico instance = (UsuarioServico)container.getContext().lookup("java:global/classes/UsuarioServico");
        List<Usuario> expResult = null;
        List<Usuario> result = instance.getUsers();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
