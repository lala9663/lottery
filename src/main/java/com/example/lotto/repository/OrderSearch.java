package com.example.lotto.repository;

import com.example.lotto.domain.OrderLotto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderSearch {
    private String memberId; // 회원 닉네임
    private OrderLotto count;
}
