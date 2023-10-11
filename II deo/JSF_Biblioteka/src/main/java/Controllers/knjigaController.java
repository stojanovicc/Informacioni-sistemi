package Controllers;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Entities.Knjiga;
import Services.IKnjigaService;

@ManagedBean
@ViewScoped
public class knjigaController {
	
	int idic=0;
	int idk=0;
	
	private String IDKnjige = " ";
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
	public void rezervisi()
	{
		service.rezervisi(this.idk, this.idic);
	}
	public Knjiga getKnjiga() {
		return Knjiga;
	}

	public void setKnjiga(Knjiga knjiga) {
		this.Knjiga = knjiga;
	}
	public Knjiga dodajknjigu(Integer idKnjiga,String autor,String naslov)
	{
		Knjiga novaknjiga = service.create(idKnjiga, autor, naslov);
		return novaknjiga;
	}
	public void iznajmi()
	{
		service.iznajmi(this.idic,this.idk);
	}

	public String getIDKnjige() {
		return IDKnjige;
	}

	public void setIDKnjige(String iDKnjige) {
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
	
	
}
