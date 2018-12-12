package kr.sboo.stickershop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "member")
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userId;
    private String password;
    private String name;
    private LocalDateTime regDate;
    @ManyToMany
    @JoinTable(name = "member_role",
            joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;
    @OneToMany(mappedBy = "member")
    private Set<Item> items;
    @OneToMany(mappedBy = "member")
    private Set<CartItem> cartItems;
    @OneToMany(mappedBy = "member")
    private Set<Order> orders;
}
