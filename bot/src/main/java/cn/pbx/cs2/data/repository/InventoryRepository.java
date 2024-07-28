package cn.pbx.cs2.data.repository;

import cn.pbx.cs2.data.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author BruceXu
 */
@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {}
