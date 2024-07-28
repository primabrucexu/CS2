package cn.pbx.cs2.data.entity;

import cn.pbx.enums.DetailType;
import cn.pbx.enums.InventoryType;
import cn.pbx.enums.Usage;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.proxy.HibernateProxy;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * @author BruceXu
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "inventory")
public class Inventory extends AbstractEntity<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private InventoryType inventoryType;
    private DetailType detailType;
    private String skinName;
    private Date buyDate;
    private BigDecimal buyPrice;
    private Date sellDate;
    private BigDecimal sellPrice;
    private Usage usage;

    /**
     * 收益折扣，true为80%
     */
    private BigDecimal benefitDiscount = new BigDecimal("0.8");

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy
                ? ((HibernateProxy) this)
                .getHibernateLazyInitializer()
                .getPersistentClass()
                .hashCode()
                : getClass().hashCode();
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null) {return false;}
        Class<?> oEffectiveClass = o instanceof HibernateProxy
                ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass()
                : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass()
                : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) {return false;}
        Inventory inventory = (Inventory) o;
        return getId() != null && Objects.equals(getId(), inventory.getId());
    }
}
