package com.JEE.ExamJEE.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JEE.ExamJEE.Modele.Declarant;
import com.JEE.ExamJEE.Repository.DeclarantRepository;


@Service
public class DeclarantServiceImpl implements DeclarantService{

	@Autowired
	private DeclarantRepository declarantRepository;
	

	@Override
	public Declarant ajouter (Declarant declarant) {
		return declarantRepository.save(declarant);
	}

	@Override
	public List<Declarant> Lister() {
		return declarantRepository.findAll();
	}

	@Override
	public Declarant obtenir(Long id, Declarant declarant) {
		return declarantRepository.findById(id).orElseThrow(()-> new RuntimeException("Declarant non trouvé."));
	}

}
