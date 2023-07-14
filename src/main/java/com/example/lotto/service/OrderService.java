package com.example.lotto.service;

import com.example.lotto.domain.Lotto;
import com.example.lotto.domain.Member;
import com.example.lotto.repository.LottoRepository;
import com.example.lotto.domain.member.repository.MemberRepository;
import com.example.lotto.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;
    private final LottoRepository lottoRepository;

    /**
     * 주문
     */
    @Transactional
    public Long order(Long memberId, Long lottoId, int count) {
        //엔티티 조회
        Member member = memberRepository.findOne(memberId);
        Lotto lotto = lottoRepository.findOne(lottoId);
    }
}
