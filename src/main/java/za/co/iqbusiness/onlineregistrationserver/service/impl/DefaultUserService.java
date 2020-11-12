package za.co.iqbusiness.onlineregistrationserver.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import za.co.iqbusiness.onlineregistrationserver.domain.User;
import za.co.iqbusiness.onlineregistrationserver.exceptions.UserNotFoundException;
import za.co.iqbusiness.onlineregistrationserver.repository.UserRepository;
import za.co.iqbusiness.onlineregistrationserver.service.UserService;
import za.co.iqbusiness.onlineregistrationserver.utils.RegistrationUtils;

import java.util.List;

@Service
public class DefaultUserService implements UserService {

    private static final Logger LOG = Logger.getLogger(DefaultUserService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User person) {
        if (!RegistrationUtils.isIdNumberValid(person.getIdNumber())) {
            throw new IllegalArgumentException("Id number appears to be invalid");
        }
        if (StringUtils.isEmpty(person.getName()) && person.getName().length() < 2) {
            throw new IllegalArgumentException("Name cannot be empty or null and must be atleast 2 characters long");
        }
        if (!RegistrationUtils.isTelephoneNumberValid(person.getTelephoneNumber())) {
            throw new IllegalArgumentException("Telephone is invalid");
        }
        return userRepository.save(person);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(Long userId, User user) {
        User userToBeUpdated = userRepository.findById(userId)
                .orElse(null);
        if (userToBeUpdated != null) {
            userToBeUpdated.setIdNumber(user.getIdNumber());
            userToBeUpdated.setName(user.getName());
            userToBeUpdated.setTelephoneNumber(user.getTelephoneNumber());
            return userRepository.save(user);
        }
        throw new UserNotFoundException("User to be updated not found. User Id: " + userId);
    }

    @Override
    public List<User> delete(Long personId) {
        userRepository.deleteById(personId);
        return userRepository.findAll();
    }
}
