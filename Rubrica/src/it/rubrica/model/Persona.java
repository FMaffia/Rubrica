package it.rubrica.model;

public class Persona implements Comparable<Persona> {

	private String nome;
	private String cognome;
	private String email;

	public Persona() {
	}

	public Persona(String nome, String cognome) {
		super();
		this.nome = nome;
		this.cognome = cognome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int compareTo(Persona p) {
		return this.cognome.compareTo(p.getCognome());
	}

}
