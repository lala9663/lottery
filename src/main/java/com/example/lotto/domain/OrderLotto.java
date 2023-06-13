package com.example.lotto.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "order_lotto")
@Getter
@Setter
public class OrderLotto {
    @Id
    @GeneratedValue
    @Column(name = "order_lotto_id")
    private Long order_item_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lotto_id")
    private Lotto lotto;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
    private int orderPrice;
    private int count;

    //==생성 메서드==//
    public static OrderLotto createOrderLotto(Lotto lotto, int orderPrice, int count) {
        OrderLotto orderLotto = new OrderLotto();
        orderLotto.setLotto(lotto);
        orderLotto.setOrderPrice(orderPrice);
        orderLotto.setCount(count);
        return orderLotto;
    }

    //==비즈니스 로직==//
    /**
     * 주문상품 전체 가격 조회
     */
    public int getTotalPrice() {
        return getOrderPrice() * getCount();
    }
}
