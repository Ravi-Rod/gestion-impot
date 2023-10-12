package com.JEE.ExamJEE.Modele;

import jakarta.persistence.*;

@Entity
@Table
public class Declarant {
	
	public Declarant(String raisonSociale, String adresse, String email, String telephone) {
		super();
		this.raisonSociale = raisonSociale;
		this.adresse = adresse;
		this.email = email;
		this.telephone = telephone;
	}
	
	public Declarant() {
		super();
	}
	
	@Id	
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String raisonSociale;
	@Column
	private String adresse;
	@Column
	private String email; 
	@Column
	private String telephone;

	@OneToOne(mappedBy = "declarant", fetch = FetchType.EAGER)
	private Declaration declaration;
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRaisonSociale() {
		return raisonSociale;
	}
	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
}

 