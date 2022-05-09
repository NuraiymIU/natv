package kg.easy.javaspringbootnatv.models.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "channels_id")
    private Channel channel;

    @OneToOne
    @JoinColumn(name = "orders_id")
    private Order order;

    private double price;

}
