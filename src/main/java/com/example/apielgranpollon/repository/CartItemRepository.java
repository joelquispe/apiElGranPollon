package com.example.apielgranpollon.repository;

import com.example.apielgranpollon.entity.Cart;
import com.example.apielgranpollon.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Integer>{
    @Modifying
    @Query(value="UPDATE cart_item SET quantity=?1 WHERE id_cart_item=?2 ",nativeQuery = true)
    void editQuantityItem (String quantity,Integer id);

    @Query(value="SELECT  * FROM cart_item WHERE cart_id=?1 ",nativeQuery = true)
    Collection<CartItem> findByCart (Integer id);
}