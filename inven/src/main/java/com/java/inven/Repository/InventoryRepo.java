

package com.java.inven.Repository;

import com.java.inven.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory, Integer> {
}
