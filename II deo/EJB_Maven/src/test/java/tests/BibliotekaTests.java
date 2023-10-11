package tests;

import org.junit.After;
import org.junit.Test;

import Entities.Dete;
import Entities.Knjiga;
import Entities.Zaposleni;
import ServicesImplementation.KnjigaService;
import ServicesImplementation.ZaposleniService;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BibliotekaTests {

	public void test1()
	{
		EntityManager em;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("InfoSysPU");
        em = emf.createEntityManager();
		
		List <Dete> deca =em.createQuery("SELECT d from Dete d", Dete.class).getResultList();
		assertNotNull(deca);
		System.out.println("U bazi ima unete dece");
	}
	public void test2()
	{
		//Da li vraca nesto funkcija koja lista knjige?
		KnjigaService service=new KnjigaService();
		   List <Knjiga> knjige=service.readAll();
	       assertNotNull(knjige);
	       System.out.println("U bazi ima knjiga");
	}
	
	public void test3()
	{
		  //Da li se aranzman sa idjem1 zove dubai?
		ZaposleniService service = new ZaposleniService();
	      Zaposleni z = service.read("1111999740022");
	       assertEquals(z.getIme(),"Petar");
	       System.out.println("Zaposleni sa jmbg-om 1111999740022 je Andjela");
	}

	   @Test
	   public void testAssertions() 
	   {
		   test1();
		   test2();
		   test3();
	   }
	   @After
	   public void testKraj()
	       {
	    	   System.out.println("Kraj testa 1!");
	       }
	
}
