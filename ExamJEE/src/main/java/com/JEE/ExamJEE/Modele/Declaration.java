package com.JEE.ExamJEE.Modele;

import java.util.Collection;
import java.util.Date;

import com.JEE.ExamJEE.Request.DeclarationRequest;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;


@Entity
@Table
public class Declaration {
	public Declaration(Date dateDeclaration, Double montantDeclaration, Declarant declarant) {
		super();
		this.dateDeclaration = dateDeclaration;
		this.montantDeclaration = montantDeclaration;
		this.declarant = declarant;
	}

	public Declaration() {
		super();
	}


	@Id
	@Column
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateDeclaration;
	@Column
	private Double montantDeclaration;

	@OneToOne
	private Declarant declarant;

	@OneToMany(mappedBy= "declaration")
	private Collection<Paiement> paiements;
	
	public Declaration(DeclarationRequest req) {
	
		this.dateDeclaration= req.getDateDeclaration();
		this.montantDeclaration= req.getMontantDeclaration();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateDeclaration() {
		return dateDeclaration; 
	}
	public void setDateDeclaration(Date dateDeclaration) {
		this.dateDeclaration = dateDeclaration;
	}
	public Double getMontantDeclaration() {
		return montantDeclaration;
	}
	public void setMontantDeclaration(Double montantDeclaration) {
		this.montantDeclaration = montantDeclaration;
	}

	
	public Declarant getDeclarant() {
		return declarant;
	}
	public void setDeclarant(Declarant declarant) {
		this.declarant = declarant;
	}
	public Collection<Paiement> getPaiements() {
		return paiements;
	}
	public void setPaiements(Collection<Paiement> paiements) {
		this.paiements = paiements;
	}
}
