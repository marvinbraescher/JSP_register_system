package classes;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import dao.UsuarioDAO;

@Entity
public class Telefone implements Serializable{
	private static final long serialVersionUID = 1L;
	@ Id
	@Column(name = "idtelefone", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
    
    private int ddd;
    private Long numero;
	

	public Telefone(){}
	public Telefone(int ddd, Long numero){ 
		this.ddd = ddd;
		this.numero = numero;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public int getDdd() {
		return ddd;
	}
	public void setDdd(int ddd) {
		this.ddd = ddd;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}

}
