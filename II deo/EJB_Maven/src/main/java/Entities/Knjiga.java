package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Knjiga")
public class Knjiga {

	@Id
	@Column(name="idKnjiga")
	private int idKnjiga;
	
	@Column(name="autor")
	private String autor;
	
	@Column(name="naslov")
	private String naslov;
	
	@Column(name="isDostupna")
	private boolean isDostupna;
	
	@Column(name="isRezervisana")
	private boolean isRezervisana;
	
	@Column(name="iznajmio")
	private Integer iznajmio;
	
	@Column(name="rezervisao")
	private Integer rezervisao;
	
	@Column(name="zauzetaDo")
	private String zauzetaDo;
	public Knjiga()
	{
		
	}
	public Knjiga(int id, String autor, String naslov) {
		super();
		this.idKnjiga = id;
		this.autor = autor;
		this.naslov = naslov;
		this.isDostupna = true;
		this.isRezervisana = false;
		this.rezervisao = 0;
		this.iznajmio = null;
		this.zauzetaDo =null;
	}
	public Knjiga(int id, String autor, String naslov,boolean isDostupna,boolean isRezervisana,Integer iznajmio,int rezervisao,String zauzetaDo)
	{
		super();
		this.idKnjiga = id;
		this.autor = autor;
		this.naslov = naslov;
		this.isDostupna = isDostupna;
		this.isRezervisana = isRezervisana;
		this.iznajmio = iznajmio;
		this.rezervisao = rezervisao;
		this.zauzetaDo = zauzetaDo;
	}
	

	public int getIdKnjiga() {
		return idKnjiga;
	}

	public void setIdKnjiga(int idKnjiga) {
		this.idKnjiga = idKnjiga;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public Integer getIznajmio() {
		return iznajmio;
	}

	public void setIznajmio(int idck) {
		this.iznajmio = idck;
	}

	public Integer getRezervisao() {
		return rezervisao;
	}

	public void setRezervisao(int rezervisao) {
		this.rezervisao = rezervisao;
	}
	public boolean getisDostupna() {
		return isDostupna;
	}
	public void setDostupna(boolean isDostupna) {
		this.isDostupna = isDostupna;
	}
	public boolean getisRezervisana() {
		return isRezervisana;
	}
	public void setRezervisana(boolean isRezervisana) {
		this.isRezervisana = isRezervisana;
	}
	public String getZauzetaDo() {
		return zauzetaDo;
	}
	public void setZauzetaDo(String zauzetaDo) {
		this.zauzetaDo = zauzetaDo;
	}
	public boolean isDostupna() {
		return isDostupna;
	}
	public boolean isRezervisana() {
		return isRezervisana;
	}
	public void setRezervisao(Integer rezervisao) {
		this.rezervisao = rezervisao;
	}
	

	
	
}