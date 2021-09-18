package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name="member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member") // 하나의 고객이 여러개의 주문을 가진다, 그리고 연관관계의 주인은 member이고 매핑된 관계는 order table에 있는 member 필드에의해 매핑되었다
    private List<Order> orders = new ArrayList<>();


}
