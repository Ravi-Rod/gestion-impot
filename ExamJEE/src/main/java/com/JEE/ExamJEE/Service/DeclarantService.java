package com.JEE.ExamJEE.Service;

import java.util.List;

import com.JEE.ExamJEE.Modele.Declarant;

public interface DeclarantService {

	Declarant ajouter(Declarant declarant);
	Declarant obtenir(Long id, Declarant declarant);
	List<Declarant> Lister();
}
