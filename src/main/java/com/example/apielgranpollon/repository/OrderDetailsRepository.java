package com.example.apielgranpollon.repository;



import com.example.apielgranpollon.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Integer> {
    @Query(value="SELECT  * FROM orderdetails WHERE order_id=?1 ",nativeQuery = true)
    OrderDetails findByOrder (Integer id);
}
