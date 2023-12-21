package com.example.diansdomasna3.web.controller;

import com.example.diansdomasna3.Model.ShoppingCart;
import com.example.diansdomasna3.Model.User;
import com.example.diansdomasna3.Model.Wine;
import com.example.diansdomasna3.Model.Wineries;
import com.example.diansdomasna3.Model.enumerations.ShoppingCartStatus;
import com.example.diansdomasna3.service.ShoppingCartService;
import com.example.diansdomasna3.service.UserService;
import com.example.diansdomasna3.service.WineService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/shopping-cart")

public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final WineService wineService;

    public ShoppingCartController(ShoppingCartService shoppingCartService, UserService userService,WineService wineService) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.wineService=wineService;
    }

    @GetMapping
    public String getShoppingCartPage(@RequestParam(required = false) String error,
                                      HttpServletRequest req,
                                      Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        String username=(String)req.getSession().getAttribute("username");
        User user=this.userService.find_By_username(username).get();
        ShoppingCart shoppingCart = this.shoppingCartService.getActiveShoppingCart(username);
        model.addAttribute("shoppingCart", shoppingCart);
        Wineries wineries=(Wineries) req.getSession().getAttribute("winery");
        model.addAttribute("user",user);
        model.addAttribute("winery",wineries);
        model.addAttribute("wines", this.shoppingCartService.listAllWinesInShoppingCart(shoppingCart.getId()));
        return "shopping-cart";
    }

    @PostMapping("/add-product/{id}")
    public String addProductToShoppingCart(@PathVariable Long id, HttpServletRequest req) {
        try {
            String username=(String)req.getSession().getAttribute("username");
            ShoppingCart shoppingCart = this.shoppingCartService.addWineToShoppingCart(username, id);
            return "redirect:/shopping-cart";
        } catch (RuntimeException exception) {
            return "redirect:/shopping-cart?error=" + exception.getMessage();
        }
    }

    @PostMapping("/update/{id}")
    public String updateShoppingCart(@RequestParam ShoppingCartStatus status,
                                     @PathVariable Long id,
                                     HttpServletRequest req) {

        Optional<ShoppingCart> shoppingCart = this.shoppingCartService.findById(id);
        shoppingCart.ifPresent((cart) -> {
            cart.setStatus(status);
            this.shoppingCartService.save(cart);
        });

        return "redirect:/shopping-cart";
    }
    @PostMapping("/add-to/{id}")
    public String add_toUser(@PathVariable Long id, HttpServletRequest request,Model model)
    {
        String username=(String)request.getSession().getAttribute("username");
        User user=this.userService.find_By_username((String)request.getSession().getAttribute("username")).get();
        request.getSession().setAttribute("WineList",this.shoppingCartService.findAllWine(id));
        model.addAttribute("WineList",this.shoppingCartService.findAllWine(id));
        this.shoppingCartService.removeAllWineFromShoppingCart(id);
        return "redirect:/profile";
    }

    @GetMapping("/remove/{cartId}/{wineId}")
    public String removeWineFromShoppingCart(@PathVariable Long cartId, @PathVariable Long wineId) {
        shoppingCartService.removeWineFromShoppingCart(cartId, wineId);
        return "redirect:/shopping-cart";
    }


}
