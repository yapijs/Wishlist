package com.example.wishlist;

import com.example.wishlist.domain.Wish;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WishListServiceTest {
    @Mock
    WishRepository repository;

    @InjectMocks
    WishListService service;

    final String text = "my wish";
    final Long id = 15L;

    private Wish createWish() {
        Wish wish = new Wish(text);
        wish.setId(id);
        return wish;
    }


    @Test
    public void testGetWish() {
        Wish wishToTest = createWish();

        doAnswer(invocation -> Optional.of(wishToTest))
                .when(repository)
                .findById(id);

        Wish wishReceived = service.getWish(id);
        assertEquals(wishToTest, wishReceived);
        assertNotNull(wishReceived.getId());
        assertNotNull(wishReceived.getCreatedAt());
        assertNotNull(wishReceived.getModifiedAt());
        assertTrue(wishReceived.getCreatedAt().isEqual(wishReceived.getModifiedAt()));
    }


    @Test
    public void testGetNonExistentWish() {
        doAnswer(invocation -> Optional.empty())
                .when(repository)
                .findById(Mockito.anyLong());

        ResponseStatusException exception =
                assertThrows(ResponseStatusException.class, () -> service.getWish(id));
        assertEquals(404, exception.getRawStatusCode());
        assertEquals("Entry not found", exception.getReason());
    }


    @Test
    public void testAddWish() {
        Wish wishToTest = createWish();
        doAnswer(invocation -> wishToTest)
                .when(repository).save(Mockito.any(Wish.class));

        Wish result = service.addWish(text);
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertNotNull(result.getCreatedAt());
        assertTrue(result.getCreatedAt().isEqual(result.getModifiedAt()));
    }


    @Test
    public void testGetWishList() {
        List<Wish> wishList = new ArrayList<>();
        wishList.add(createWish());

        doAnswer(invocation -> wishList)
                .when(repository).findAll();
        List<Wish> returnedList = service.getWishList();
        assertEquals(1, wishList.size());
    }

    @Test
    public void testUpdateWish() {
        Wish wishToTest = createWish();
        wishToTest.setCreatedAt(wishToTest.getCreatedAt().minusMinutes(1));
        String updatedText = "my updated wish";

        doAnswer(invocation -> {
            return Optional.of(wishToTest);
        }).when(repository).findById(anyLong());
        doAnswer(invocation -> {
            return invocation.getArgument(0);
        }).when(repository).save(Mockito.any(Wish.class));

        Wish wishReturn = service.updateWish(id, updatedText);
        assertEquals(id, wishReturn.getId());
        assertNotNull(wishReturn.getModifiedAt());
        assertNotNull(wishReturn.getCreatedAt());
        assertTrue(wishReturn.getCreatedAt().isBefore(wishReturn.getModifiedAt()));
        assertNotEquals(text, wishReturn.getText());
    }

    @Test
    public void testDeleteWish() {
        Wish wishToTest = createWish();

        doAnswer(invocation -> {
            return Optional.of(wishToTest);
        }).when(repository).findById(anyLong());

        doAnswer(invocation -> {
            assertEquals(wishToTest, invocation.getArgument(0));
            return null;
        }).when(repository).delete(Mockito.any(Wish.class));

        service.deleteWish(anyLong());
    }

    @Test
    public void testDeleteWishNoneExistent() {
        doAnswer(invocation -> {
            return Optional.empty();
        }).when(repository).findById(anyLong());

        verify(repository, never()).delete(Mockito.any(Wish.class));
        service.deleteWish(anyLong());
    }
}
