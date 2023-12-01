package classes;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import dao.FuncionarioDAO;

@Entity
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idfuncionario", nullable = false)
	private Long idfuncionario;

	@Column(name = "nome", nullable = false)
	private String nome;
	@Column(name = "endereco", nullable = false)
	private String endereco;
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "salario", nullable = false)
	private Double salario;
	@Column(name = "cpf", nullable = false)
	private String cpf;
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	@JoinColumn(name = "idtelefone")
	private Telefone telefone;

	public Funcionario() {
	}

	public Funcionario(String nome, String endereco, String email, Double salario, String cpf, int ddd, Long numero) {
		this.nome = nome;
		this.endereco = endereco;
		this.email = endereco;
		this.salario = salario;
		this.cpf = cpf;
		this.setTelefone(new Telefone(ddd, numero));
	}

	public Long getIdFuncionario() {
		return idfuncionario;
	}

	public void setIdfuncionario(Long idfuncionario) {
		this.idfuncionario = idfuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public boolean salvar() {
		System.out.println(this.toString());
		return new FuncionarioDAO().salvar(this);

	}

	public List<Funcionario> buscarTodos() {
		return new FuncionarioDAO().buscarTodos();
	}

	public boolean atualizar() {

		return new FuncionarioDAO().atualizar(this);
	}

	public Telefone getTelefone() {
		return telefone;
	}


	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public boolean remover() {
		return new FuncionarioDAO().remover(this.getIdFuncionario());
	}

	public Funcionario buscarID() {
		return new FuncionarioDAO().buscarID(this.getIdFuncionario());
	}

	@Override
	public String toString() {
		return "Funcionario [idfuncionario=" + idfuncionario + ", nome=" + nome + ", endereco=" + endereco + ", email="
				+ email + ", salario=" + salario + ", cpf=" + cpf + ", telefone=" + telefone + "]";
	}

}
