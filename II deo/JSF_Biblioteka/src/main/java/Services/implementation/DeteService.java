package Services.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import Entities.Dete;
import Services.IDeteService;
@Stateless
public class DeteService implements IDeteService
{
	@PersistenceContext(name="JSF_Biblioteka")
	private EntityManager em;
	private static final String USER_AGENT = "Mozilla/5.0";
	public DeteService()
	{
		
	}
	
	public Dete register(int idClanskeKarte, String ime, String imeRoditelja, String prezime, int brojGodina, String brojTelefonaRoditelja, String clanarina, String korisnickoIme, String password)
			throws ParseException
	{
		Dete d = null;
		d = em.find(Dete.class, idClanskeKarte);
		if (d == null)
		{
			d = new Dete(idClanskeKarte, ime, imeRoditelja, prezime, brojGodina, brojTelefonaRoditelja, clanarina, korisnickoIme, password);
			em.persist(d);
		}
		else
		{
			System.out.print("POSTOJI OVAJ ID");
		}
		return d;
		
	}
	
	@Override
	public void produziClanarinu(int idck) throws ParseException
	{
		Dete djete = em.find(Dete.class, idck);
		Date datum = djete.getClanarina();
		
		Calendar c = Calendar.getInstance();
		c.setTime(datum);
		c.add(Calendar.MONTH, 6);
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date dtm = c.getTime();
		String dateTime = sdf.format(dtm);
		
		System.out.println(dateTime);
		djete.setClanarina(dateTime);
	}
	
	@Override
	public String readString(String username, String password)
	{
		Dete ret = null;
		
		try
		{
			ret = em.createQuery("SELECT d FROM Dete d WHERE d.korisnickoIme='" + username + "' AND d.password='" + password + "'", Dete.class).getSingleResult();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		if (ret != null)
		{
			return ret.toString();
		}
		else
			return null;
	}

	@Override
	public Dete read(int id)
	{
		Dete ret = null;
		try
		{
			ret = em.createQuery("SELECT d from Dete d WHERE d.idClanskeKarte ='" + id +"'", Dete.class).getSingleResult();
			return ret;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public Dete read(String username, String password)
	{
		Dete ret = null;
		ret = em.createQuery("SELECT d FROM Dete d WHERE d.korisnickoIme='" + username + "' AND d.password='" + password + "'", Dete.class).getSingleResult();
		return ret;
	}

	@Override
	public List<Dete> readAll()
	{

		return em.createQuery("SELECT d FROM Dete d", Dete.class).getResultList();
	}

	@Override
	public void platiClanarinu(Dete d)
	{

	}

	@Override
	public void delete(Dete d )
	{
		try
		{
			Dete dete = em.find(Dete.class, d.getIdClanskeKarte());
			if (dete != null)
			{
				em.getTransaction().begin();
				em.remove(dete);
				em.getTransaction().commit();
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void delete(int id)
	{
		try
		{
			Dete d = em.createQuery("SELECT d FROM Dete d WHERE d.idClanskeKarte ='" + id + "'", Dete.class).getSingleResult();
			if (d != null)
			{
				em.getTransaction().begin();
				em.remove(d);
				em.getTransaction().commit();		
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void delete(String username, String password)
	{
		try
		{
			Dete d = em.createQuery("SELECT d FROM Dete d WHERE d.korisnickoIme='" + username + "' AND d.password='" + password + "'", Dete.class).getSingleResult();
			if (d != null)
			{
				em.getTransaction().begin();
				em.remove(d);
				em.getTransaction().commit();
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Override
	public boolean validate(String tekst) throws IOException
	{
		int result = 0;
		
		URL obj = new URL("http://192.168.99.100/?tekst=" + tekst);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK)
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while ((inputLine = in.readLine()) != null)
			{
				response.append(inputLine);
			}
			
			in.close();
			
			result = Integer.parseInt(response.toString());
		}
		
		if (result == 1)
			return true;
		else
			return false;	
	}
	
	@Override
	public Dete create(int idClanskeKarte, String ime, String imeRoditelja, String prezime, int brojGodina, String brojTelefonaRoditelja, String clanarina, String korisnickoIme, String password)
			throws ParseException
	{
		Dete dt = em.find(Dete.class,idClanskeKarte);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date today = Calendar.getInstance().getTime();
	
		Calendar c = Calendar.getInstance();
		c.setTime(today);
		c.add(Calendar.MONTH, 6);
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date dtm = c.getTime();
		String dateTime = sdf.format(dtm);
		System.out.println(dateTime);
		
		if (dt == null)
		{
			dt = new Dete(idClanskeKarte, ime, imeRoditelja, prezime, brojGodina, brojTelefonaRoditelja, dateTime, korisnickoIme, password);
			em.persist(dt);
		}
		return null;
	}
}