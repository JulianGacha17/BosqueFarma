package co.edu.unbosque.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the turno database table.
 * 
 */
@Entity
@NamedQuery(name="Turno.findAll", query="SELECT t FROM Turno t")
public class Turno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name="documento_paciente")
	private String documentoPaciente;

	private String estado;

	@Column(name="numero_turno")
	private int numeroTurno;

	//bi-directional many-to-one association to Expendio
	@OneToMany(mappedBy="turno")
	private List<Expendio> expendios;

	public Turno() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDocumentoPaciente() {
		return this.documentoPaciente;
	}

	public void setDocumentoPaciente(String documentoPaciente) {
		this.documentoPaciente = documentoPaciente;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getNumeroTurno() {
		return this.numeroTurno;
	}

	public void setNumeroTurno(int numeroTurno) {
		this.numeroTurno = numeroTurno;
	}

	public List<Expendio> getExpendios() {
		return this.expendios;
	}

	public void setExpendios(List<Expendio> expendios) {
		this.expendios = expendios;
	}

	public Expendio addExpendio(Expendio expendio) {
		getExpendios().add(expendio);
		expendio.setTurno(this);

		return expendio;
	}

	public Expendio removeExpendio(Expendio expendio) {
		getExpendios().remove(expendio);
		expendio.setTurno(null);

		return expendio;
	}

}