package com.jns.pojo;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;


public class Customer {
    private Integer cid;

    @NotBlank(message="{name.error}")
    private String name;

    @Size(min=11,max=11,message="{customer.phone.length}")
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}
