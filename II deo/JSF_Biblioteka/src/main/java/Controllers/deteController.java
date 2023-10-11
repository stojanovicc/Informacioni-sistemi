package Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import Entities.Dete;
import Services.IDeteService;

@ManagedBean
@ViewScoped
public class deteController {

	private Dete dete = new Dete();
	private String usrnm = "";
	private String vznj="";
	private Dete profil = new Dete();
	private int deteregid =0;
	private String deteregime = "";
	private String deteimeroditeljareg= "";
	private String deteprezimereg= "";
	private int detebrojgodinareg = 0;
	private String detekorisnickoimereg= "";
	private String detepasswordreg= "";
	private String detevazenjeclanarinereg= "";
	
	private int trid=0;
	@EJB
	private IDeteService service;

	public void deteCreate() throws ParseException, IOException
	{
		if(this.validate(deteregime) && this.validate(deteprezimereg))
		{
		service.create(deteregid, deteregime, deteimeroditeljareg, deteprezimereg, detebrojgodinareg,"05543132423", null, detekorisnickoimereg, detepasswordreg);
		}
	}
		
	@SuppressWarnings("unused")
	public void login(String username,String password)
	{
		Dete d = null;
		d = service.read(username, password);
		//usrnm = username;
		//vznj = d.getClanarinaString();
		if(d!= null)
		{
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("DeteProfil.xhtml?id=" +Integer.toString(d.getIdClanskeKarte()));
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
				FacesContext.getCurrentInstance().getExternalContext().redirect("DeteReg.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		}
	public boolean validate(String tekst) throws IOException
	{
		return service.validate(tekst);
	}
	public void deteRegister(int idClanske,String deteIme,String deteImeRoditelja, String detePrezime,int deteBrojGodina,String brojtelefona,String clanarina,String korisnickoIme,String password ) throws ParseException, IOException
	{
		Dete d = service.read(idClanske);
		if(d==null)
		{
		if(this.validate(deteIme) && this.validate(detePrezime))
		{
			service.register(idClanske, deteIme, deteImeRoditelja, detePrezime, deteBrojGodina, brojtelefona,clanarina,korisnickoIme,password);
		}
		}
		else
		{
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("DeteLogin.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void loadKorisnik() {
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		if(map.containsKey("id"))
		{
			try {
				this.setProfil(service.read(Integer.parseInt(map.get("id"))));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void produziClanarinu() throws ParseException
	{
		service.produziClanarinu(this.dete.getIdClanskeKarte());
	}
	public List<Dete> readAll()
	{
		List<Dete> deca = service.readAll();
		return deca;
	}
	public Dete getDete() {
		return dete;
	}

	public void setDete(Dete dete) {
		this.dete = dete;
	}
	public String getUsrnm() {
		return usrnm;
	}
	public void setUsrnm(String usrnm) {
		this.usrnm = usrnm;
	}
	public String getVznj() {
		return vznj;
	}
	public void setVznj(String vznj) {
		this.vznj = vznj;
	}
	public int getDeteregid() {
		return deteregid;
	}
	public void setDeteregid(int deteregid) {
		this.deteregid = deteregid;
	}
	public String getDeteregime() {
		return deteregime;
	}
	public void setDeteregime(String deteregime) {
		this.deteregime = deteregime;
	}
	public String getDeteimeroditeljareg() {
		return deteimeroditeljareg;
	}
	public void setDeteimeroditeljareg(String deteimeroditeljareg) {
		this.deteimeroditeljareg = deteimeroditeljareg;
	}
	public String getDeteprezimereg() {
		return deteprezimereg;
	}
	public void setDeteprezimereg(String deteprezimereg) {
		this.deteprezimereg = deteprezimereg;
	}
	public int getDetebrojgodinareg() {
		return detebrojgodinareg;
	}
	public void setDetebrojgodinareg(int detebrojgodinareg) {
		this.detebrojgodinareg = detebrojgodinareg;
	}
	public String getDetekorisnickoimereg() {
		return detekorisnickoimereg;
	}
	public void setDetekorisnickoimereg(String detekorisnickoimereg) {
		this.detekorisnickoimereg = detekorisnickoimereg;
	}
	public String getDetepasswordreg() {
		return detepasswordreg;
	}
	public void setDetepasswordreg(String detepasswordreg) {
		this.detepasswordreg = detepasswordreg;
	}
	public String getDetevazenjeclanarinereg() {
		return detevazenjeclanarinereg;
	}
	public void setDetevazenjeclanarinereg(String detevazenjeclanarinereg) {
		this.detevazenjeclanarinereg = detevazenjeclanarinereg;
	}
	public IDeteService getService() {
		return service;
	}
	public void setService(IDeteService service) {
		this.service = service;
	}
	public Dete getProfil() {
		return profil;
	}
	public void setProfil(Dete profil) {
		this.profil = profil;
	}

	public int getTrid() {
		return trid;
	}

	public void setTrid(int trid) {
		this.trid = trid;
	}
	
	
}
