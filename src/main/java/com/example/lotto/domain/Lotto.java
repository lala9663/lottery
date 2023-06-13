package com.example.lotto.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
public class Lotto {
    @Id
    @GeneratedValue
    @Column(name = "lotto_id")
    private Long lotto_id;
    private int round;
    private int ball1;
    private int ball2;
    private int ball3;
    private int ball4;
    private int ball5;
    private int ball6;
    private int bonus;
    private int price;

}
