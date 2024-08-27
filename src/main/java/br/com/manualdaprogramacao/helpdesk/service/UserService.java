package br.com.manualdaprogramacao.helpdesk.service;

import br.com.manualdaprogramacao.helpdesk.domain.User;
import br.com.manualdaprogramacao.helpdesk.entity.UserEntity;
import br.com.manualdaprogramacao.helpdesk.mapper.UserMapper;
import br.com.manualdaprogramacao.helpdesk.repository.UserRepository;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper mapper;

    public User createUser (User newUser){

        //Validação nome já cadastrado
        Optional<UserEntity> existentUser = userRepository.findByUsername(newUser.getUsername());
        if (existentUser.isPresent()){
            //TODO throw new BusinessException("This username is already in use in the system");
        }

        UserEntity entity = mapper.toEntity(newUser);
        entity.setCreateAt(new Date());
        entity.setPassword(new BCryptPasswordEncoder().encode(entity.getPassword())); //Encriptografar a senha ao salvar no DB
        entity = userRepository.save(entity);
        return mapper.toDomain(entity);
    }

    public User findByUsername(String username) {
        UserEntity entity = userRepository.findByUsername(username).orElse(null);
        if (entity == null){
           //TODO throw new AuthorizationException("User not found");
        }
        return mapper.toDomain(entity);
    }
}
