package com.JEE.ExamJEE.Service;

import java.util.List;

import com.JEE.ExamJEE.Modele.Declaration;

public interface DeclarationService {


	Declaration ajouter(Declaration declaration);
	Declaration obtenir(Long id, Declaration declaration);
	List<Declaration> Lister();
}
