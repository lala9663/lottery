package com.example.lotto.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
@Getter
@Setter
public class OrderItem {
    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long order_item_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lotto_id")
    private Lotto lotto;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
    private int orderPrice;
    private int count;
}
