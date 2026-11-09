package fr.simplon.domedespuys.repository;

import fr.simplon.domedespuys.entity.Brand;
import fr.simplon.domedespuys.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {

    Optional<Product> findBySlug(String slug);

    Page<Product> findByLabelContaining(String label, Pageable pageable);

    @Query("select p from Product p where p.label like %?1% order by p.label asc")
    List<Product> findWhereLabelLike(String label);
}
