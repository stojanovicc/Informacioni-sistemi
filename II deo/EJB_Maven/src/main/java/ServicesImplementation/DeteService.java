package ServicesImplementation;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entities.Dete;
import Services.IDeteService;

public class DeteService implements IDeteService {

	private EntityManager em;

	public DeteService() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("InfoSysPU");
		em = emf.createEntityManager();
	}

	@Override
	public Dete create(int idClanskeKarte, String ime, String imeRoditelja, String prezime, int brojGodina, String brojTelefonaRoditelja, String clanarina, String korisnickoIme, String password)
			throws ParseException {
		em.getTransaction().begin();
		Dete dt = em.find(Dete.class, idClanskeKarte);
		Date today = Calendar.getInstance().getTime();

		Calendar c = Calendar.getInstance();
		c.setTime(today);
		c.add(Calendar.MONTH, 6);
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date dtm = c.getTime();
		String dateTime = sdf.format(dtm);

		System.out.println(dateTime);

		if (dt == null) {

			dt = new Dete(idClanskeKarte, ime, imeRoditelja, prezime, brojGodina, brojTelefonaRoditelja, dateTime,
					korisnickoIme, password);
			em.persist(dt);
		}
		em.getTransaction().commit();
		return null;
	}

	@Override
	public String readString(String username, String password) {
		Dete ret = null;

		try {
			ret = em.createQuery(
					"SELECT d FROM Dete d WHERE d.korisnickoIme='" + username + "' AND d.password='" + password + "'",
					Dete.class).getSingleResult();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (ret != null) {
			return ret.toString();
		} else
			return null;
	}

	@Override
	public Dete read(int id) {
		Dete ret = null;
		try {
			ret = em.createQuery("SELECT d from Dete d WHERE d.idClanskeKarte ='" + id + "'", Dete.class)
					.getSingleResult();
			return ret;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public Dete read(String username, String password) {
		Dete ret = null;

		try {
			ret = em.createQuery(
					"SELECT d FROM Dete d WHERE d.korisnickoIme='" + username + "' AND d.password='" + password + "'",
					Dete.class).getSingleResult();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return ret;
	}

	@Override
	public List<Dete> readAll() {

		return em.createQuery("SELECT d FROM Dete d", Dete.class).getResultList();
	}

	@Override
	public void produziClanarinu(int idck) throws ParseException {
		Dete djete = em.find(Dete.class, idck);
		// String pom = djete.getClanarinaString();
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
	public void platiClanarinu(Dete d) {
	}

	@Override
	public void delete(Dete d) {

		try {
			Dete dete = em.find(Dete.class, d.getIdClanskeKarte());
			if (dete != null) {
				em.getTransaction().begin();
				em.remove(dete);
				em.getTransaction().commit();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void delete(int id) {

		try {
			Dete d = em.createQuery("SELECT d FROM Dete d WHERE d.idClanskeKarte ='" + id + "'", Dete.class)
					.getSingleResult();
			if (d != null) {
				em.getTransaction().begin();
				em.remove(d);
				em.getTransaction().commit();

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void delete(String username, String password) {
		try {
			Dete d = em.createQuery(
					"SELECT d FROM Dete d WHERE d.korisnickoIme='" + username + "' AND d.password='" + password + "'",
					Dete.class).getSingleResult();
			if (d != null) {
				em.getTransaction().begin();
				em.remove(d);
				em.getTransaction().commit();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public Dete create(int idClanskeKarte, String ime, String prezime, String imeRoditelja, int jmbg, String vazenjeClanarine, String placanjeClanarine, String datumUclanjenja, String korisnickoIme, String password) {
		return null;
	}
}
