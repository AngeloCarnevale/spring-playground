package com.bank.services;

import com.bank.domain.user.User;
import com.bank.domain.user.UserType;
import com.bank.dtos.UserDTO;
import com.bank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getUserType() == UserType.MERCHANT) {
            throw new Exception("Usuário do tipo Lojista não está autorizado a realizar transação");
        }
        if(sender.getBalance().compareTo(amount) < 0) {
            throw new Exception("Usuário não tem saldo suficiente");
        }
    }
    public User findUserById(Long id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }

    public User createUser(UserDTO data) {
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers() {
        return this.repository.findAll();
    }
    public void saveUser(User user){
        this.repository.save(user);
    }
}

//{
//	"firstName": "Ângelo",
//	"lastName": "Carnevale",
//	"document": "50714069850",
//	"email": "angelo.carnevale@hotmail.com",
//	"type": "COMMON",
//	"balance": 10
//}
