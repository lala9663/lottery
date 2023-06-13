package com.example.lotto.repository;

import com.example.lotto.domain.Order;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    private final EntityManager em;

    public OrderRepository(EntityManager em) {
        this.em = em;
    }

    public void save(Order order) {
        em.persist(order);
    }

    public Order findOne(Long id) {
        return em.find(Order.class, id);
    }

    public List<Order> findAllByString(OrderSearch orderSearch) {
        String jpql = "select o from Order o join o.member m";
        boolean isFirstCondition = true;

        //회원 이름 검색
        if (StringUtils.hasText(orderSearch.getMemberId())) {
            if (isFirstCondition) {
                jpql += " where";
                isFirstCondition = false;
            } else {
                jpql += " and";
            }
            jpql += " m.id like :id";
        }

        TypedQuery<Order> query = em.createQuery(jpql, Order.class)
                .setMaxResults(1000);
        if (orderSearch.getCount() != null) {
            query = query.setParameter("count", orderSearch.getCount());
        }
        if (StringUtils.hasText(orderSearch.getMemberId())) {
            query = query.setParameter("memberId", orderSearch.getMemberId());
        }
        return query.getResultList();
    }

    /**
     * JPA Criteria
     */
    public List<Order> findAllByCriteria(OrderSearch orderSearch) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);
        Root<Order> o = cq.from(Order.class);
        Join<Object, Object> m = o.join("member", JoinType.INNER);

        List<Predicate> criteria = new ArrayList<>();

        //주문 수량 검색
        if (orderSearch.getCount() != null) {
            Predicate count = cb.equal(o.get("count"), orderSearch.getCount());
            criteria.add(count);
        }

        //회원 이름 검색
        if (StringUtils.hasText(orderSearch.getMemberId())) {
            Predicate id =
                    cb.like(m.get("id"), "%" + orderSearch.getMemberId() + "%");
            criteria.add(id);
        }

        cq.where(cb.and(criteria.toArray(new Predicate[criteria.size()])));
        TypedQuery<Order> query = em.createQuery(cq).setMaxResults(1000);
        return query.getResultList();
    }

}
