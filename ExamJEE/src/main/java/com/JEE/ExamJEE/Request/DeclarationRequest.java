package com.JEE.ExamJEE.Request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;

public class DeclarationRequest {


	@Column
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateDeclaration;
	@Column
	private Double montantDeclaration;
	
	private Long Declarantid;

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

	public Long getDeclarantid() {
		return Declarantid;
	}

	public void setDeclarantid(Long declarantid) {
		Declarantid = declarantid;
	}
}
