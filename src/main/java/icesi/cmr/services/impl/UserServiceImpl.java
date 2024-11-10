package icesi.cmr.services.impl;

import icesi.cmr.model.relational.users.User;
import icesi.cmr.repositories.users.UserRepository;
import icesi.cmr.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void save(User user) {

        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);

    }
}
