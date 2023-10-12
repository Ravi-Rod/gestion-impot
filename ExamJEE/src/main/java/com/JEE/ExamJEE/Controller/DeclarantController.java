package com.JEE.ExamJEE.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JEE.ExamJEE.Modele.Declarant;
import com.JEE.ExamJEE.Service.DeclarantService;


@RestController
@RequestMapping("/declarant")
public class DeclarantController {

	private final DeclarantService declarantService;
	
	public DeclarantController(DeclarantService declarantService) {
		super();
		this.declarantService = declarantService;
	}

	@PostMapping("/ajout")
	public Declarant ajout(@RequestBody Declarant declarant) {
		return declarantService.ajouter(declarant);
	}

	@GetMapping("/{id}")
	public Declarant obtenirDeclarant(@PathVariable Long id, Declarant declarant) {
		return declarantService.obtenir(id,declarant);
	}

	@GetMapping("/liste")
	public List<Declarant> lire(){
		return declarantService.Lister();
	}
	
}
