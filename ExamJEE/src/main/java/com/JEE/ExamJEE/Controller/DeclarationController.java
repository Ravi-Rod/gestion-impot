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
import com.JEE.ExamJEE.Repository.DeclarantRepository;
import com.JEE.ExamJEE.Repository.DeclarationRepository;
import com.JEE.ExamJEE.Modele.Declarant;
import com.JEE.ExamJEE.Request.DeclarationRequest;
import com.JEE.ExamJEE.Service.DeclarationService;

@RestController
@RequestMapping("/declaration")
public class DeclarationController {
	
	@Autowired
	private final DeclarationService declarationService;
	
	@Autowired
	private DeclarantRepository drep;
	
	@Autowired
	private DeclarationRepository derep;
	
	public DeclarationController(DeclarationService declarationService) {
		super();
		this.declarationService = declarationService;
	}

	@PostMapping("ajout")
	public Declaration ajout(@RequestBody DeclarationRequest declarationReq) {
		
		if (declarationReq.getDeclarantid() != null) {
		Declarant dec= drep.findById(declarationReq.getDeclarantid()).orElseThrow(()-> new RuntimeException("Declarant non trouvé."));
			
		Declaration det = new Declaration ();
		det.setDeclarant(dec);
		det.setDateDeclaration(declarationReq.getDateDeclaration());
		det.setMontantDeclaration(declarationReq.getMontantDeclaration());
		
		det= derep.save(det);
		return det;
		}
		else {
		    throw new RuntimeException("L'ID du déclarant ne doit pas être null.");
		}
	}

	@GetMapping("{id}")
	public Declaration obtenirDeclaration(@PathVariable Long id, Declaration declaration) {
		return declarationService.obtenir(id,declaration);
	}
	
	@GetMapping("liste")
	public List<Declaration> lire(){
		return declarationService.Lister();
	}

}
