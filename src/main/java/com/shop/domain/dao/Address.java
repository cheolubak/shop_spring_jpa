package com.shop.domain.dao;

import com.shop.domain.dto.AddressDTO;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;

    public String buyer;

    public String address;

    public String detail;

    public String postcode;

    public String tel;

    @CreationTimestamp
    public LocalDateTime createAt;

    @UpdateTimestamp
    public LocalDateTime updateAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    public Address() {
    }

    public Address(AddressDTO address) {
        this.name = address.getName();
        this.buyer = address.getBuyer();
        this.address = address.getAddress();
        this.detail = address.getDetail();
        this.postcode = address.getPostcode();
        this.tel = address.getTel();
    }
}
