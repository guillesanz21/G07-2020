package es.upm.dit.isst.electolab.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Diputado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private int idDiputado;
	
	private String nombre;
	
	//Tags
	//private String partido;
	private long edad;
	private String provincia;
	private String genero;
	private String estado_civil;
	private String vote;  // se quita?
	private String customTags;
	
	@ManyToOne
	private Partido partido;

	public Diputado() {
		super();
	}


	public int getIdDiputado() {
		return idDiputado;
	}


	public void setIdDiputado(int idDiputado) {
		this.idDiputado = idDiputado;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Partido getPartido() {
		return partido;
	}


	public void setPartido(Partido partido) {
		this.partido = partido;
	}


	public long getEdad() {
		return edad;
	}


	public void setEdad(long l) {
		this.edad = l;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getCustomTags() {
		return customTags;
	}


	public void setCustomTags(String customTags) {
		this.customTags = customTags;
	}


	public String getVote() {
		return vote;
	}


	public void setVote(String vote) {
		this.vote = vote;
	}
	
	public String getEstado_civil() {
		return estado_civil;
	}


	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDiputado;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Diputado other = (Diputado) obj;
		if (idDiputado != other.idDiputado)
			return false;
		return true;
	}

}
