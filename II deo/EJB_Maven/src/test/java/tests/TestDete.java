package tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.ParseException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Entities.Dete;
import ServicesImplementation.DeteService;

public class TestDete {
    private static DeteService servis;
	
   @BeforeClass
   public static void initTest()
   {
	   servis=new DeteService();
	   System.out.println("BeforeClass: Uspesno inicijalizovan test");
   }
	
  //Preduslov:Ne postoji dete sa idom 9999
   @Before
   public void testPrecondition()
   {
	   Dete e1=servis.read(9999);
       assertNull(e1);
	   System.out.println("Before: Preduslov");
	   
   }
   
   //Dodajemo dete sa id-jem 9999
   @Test
   public void testAssertions() throws ParseException 
   {
	   servis.create(9999,"Veljko","Igor","Savic",19,"0242432235","2021-05-05","vekiveki","sifra");  
	   System.out.println("Test:izvrsen");
	   
   }
   
   //Post-uslov:Postoji dete sa id-om 9999
   
   
   
   
   @After
   public void testPostcondition()
   {
	   Dete d=servis.read(9999);
       assertNotNull(d);
       System.out.println("After: post-uslov");
   }
   
   
   //Brisemo test podatke iz baze
   @AfterClass
   public static void clearTest()
   {
	   servis.delete(9999);
	   System.out.println("AfterClass:obrisani test podaci");
	   
   }
}