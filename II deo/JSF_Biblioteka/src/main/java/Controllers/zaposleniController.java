package Controllers;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import Entities.Dete;
import Entities.Knjiga;
import Entities.Zaposleni;
import Services.IKnjigaService;
import Services.IZaposleniService;

@ManagedBean
@ViewScoped
public class zaposleniController {

	@EJB
	IZaposleniService zapservis;
	
	private String removejmbg = " ";
	
	private Zaposleni profil = new Zaposleni();
	private Zaposleni zaposleni = new Zaposleni();
	

	public Zaposleni getZaposleni() {
		return zaposleni;
	}

	public void setZaposleni(Zaposleni zaposleni) {
		this.zaposleni = zaposleni;
	}
	
	public Zaposleni promeniPlatu()
	{
		Zaposleni zap = zapservis.setPlata(zaposleni.getJmbg(),zaposleni.getPlata());
		return zap;
		
	}
	public List<Zaposleni> readZaposleni() {
		List<Zaposleni> lista = zapservis.citaj();
		return lista;
	}
	public void obrisiZaposlenog(String jmbg)
	{
		zapservis.delete(jmbg);
	}

	public String getRemovejmbg() {
		return removejmbg;
	}

	public void setRemovejmbg(String removejmbg) {
		this.removejmbg = removejmbg;
	}
	
	public void login(String username,String password)
	{
		Zaposleni z = zapservis.read(username, password);
		if(z!= null)
		{
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("ZaposleniProfil.xhtml?jmbg=" +z.getJmbg());
			}
			catch(IOException e)
			
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Nevalidno korisnicko ime ili sifra!");
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("ZaposleniReg.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		}
	public void zaposleniRegister()
	{
		Zaposleni z = zapservis.read(zaposleni.getJmbg());
		if(z==null)
		{
		zapservis.create(zaposleni.getJmbg(),zaposleni.getIme(),zaposleni.getPrezime(),zaposleni.getPozicija(),zaposleni.getPlata(),zaposleni.getKorisnickoIme(),zaposleni.getSifra());
		}
		else
		{
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("ZaposleniLogin.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void loadKorisnik() {
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		if(map.containsKey("jmbg"))
		{
			try {
				this.setProfil(zapservis.read((map.get("jmbg"))));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	///// knjiga controller
	
int idic=0;
int idk=0;
	
	private int IDKnjige = 0;
	private String AutorKnjige = " ";
	private String NaslovKnjige = " ";
	
	
	
	public IKnjigaService getService() {
		return service;
	}
	public void setService(IKnjigaService service) {
		this.service = service;
	}

	private Knjiga Knjiga = new Knjiga();
	
	@EJB
	IKnjigaService service;
	
	public List<Knjiga> readAllFor(Integer id)
	{
		  List<Knjiga> knjigice  = service.readAll();
		  return knjigice;
	}
	public List<Knjiga> readAll()
	{
		 List<Knjiga> knjige  = service.readAll();
		  return knjige;
	}
	public void rezervisi(Integer idck,Integer idk)
	{
		service.rezervisi(idk, idck);
	}
	public Knjiga getKnjiga() {
		return Knjiga;
	}

	public void setKnjiga(Knjiga knjiga) {
		this.Knjiga = knjiga;
	}
	public Knjiga dodajknjigu()
	{
		Knjiga novaknjiga = service.create(IDKnjige,AutorKnjige, NaslovKnjige);
		return novaknjiga;
	}
	public void iznajmi()
	{
		System.out.println("BRATEEEE");
		service.iznajmi(this.idic,this.idk);
	}

	public int getIDKnjige() {
		return IDKnjige;
	}

	public void setIDKnjige(int iDKnjige) {
		IDKnjige = iDKnjige;
	}

	public String getAutorKnjige() {
		return AutorKnjige;
	}

	public void setAutorKnjige(String autorKnjige) {
		AutorKnjige = autorKnjige;
	}

	public String getNaslovKnjige() {
		return NaslovKnjige;
	}

	public void setNaslovKnjige(String naslovKnjige) {
		NaslovKnjige = naslovKnjige;
	}
	public int getIdic() {
		return idic;
	}
	public void setIdic(int idic) {
		this.idic = idic;
	}

	public int getIdk() {
		return idk;
	}

	public void setIdk(int idk) {
		this.idk = idk;
	}

	public Zaposleni getProfil() {
		return profil;
	}

	public void setProfil(Zaposleni profil) {
		this.profil = profil;
	}
	
	
	
	
}
