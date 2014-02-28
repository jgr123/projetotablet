package com.example.models;

public class Cliente {
	private int id;
	private String registro;
	private String nome;
	private String contato;
	private String endereco;
	private String complemento;
	private String cidade;
	private String estado;
	private String cep;
	private String fone;
	private String fax;
	private String email;
	private String clifor;
		
	public Cliente(int id, String registro, String nome, String contato,
			String endereco, String complemento, String cidade, String estado,
			String cep, String fone, String fax, String email, String clifor) {
		super();
		this.id = id;
		this.registro = registro;
		this.nome = nome;
		this.contato = contato;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.fone = fone;
		this.fax = fax;
		this.email = email;
		this.clifor = clifor;
	}
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getClifor() {
		return clifor;
	}
	public void setClifor(String clifor) {
		this.clifor = clifor;
	}
	
	
}
