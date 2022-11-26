package com.example.wishlist;

import com.example.wishlist.domain.Wish;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "Add new wish")
    @PostMapping("/wish")
    @ResponseStatus(HttpStatus.CREATED)
    public Wish addWish(@RequestBody String wish) {
        return wishListService.addWish(wish);
    }

    @ApiOperation(value = "Get wish by id")
    @GetMapping("/wish/{id}")
    public Wish getWish(@PathVariable Long id) {
        return wishListService.getWish(id);
    }

    @ApiOperation(value = "Update text of wish by providing id")
    @PutMapping("/wish/{id}")
    public Wish updateWish(@PathVariable Long id, @RequestBody String text) {
        return wishListService.updateWish(id, text);
    }

    @ApiOperation(value = "Delete wish by providing id")
    @DeleteMapping("wish/{id}")
    public void deleteWish(@PathVariable Long id) {
        wishListService.deleteWish(id);
    }

    @ApiOperation(value = "Get list of wishes")
    @GetMapping("/all")
    public List<Wish> getWishlist() {
        return wishListService.getWishList();
    }
}

