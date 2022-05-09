package kg.easy.javaspringbootnatv.models.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "days")
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_detail_id")
    private OrderDetail orderDetail;

    private String days;

}
