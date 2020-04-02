package es.upm.dit.isst.electolab.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Simulacion implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private int idSimulacion;
	
	private int votos_favor;
	private int votos_contra;
	private int votos_abstencion;
	
	private String tituloLey;
	private boolean ley_aprobada;
	private Diputado diputado;
	private Collection<Diputado> diputados;

	
	@ManyToOne
	private UsuarioRegistrado autor;

	public Simulacion() {
		super();
	}

	public int getIdSimulacion() {
		return idSimulacion;
	}

	public int getVotos_favor() {
		return votos_favor;
	}

	public int getVotos_contra() {
		return votos_contra;
	}

	public int getVotos_abstencion() {
		return votos_abstencion;
	}

	public String getTituloLey() {
		return tituloLey;
	}

	public boolean isLey_aprobada() {
		return ley_aprobada;
	}

	public UsuarioRegistrado getAutor() {
		return autor;
	}

	public void setIdSimulacion(int idSimulacion) {
		this.idSimulacion = idSimulacion;
	}

	public void setVotos_favor(int votos_favor) {
		this.votos_favor = votos_favor;
	}

	public void setVotos_contra(int votos_contra) {
		this.votos_contra = votos_contra;
	}

	public void setVotos_abstencion(int votos_abstencion) {
		this.votos_abstencion = votos_abstencion;
	}

	public void setTituloLey(String tituloLey) {
		this.tituloLey = tituloLey;
	}

	public void setLey_aprobada(boolean ley_aprobada) {
		this.ley_aprobada = ley_aprobada;
	}

	public void setAutor(UsuarioRegistrado autor) {
		this.autor = autor;
	}
	
	public Diputado getDiputado() {
		return diputado;
	}

	public void setDiputado(Diputado diputado) {
		this.diputado = diputado;
	}

	public Collection<Diputado> getDiputados() {
		return diputados;
	}

	public void setDiputados(Collection<Diputado> diputados) {
		this.diputados = diputados;
	}

	@Override
	public String toString() {
		return "Simulacion [idSimulacion=" + idSimulacion + ", votos_favor=" + votos_favor + ", votos_contra="
				+ votos_contra + ", votos_abstencion=" + votos_abstencion + ", tituloLey=" + tituloLey
				+ ", ley_aprobada=" + ley_aprobada + ", autor=" + autor + "]";
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idSimulacion;
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
		Simulacion other = (Simulacion) obj;
		if (idSimulacion != other.idSimulacion)
			return false;
		return true;
	}
	
}