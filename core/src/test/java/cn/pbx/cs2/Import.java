package cn.pbx.cs2;

import cn.pbx.cs2.data.repository.InventoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author BruceXu
 */
@SpringBootTest
public class Import {

    @Autowired
    InventoryRepository inventoryRepository;

    @Test
    public void importFromCSV() {}
}
