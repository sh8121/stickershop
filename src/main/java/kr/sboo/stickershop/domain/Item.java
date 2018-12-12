package kr.sboo.stickershop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "item")
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int price;
    private String imageUrl;
    private int stock;
    private LocalDateTime regDate;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
