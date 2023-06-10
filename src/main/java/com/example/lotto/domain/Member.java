package com.example.lotto.domain;

import com.example.lotto.global.entity.ModifyDate;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@Getter
@Setter
public class Member extends ModifyDate {
    @GeneratedValue
    @Id
    @Column(name = "member_id")
    private Long member_id;
    private String id;
    private String pw;
    private String name;
    private int phone;
    private String email;
    private int birth;
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
