package applicationDeBase.AppDeGest.Repository;
import applicationDeBase.AppDeGest.Entity.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository  extends JpaRepository<user, Long> {
}
