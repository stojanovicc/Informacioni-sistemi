package tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Entities.Knjiga;
import ServicesImplementation.KnjigaService;

public class TestKnjiga {
    private static KnjigaService servis;
	
   @BeforeClass
   public static void initTest()
   {
	   servis=new KnjigaService();
	   System.out.println("BeforeClass: Uspesno inicijalizovan test");
   }
	
  //Preduslov:Ne postoji knjiga sa idom 2952
   @Before
   public void testPrecondition()
   {
	   Knjiga e1=servis.read(2952);
       assertNull(e1);
	   System.out.println("Before: Preduslov");
   }
   
   //Dodajemo zaposlenog sa id-jem 2952
   @Test
   public void testAssertions() 
   {
	   servis.create(2952,"Paulo Koeljo", "Brida");  
	   System.out.println("Test:izvrsen");
   }
   
   //Post-uslov:Postoji zaposleni sa id-om 2952 	
   @After
   public void testPostcondition()
   {
	   Knjiga k=servis.read(2952);
       assertNotNull(k);
       System.out.println("After: post-uslov");
   }
   
   //Brisemo test podatke iz baze
   @AfterClass
   public static void clearTest()
   {
	   servis.delete(2952);
	   System.out.println("AfterClass:obrisani test podaci");
   }
}