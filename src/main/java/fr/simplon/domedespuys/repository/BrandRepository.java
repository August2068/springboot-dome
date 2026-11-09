package fr.simplon.domedespuys.repository;

import fr.simplon.domedespuys.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    // SELECT b.* FROM brand b WHERE b.slug = ?
    Optional<Brand> findBySlug(String slug);
}
