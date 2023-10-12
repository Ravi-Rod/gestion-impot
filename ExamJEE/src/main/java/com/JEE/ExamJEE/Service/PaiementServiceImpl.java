package com.JEE.ExamJEE.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JEE.ExamJEE.Modele.Paiement;
import com.JEE.ExamJEE.Repository.DeclarationRepository;
import com.JEE.ExamJEE.Repository.PaiementRepository;
import com.JEE.ExamJEE.Request.PaiementRequest;
import com.JEE.ExamJEE.Modele.*;

@Service
public class PaiementServiceImpl implements PaiementService{


	@Autowired
	private PaiementRepository paiementRepository;
	
	@Autowired
	private DeclarationRepository declarationRepository;
	

	@Override
	public void effectuer(PaiementRequest paie) {
		
		if (paie.getDeclarationid() != null) {
		Declaration declaration = declarationRepository.findById(paie.getDeclarationid()).orElseThrow(
		        () -> new RuntimeException("Declaration introuvable pour ce paiement")
		    );
		    declaration.setMontantDeclaration(
		        declaration.getMontantDeclaration() - paie.getMontantPaiement() );
		    this.declarationRepository.save(declaration);
		    
		Paiement paiement = new Paiement();
		paiement.setDatePaiement(paie.getDatePaiement());
		paiement.setMontantPaiement(paie.getMontantPaiement());
		paiement.setDeclaration(declaration);

	    this.paiementRepository.save(paiement);
		}

		else {
		    throw new RuntimeException("L'ID de la déclaration ne doit pas être null.");
		}
	}
	@Override
	public List<Paiement> lister() {
		return paiementRepository.findAll();
	}

	@Override
	public Paiement obtenir(Long id, Paiement paiement) {
		return paiementRepository.findById(id).orElseThrow(()-> new RuntimeException("Paiement non trouvé."));
	}

}
