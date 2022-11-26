package com.example.wishlist;

import com.example.wishlist.domain.Wish;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishListController {

    private final WishListService wishListService;

    public WishListController(WishListService wishListService) {
        this.wishListService = wishListService;
    }

    @PostMapping("/wish")
    @ResponseStatus(HttpStatus.CREATED)
    public Wish addWish(@RequestBody String wish) {
        return wishListService.addWish(wish);
    }

    @GetMapping("/wish/{id}")
    public Wish getWish(@PathVariable Long id) {
        return wishListService.getWish(id);
    }

    @PutMapping("/wish/{id}")
    public Wish updateWish(@PathVariable Long id, @RequestBody String text) {
        return wishListService.updateWish(id, text);
    }

    @DeleteMapping("wish/{id}")
    public void deleteWish(@PathVariable Long id) {
        wishListService.deleteWish(id);
    }

    @GetMapping("/all")
    public List<Wish> getWishlist() {
        return wishListService.getWishList();
    }
}

