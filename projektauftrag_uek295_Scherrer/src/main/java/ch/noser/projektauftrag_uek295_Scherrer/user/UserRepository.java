package ch.noser.projektauftrag_uek295_Scherrer.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where upper(u.username) = upper(?1)")
    Optional<User> findUserByUsername(String username);
}