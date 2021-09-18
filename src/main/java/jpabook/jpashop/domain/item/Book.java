package jpabook.jpashop.domain.item;
import jpabook.jpashop.domain.Item;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B") // album,book,movie가 겹치므로 각 엔터티마다 구분할 수 있게 하기 위함
@Getter
@Setter
public class Book extends Item{

    private String author;
    private String isbn;
}
