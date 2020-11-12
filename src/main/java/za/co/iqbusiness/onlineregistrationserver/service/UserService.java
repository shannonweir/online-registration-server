package za.co.iqbusiness.onlineregistrationserver.service;

import za.co.iqbusiness.onlineregistrationserver.domain.User;
import java.util.List;

public interface UserService {

    User save(User user);

    List<User> findAll();

    User update(Long personId, User user);

    List<User> delete(Long userId);
}
