package fr.simplon.domedespuys.repository;

import fr.simplon.domedespuys.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository<User, type de l'id de l'objet>
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
