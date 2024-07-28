package cn.pbx.cs2.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.proxy.HibernateProxy;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * @author BruceXu
 */
@Entity
@Table(name = "rent_record")
public class RentRecord extends AbstractEntity<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    private Date startDate;
    private Date endDate;

    /**
     * 租金
     */
    private BigDecimal singlePrice;

    /**
     * 租赁天数
     */
    private Integer rentalDays;

    /**
     * 总租金
     */
    private BigDecimal totalPrice;

    /**
     * 真实收益
     */
    private BigDecimal totalBenefit;

    public RentRecord() {}

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
        RentRecord that = (RentRecord) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    public String toString() {
        return "RentRecord(id=" + this.getId() + ", inventory=" + this.getInventory() + ", startDate=" + this.getStartDate() + ", endDate=" + this.getEndDate() + ", singlePrice=" + this.getSinglePrice() + ", rentalDays=" + this.getRentalDays() + ", totalPrice=" + this.getTotalPrice() + ", totalBenefit=" + this.getTotalBenefit() + ")";
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getSinglePrice() {
        return this.singlePrice;
    }

    public void setSinglePrice(BigDecimal singlePrice) {
        this.singlePrice = singlePrice;
    }

    public Integer getRentalDays() {
        return this.rentalDays;
    }

    public void setRentalDays(Integer rentalDays) {
        this.rentalDays = rentalDays;
    }

    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalBenefit() {
        return this.totalBenefit;
    }

    public void setTotalBenefit(BigDecimal totalBenefit) {
        this.totalBenefit = totalBenefit;
    }
}
