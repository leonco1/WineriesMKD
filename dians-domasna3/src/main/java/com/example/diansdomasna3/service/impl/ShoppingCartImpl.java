package com.example.diansdomasna3.service.impl;

import com.example.diansdomasna3.Model.ShoppingCart;
import com.example.diansdomasna3.Model.User;
import com.example.diansdomasna3.Model.Wine;
import com.example.diansdomasna3.Model.enumerations.ShoppingCartStatus;
import com.example.diansdomasna3.Model.exceptions.ShoppingCartNotFoundException;
import com.example.diansdomasna3.Model.exceptions.UserNotFoundException;
import com.example.diansdomasna3.Model.exceptions.WineAlreadyInShoppingCartException;
import com.example.diansdomasna3.Model.exceptions.WineNotFoundException;
import com.example.diansdomasna3.repository.jpa.ShoppingCartRepository;
import com.example.diansdomasna3.repository.jpa.UserRepository;
import com.example.diansdomasna3.repository.jpa.WineRepository;
import com.example.diansdomasna3.service.ShoppingCartService;
import com.example.diansdomasna3.service.WineService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShoppingCartImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;
    private final WineRepository wineRepository;

    public ShoppingCartImpl(ShoppingCartRepository shoppingCartRepository, UserRepository userRepository, WineRepository wineRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userRepository = userRepository;
        this.wineRepository = wineRepository;
    }

    @Override
    public List<Wine> listAllWinesInShoppingCart(Long cartId) {
        Optional<ShoppingCart> shoppingCartOptional = this.shoppingCartRepository.findById(cartId);

        if (shoppingCartOptional.isEmpty()) {
            throw new ShoppingCartNotFoundException(cartId);
        }

        return shoppingCartOptional.get().getWineList();

    }

    @Override
    public ShoppingCart getActiveShoppingCart(String username) {
        return this.shoppingCartRepository
                .findByUserUsernameAndStatus(username, ShoppingCartStatus.CREATED)
                .orElseGet(() -> {
                    User user = this.userRepository.findByUsername(username)
                            .orElseThrow(() -> new UserNotFoundException(username));
                    ShoppingCart shoppingCart = new ShoppingCart(user);
                    return this.shoppingCartRepository.save(shoppingCart);
                });

    }

    @Override
    public ShoppingCart addWineToShoppingCart(String username, Long wineId) {
        Wine wine = this.wineRepository.findById(wineId)
                .orElseThrow(() -> new WineNotFoundException(wineId));
        ShoppingCart shoppingCart = this.getActiveShoppingCart(username);
        List<Wine> winesInShoppingCart = shoppingCart.getWineList().stream()
                .filter(i -> i.getId().equals(wineId))
                .collect(Collectors.toList());

        if (!winesInShoppingCart.isEmpty()) {
            throw new WineAlreadyInShoppingCartException(wineId, username);
        }

        shoppingCart.getWineList().add(wine);
        return this.shoppingCartRepository.save(shoppingCart);

    }

    @Override
    public List<ShoppingCart> filterByDateTimeBetween(LocalDateTime from, LocalDateTime to) {
        return this.shoppingCartRepository.findByDateCreatedBetween(from, to);
    }

    @Override
    public List<ShoppingCart> findAll() {
        return this.shoppingCartRepository.findAll();
    }

    @Override
    public ShoppingCart save(ShoppingCart shoppingCart) {
        return this.shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public Optional<ShoppingCart> findById(Long id) {
        return this.shoppingCartRepository.findById(id);
    }

    @Override
    public ShoppingCart removeWineFromShoppingCart(Long cartId, Long wineId) {
        ShoppingCart shoppingCart = this.shoppingCartRepository.findById(cartId)
                .orElseThrow(() -> new ShoppingCartNotFoundException(cartId));

        List<Wine> updatedWineList = shoppingCart.getWineList()
                .stream()
                .filter(wine -> !wine.getId().equals(wineId))
                .collect(Collectors.toList());

        shoppingCart.setWineList(updatedWineList);

        return this.shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart removeAllWineFromShoppingCart(Long cartId) {
        ShoppingCart shoppingCart=this.shoppingCartRepository.findById(cartId).get();
        List<Wine>List=new ArrayList<>();
        shoppingCart.setWineList(List);
        return this.shoppingCartRepository.save(shoppingCart);

    }

    @Override
    public List<Wine> findAllWine(Long cartId) {
        ShoppingCart shoppingCart=findById(cartId).get();
        return shoppingCart.getWineList();
    }

}
