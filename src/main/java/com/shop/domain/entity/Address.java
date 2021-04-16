package com.shop.domain.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            nullable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            length = 20
    )
    private String name;

    @Column(
            name = "buyer",
            nullable = false,
            length = 20
    )
    private String buyer;

    @Column(
            name = "address",
            nullable = false,
            length = 100
    )
    private String address;

    @Column(
            name = "detail",
            nullable = false,
            length = 100
    )
    private String detail;

    @Column(
            name = "postcode",
            nullable = false,
            length = 6
    )
    private String postcode;

    @Column(
            name = "tel",
            nullable = false,
            length = 11
    )
    private String tel;

    @CreationTimestamp
    @Column(
            name = "create_at",
            nullable = false
    )
    private LocalDateTime createAt;

    @UpdateTimestamp
    @Column(
            name = "update_at",
            nullable = false
    )
    private LocalDateTime updateAt;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "address_user_fk"), nullable = false)
    private User user;

    public Address() {
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getBuyer() {
        return buyer;
    }

    public String getAddress() {
        return address;
    }

    public String getDetail() {
        return detail;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getTel() {
        return tel;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public User getUser() {
        return user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
