package tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Entities.Zaposleni;
import ServicesImplementation.ZaposleniService;

public class TestZaposleni {
    private static ZaposleniService servis;
	
   @BeforeClass
   public static void initTest()
   {
	   servis=new ZaposleniService();
	   System.out.println("BeforeClass: Uspesno inicijalizovan test");
   }
	
  //Preduslov:Ne postoji zaposleni sa maticnim brojem 1010999740036
   @Before
   public void testPrecondition()
   {
	   Zaposleni e1=servis.read("101010");
       assertNull(e1);
	   System.out.println("Before: Preduslov");
   }
   
   //Dodajemo zaposlenog sa id-jem 103
   @Test
   public void testAssertions() 
   {
	   servis.create("101010","Darko","Darkovic","Bibliotekar",50000.00,"0656067848","Djuke Dinica");  
	   System.out.println("Test:izvrsen");
   }
   
   //Post-uslov:Postoji zaposleni sa id-om 103
   @After
   public void testPostcondition()
   {
	   Zaposleni z=servis.read("101010");
       assertNotNull(z);
       System.out.println("After: post-uslov");
   }
   
   //Brisemo test podatke iz baze
   @AfterClass
   public static void clearTest()
   {
	   servis.delete("101010");
	   System.out.println("AfterClass:obrisani test podaci");
   }
}