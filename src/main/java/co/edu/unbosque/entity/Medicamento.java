package co.edu.unbosque.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the medicamento database table.
 * 
 */
@Entity
@NamedQuery(name="Medicamento.findAll", query="SELECT m FROM Medicamento m")
public class Medicamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private int cantidad;

	private String codigo;

	private String nombre;

	//bi-directional many-to-one association to Expendio
	@OneToMany(mappedBy="medicamento")
	private List<Expendio> expendios;

	//bi-directional many-to-one association to Inventario
	@OneToMany(mappedBy="medicamento")
	private List<Inventario> inventarios;

	public Medicamento() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Expendio> getExpendios() {
		return this.expendios;
	}

	public void setExpendios(List<Expendio> expendios) {
		this.expendios = expendios;
	}

	public Expendio addExpendio(Expendio expendio) {
		getExpendios().add(expendio);
		expendio.setMedicamento(this);

		return expendio;
	}

	public Expendio removeExpendio(Expendio expendio) {
		getExpendios().remove(expendio);
		expendio.setMedicamento(null);

		return expendio;
	}

	public List<Inventario> getInventarios() {
		return this.inventarios;
	}

	public void setInventarios(List<Inventario> inventarios) {
		this.inventarios = inventarios;
	}

	public Inventario addInventario(Inventario inventario) {
		getInventarios().add(inventario);
		inventario.setMedicamento(this);

		return inventario;
	}

	public Inventario removeInventario(Inventario inventario) {
		getInventarios().remove(inventario);
		inventario.setMedicamento(null);

		return inventario;
	}

}