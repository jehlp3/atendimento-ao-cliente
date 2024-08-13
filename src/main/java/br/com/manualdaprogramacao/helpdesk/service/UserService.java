package br.com.manualdaprogramacao.helpdesk.service;

import br.com.manualdaprogramacao.helpdesk.domain.User;
import br.com.manualdaprogramacao.helpdesk.entity.UserEntity;
import br.com.manualdaprogramacao.helpdesk.repository.UserRepository;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;



    public void createUser (User newUser){
        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserEntity entity = new UserEntity();
        entity.setId(newUser.id());
        entity.setName(newUser.name());
        entity.setActive(true);
        entity.setEmail(newUser.email());
        //entity.setPassword(passwordEncoder.encode(newUser.password()));
        entity.setPassword(newUser.password());
        entity.setUsername(newUser.username());
        entity.setCreateAt(new Date());
        userRepository.save(entity);
    }

}
