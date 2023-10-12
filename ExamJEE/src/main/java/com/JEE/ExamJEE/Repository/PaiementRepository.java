package com.JEE.ExamJEE.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JEE.ExamJEE.Modele.Paiement;

public interface PaiementRepository  extends JpaRepository<Paiement, Long>{

}