package co.edu.unbosque.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the expendio database table.
 * 
 */
@Entity
@NamedQuery(name="Expendio.findAll", query="SELECT e FROM Expendio e")
public class Expendio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private byte caja;

	@Column(name="cantidad_solicitada")
	private int cantidadSolicitada;

	@Column(name="codigo_entidad")
	private String codigoEntidad;

	@Column(name="documento_paciente")
	private String documentoPaciente;

	private String estado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_expendio")
	private Date fechaExpendio;

	//bi-directional many-to-one association to Medicamento
	@ManyToOne
	private Medicamento medicamento;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	private Turno turno;

	public Expendio() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public byte getCaja() {
		return this.caja;
	}

	public void setCaja(byte caja) {
		this.caja = caja;
	}

	public int getCantidadSolicitada() {
		return this.cantidadSolicitada;
	}

	public void setCantidadSolicitada(int cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}

	public String getCodigoEntidad() {
		return this.codigoEntidad;
	}

	public void setCodigoEntidad(String codigoEntidad) {
		this.codigoEntidad = codigoEntidad;
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

	public Date getFechaExpendio() {
		return this.fechaExpendio;
	}

	public void setFechaExpendio(Date fechaExpendio) {
		this.fechaExpendio = fechaExpendio;
	}

	public Medicamento getMedicamento() {
		return this.medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

}