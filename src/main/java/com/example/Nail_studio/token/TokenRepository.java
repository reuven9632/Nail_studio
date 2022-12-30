<<<<<<< HEAD
package com.example.Nail_studio.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Transactional(readOnly = true)
@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

    Optional<Token> findByToken(String token);

    @Transactional
    @Query("UPDATE Token t SET t.confirmedAt = ?2 WHERE t.token = ?1")
    int setConfirmedAt(String token, LocalDateTime now);
=======
package com.example.Nail_studio.token;public class TokenRepository {
>>>>>>> f68fbc5 (create token -> ..., changes on registration and specialist)
}
