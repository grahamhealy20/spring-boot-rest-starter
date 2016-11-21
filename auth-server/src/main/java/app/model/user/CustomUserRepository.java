package app.model.user;

import app.model.user.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by GrahamH on 15/08/2016.
 */
@Repository
public interface CustomUserRepository extends JpaRepository<CustomUser, Long> {
    public CustomUser findByUsername(String username);
}
