package com.shop.domain.dto;

import com.shop.domain.entity.Address;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AddressDTO {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String buyer;
    @NotNull
    private String address;
    @NotNull
    private String detail;
    @NotNull
    @Pattern(regexp = "[0-9]{5,6}")
    private String postcode;
    @NotNull
    @Pattern(regexp = "[0-9]{11}")
    private String tel;

    public AddressDTO() {
    }

    public AddressDTO(Address address) {
        id = address.getId();
        name = address.getName();
        buyer = address.getBuyer();
        this.address = address.getAddress();
        detail = address.getDetail();
        postcode = address.getPostcode();
        tel = address.getTel();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
