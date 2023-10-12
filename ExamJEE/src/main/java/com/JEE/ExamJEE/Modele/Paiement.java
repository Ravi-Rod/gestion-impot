package com.JEE.ExamJEE.Modele;

import java.util.Date;

import com.JEE.ExamJEE.Request.PaiementRequest;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;

@Entity
@Table
public class Paiement {

	public Paiement(Date datePaiement, Double montantPaiement, Long idDeclaration) {
		super();
		this.datePaiement = datePaiement;
		this.montantPaiement = montantPaiement;
	}
	
	public Paiement() {
		super();
	}

	@Id
	@Column
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date datePaiement;
	@Column
	private Double montantPaiement;
	
	@ManyToOne
	private Declaration declaration;
	
	public Paiement(PaiementRequest paie) {
		
		this.datePaiement= paie.getDatePaiement();
		this.montantPaiement= paie.getMontantPaiement();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDatePaiement() {
		return datePaiement;
	}
	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
	}
	public Double getMontantPaiement() {
		return montantPaiement;
	}
	public void setMontantPaiement(Double montantPaiement) {
		this.montantPaiement = montantPaiement;
	}
	public Declaration getDeclaration() {
		return declaration;
	}
	public void setDeclaration(Declaration declaration) {
		this.declaration = declaration;
	}
	
}
