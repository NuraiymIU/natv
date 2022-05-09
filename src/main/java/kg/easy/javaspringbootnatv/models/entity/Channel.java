package kg.easy.javaspringbootnatv.models.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "channels")
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String photo;
    private boolean active;

    @Column(name = "order_num")
    private int orderNum;

}
