


package com.java.inven.Service;

import com.java.inven.Model.Inventory;
import com.java.inven.Repository.InventoryRepo;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepo inventoryRepo;

    public Inventory createInventory(@NonNull Inventory inventory) {
        return inventoryRepo.save(inventory);
    }

    public List<Inventory> getAllInventories() {
        return inventoryRepo.findAll();
    }

    public Inventory getInventoryById(@NonNull Integer id) {
        return inventoryRepo.findById(id).orElse(null);
    }

    public boolean updateInventory(int id, Inventory inventory) {
        if (getInventoryById(id) == null) {
            return false;
        }
        try {
            inventoryRepo.save(inventory);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean deleteInventory(int id) {
        if (getInventoryById(id) == null) {
            return false;
        }
        inventoryRepo.deleteById(id);
        return true;
    }
}
