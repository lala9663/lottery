package com.example.lottojpa.member.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "non_members")
@Getter
@Setter
@NoArgsConstructor
public class NonMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "n_id")
    private String nId;

    @Column(name = "non_name", nullable = false)
    private String nonName;

    @Column(name = "non_email", nullable = false)
    private String nonEmail;
    @Column(name = "non_phone", nullable = false)
    private String nonPhone;
}
