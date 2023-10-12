package com.JEE.ExamJEE.Request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;

public class PaiementRequest {

	@Column
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date datePaiement;
	@Column
	private Double montantPaiement;

	private Long Declarationid;

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

	public Long getDeclarationid() {
		return Declarationid;
	}

	public void setDeclarationid(Long declarationid) {
		Declarationid = declarationid;
	}
}
