

package com.java.inven.Controller;

import com.java.inven.Model.Inventory;
import com.java.inven.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/inventory")
    public ResponseEntity<Inventory> add(@RequestBody Inventory inventory) {
        Inventory newInventory = inventoryService.createInventory(inventory);
        if (newInventory != null) {
            return new ResponseEntity<>(newInventory, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/inventories")
    public ResponseEntity<List<Inventory>> getAllInventories() {
        List<Inventory> inventories = inventoryService.getAllInventories();
        if (!inventories.isEmpty()) {
            return new ResponseEntity<>(inventories, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @PutMapping("/inventory/{inventoryId}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable int inventoryId, @RequestBody Inventory inventory) {
        boolean updated = inventoryService.updateInventory(inventoryId, inventory);
        if (updated) {
            return new ResponseEntity<>(inventory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/inventory/{inventoryId}")
    public ResponseEntity<Boolean> deleteInventory(@PathVariable int inventoryId) {
        boolean deleted = inventoryService.deleteInventory(inventoryId);
        if (deleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}
