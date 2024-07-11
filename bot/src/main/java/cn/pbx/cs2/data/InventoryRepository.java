package cn.pbx.cs2.data;

import cn.pbx.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author BruceXu
 */
public interface InventoryRepository extends JpaRepository<Inventory, Long> {}
