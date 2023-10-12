package com.JEE.ExamJEE.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JEE.ExamJEE.Modele.Declaration;
import com.JEE.ExamJEE.Modele.Paiement;
import com.JEE.ExamJEE.Repository.DeclarationRepository;
import com.JEE.ExamJEE.Repository.PaiementRepository;
import com.JEE.ExamJEE.Request.PaiementRequest;
import com.JEE.ExamJEE.Service.PaiementService;

@RestController
@RequestMapping("/paiement")
public class PaiementController {

	@Autowired
	private final PaiementService paiementService;
	
	@Autowired
	private DeclarationRepository declarationRepository;
	
	@Autowired
	private PaiementRepository paiementRepository;
	
	public PaiementController(PaiementService paiementService) {
		super();
		this.paiementService = paiementService;
	}

	@PostMapping("operation")
	public void effectuerPaiement(@RequestBody PaiementRequest paiementReq) {
		

		if (paiementReq.getDeclarationid() != null) {
		Declaration declaration = declarationRepository.findById(paiementReq.getDeclarationid()).orElseThrow(
		        () -> new RuntimeException("Declaration introuvable pour ce paiement")
		    );
		    declaration.setMontantDeclaration(
		        declaration.getMontantDeclaration() - paiementReq.getMontantPaiement() );
		    declaration = declarationRepository.save(declaration);
		    
		Paiement paie = new Paiement();
		paie.setDatePaiement(paiementReq.getDatePaiement());
		paie.setMontantPaiement(paiementReq.getMontantPaiement());
		paie.setDeclaration(declaration);

	    paie = paiementRepository.save(paie);
		}

		else {
		    throw new RuntimeException("L'ID de la déclaration ne doit pas être null.");
		}
	
	}
	
	@GetMapping("{id}")
	public Paiement obtenirPaiement(@PathVariable Long id, Paiement paiement) {
		return paiementService.obtenir(id,paiement);
	}
	
	@GetMapping("liste")
	public List<Paiement> lire(){
		return paiementService.lister();
	}
}
