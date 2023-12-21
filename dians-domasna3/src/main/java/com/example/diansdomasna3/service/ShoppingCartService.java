package com.example.diansdomasna3.service;

import com.example.diansdomasna3.Model.ShoppingCart;
import com.example.diansdomasna3.Model.Wine;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ShoppingCartService {
    List<Wine> listAllWinesInShoppingCart(Long cartId);

    ShoppingCart getActiveShoppingCart(String username);

    ShoppingCart addWineToShoppingCart(String username, Long productId);

    List<ShoppingCart> filterByDateTimeBetween(LocalDateTime from, LocalDateTime to);

    List<ShoppingCart> findAll();


    ShoppingCart save(ShoppingCart shoppingCart);

    Optional<ShoppingCart> findById(Long id);

    ShoppingCart removeWineFromShoppingCart(Long cartId, Long wineId);
    ShoppingCart removeAllWineFromShoppingCart(Long cartId);
    List<Wine>findAllWine(Long cartId);

}
