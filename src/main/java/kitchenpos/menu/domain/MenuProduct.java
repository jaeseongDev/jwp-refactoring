package kitchenpos.menu.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MenuProduct {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    private Long productId;
    private long quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    public MenuProduct() {
    }

    public MenuProduct(Long seq, Long productId, long quantity, Menu menu) {
        this.seq = seq;
        this.productId = productId;
        this.quantity = quantity;
        this.menu = menu;
    }

    public MenuProduct(Long productId, long quantity, Menu menu) {
        this(null, productId, quantity, menu);
    }

    public MenuProduct(Long productId, long quantity) {
        this(productId, quantity, null);
    }

    public Long getSeq() {
        return seq;
    }

    public Long getMenuId() {
        return menu.getId();
    }

    public Long getProductId() {
        return productId;
    }

    public long getQuantity() {
        return quantity;
    }

    public Menu getMenu() {
        return menu;
    }

    public void defineMenu(Menu menu) {
        this.menu = menu;
    }
}
