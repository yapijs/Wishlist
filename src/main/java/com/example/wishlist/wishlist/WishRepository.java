package com.example.wishlist.wishlist;

import com.example.wishlist.wishlist.domain.Wish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishRepository extends JpaRepository<Wish, Long> {

}
