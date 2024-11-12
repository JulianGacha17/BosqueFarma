package co.edu.unbosque.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the auditoria database table.
 * 
 */
@Entity
@NamedQuery(name="Auditoria.findAll", query="SELECT a FROM Auditoria a")
public class Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name="accion_auditoria")
	private String accionAuditoria;

	@Column(name="comentario_auditoria")
	private String comentarioAuditoria;

	@Column(name="direccion_auditoria")
	private String direccionAuditoria;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_auditoria")
	private Date fechaAuditoria;

	@Column(name="usuario_auditoria")
	private String usuarioAuditoria;

	public Auditoria() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccionAuditoria() {
		return this.accionAuditoria;
	}

	public void setAccionAuditoria(String accionAuditoria) {
		this.accionAuditoria = accionAuditoria;
	}

	public String getComentarioAuditoria() {
		return this.comentarioAuditoria;
	}

	public void setComentarioAuditoria(String comentarioAuditoria) {
		this.comentarioAuditoria = comentarioAuditoria;
	}

	public String getDireccionAuditoria() {
		return this.direccionAuditoria;
	}

	public void setDireccionAuditoria(String direccionAuditoria) {
		this.direccionAuditoria = direccionAuditoria;
	}

	public Date getFechaAuditoria() {
		return this.fechaAuditoria;
	}

	public void setFechaAuditoria(Date fechaAuditoria) {
		this.fechaAuditoria = fechaAuditoria;
	}

	public String getUsuarioAuditoria() {
		return this.usuarioAuditoria;
	}

	public void setUsuarioAuditoria(String usuarioAuditoria) {
		this.usuarioAuditoria = usuarioAuditoria;
	}

}