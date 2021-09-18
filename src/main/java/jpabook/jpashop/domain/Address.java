package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable // Order과 같이 하나의 entity가 아니고 Member에 내장되기 때문에
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;

    protected Address(){} //jpa가 생성자가 필요로 하기 때문

    public Address(String city, String street,String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
