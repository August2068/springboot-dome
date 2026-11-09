package fr.simplon.domedespuys.repository;

import fr.simplon.domedespuys.entity.Image;
import fr.simplon.domedespuys.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    // pour les fixtures pour ne pas avoir le problème
    List<Image> findAllByProduct(Product product);
}
