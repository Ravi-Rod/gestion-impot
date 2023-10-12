package com.JEE.ExamJEE.Service;

import java.util.List;

import com.JEE.ExamJEE.Modele.Paiement;
import com.JEE.ExamJEE.Request.PaiementRequest;

public interface PaiementService {

	Paiement obtenir(Long id, Paiement paiement);
	List<Paiement> lister();
	void effectuer(PaiementRequest paie);
}
