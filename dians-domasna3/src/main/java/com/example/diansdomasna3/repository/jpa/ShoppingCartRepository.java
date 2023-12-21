package com.example.diansdomasna3.repository.jpa;

import com.example.diansdomasna3.Model.ShoppingCart;
import com.example.diansdomasna3.Model.User;
import com.example.diansdomasna3.Model.Wine;
import com.example.diansdomasna3.Model.enumerations.ShoppingCartStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
    Optional<ShoppingCart> findByUserAndStatus(User user, ShoppingCartStatus created);

    Optional<ShoppingCart> findByUserUsernameAndStatus(String username, ShoppingCartStatus created);

    List<ShoppingCart> findByDateCreatedBetween(LocalDateTime from, LocalDateTime to);

}
