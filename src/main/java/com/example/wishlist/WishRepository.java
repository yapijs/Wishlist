package com.example.wishlist;

import com.example.wishlist.domain.Wish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishRepository extends JpaRepository<Wish, Long> {

}
