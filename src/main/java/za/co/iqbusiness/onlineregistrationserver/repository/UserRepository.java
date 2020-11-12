package za.co.iqbusiness.onlineregistrationserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.iqbusiness.onlineregistrationserver.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
