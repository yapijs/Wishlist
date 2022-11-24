package com.example.wishlist.wishlist;

import com.example.wishlist.wishlist.domain.Wish;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class WishListService {

    private final WishRepository wishRepository;

    public WishListService(WishRepository wishRepository) {
        this.wishRepository = wishRepository;
    }

    public Wish addWish(String wish) {
        return wishRepository.save(new Wish(wish));
    }

    public Wish getWish(Long id) {
        return findWishOptional(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Entry not found"));
    }

    private Optional<Wish> findWishOptional(Long id) {
        return wishRepository.findById(id);
    }

    public Wish updateWish(Long id, String text) {
        Wish wish = getWish(id);
        wish.setText(text);
        wish.setModifiedAt(LocalDateTime.now().withNano(0));
        return wishRepository.save(wish);
    }

    public void deleteWish(Long id) {
        findWishOptional(id).ifPresent(wishRepository::delete);
    }

    public List<Wish> getWishList() {
        return wishRepository.findAll();
    }
}
