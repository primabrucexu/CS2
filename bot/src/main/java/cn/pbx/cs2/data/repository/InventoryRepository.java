package cn.pbx.cs2.data.repository;

import cn.pbx.cs2.data.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author BruceXu
 */
public interface InventoryRepository extends JpaRepository<Inventory, Long> {}
