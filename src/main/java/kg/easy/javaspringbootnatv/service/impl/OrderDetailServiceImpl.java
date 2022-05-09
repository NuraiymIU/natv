package kg.easy.javaspringbootnatv.service.impl;

import kg.easy.javaspringbootnatv.dao.OrderDetailRepo;
import kg.easy.javaspringbootnatv.models.entity.OrderDetail;
import kg.easy.javaspringbootnatv.service.OrderDetailService;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    private final OrderDetailRepo orderDetailRepo;

    public OrderDetailServiceImpl(OrderDetailRepo orderDetailRepo) {
        this.orderDetailRepo = orderDetailRepo;
    }

    @Override
    public void saveOrderDetail(OrderDetail orderDetail) {
        orderDetailRepo.save(orderDetail);
    }

}
