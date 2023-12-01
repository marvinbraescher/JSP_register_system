package classes;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import dao.UsuarioDAO;

@Entity
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idusuario;
	private String email;
	private String senha;
	
	public Usuario(){}
	public Usuario(String nome, String endereco){ 
		this.email = nome; 
		this.senha = endereco;
	}
	
	
	public boolean salvar() {
		//manda salvar o objeto atual
		return new UsuarioDAO().salvar(this);
	}
	public List<Usuario> buscarTodos(){
		return new UsuarioDAO().buscarTodos();
	}
	public boolean atualizar(){
		//manda editar/atualizar o objeto atual
		return new UsuarioDAO().atualizar(this);
	}
	public boolean remover(){
		return new UsuarioDAO().remover(this.getIdusuario());
	}
	public Usuario buscarID(){
		return new UsuarioDAO().buscarID(this.getIdusuario());
	}
	public Long getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
