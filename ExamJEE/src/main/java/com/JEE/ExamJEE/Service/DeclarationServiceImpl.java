package com.JEE.ExamJEE.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JEE.ExamJEE.Modele.Declaration;
import com.JEE.ExamJEE.Repository.DeclarationRepository;


@Service
public class DeclarationServiceImpl implements DeclarationService{

	@Autowired
	private DeclarationRepository declarationRepository;

	
	@Override
	public Declaration ajouter(Declaration declaration) {
		return declarationRepository.save(declaration);
	}

	@Override
	public List<Declaration> Lister() {
		return declarationRepository.findAll();
	}

	@Override
	public Declaration obtenir(Long id, Declaration declaration) {
		return declarationRepository.findById(id).orElseThrow(()-> new RuntimeException("Declaration non trouvée."));
	}

}
