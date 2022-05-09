package kg.easy.javaspringbootnatv.service.impl;

import kg.easy.javaspringbootnatv.dao.ChannelRepo;
import kg.easy.javaspringbootnatv.dao.OrderRepo;
import kg.easy.javaspringbootnatv.enums.OrderStatus;
import kg.easy.javaspringbootnatv.exceptions.NotFoundException;
import kg.easy.javaspringbootnatv.models.entity.Day;
import kg.easy.javaspringbootnatv.models.entity.Order;
import kg.easy.javaspringbootnatv.models.entity.OrderDetail;
import kg.easy.javaspringbootnatv.models.json.OrderChannelDto;
import kg.easy.javaspringbootnatv.models.json.OrderResultSet;
import kg.easy.javaspringbootnatv.service.DayService;
import kg.easy.javaspringbootnatv.service.OrderDetailService;
import kg.easy.javaspringbootnatv.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final DayService dayService;
    private final OrderDetailService orderDetailService;
    private final ChannelRepo channelRepo;

    public OrderServiceImpl(OrderRepo orderRepo,
                            DayService dayService,
                            OrderDetailService orderDetailService,
                            ChannelRepo channelRepo) {
        this.orderRepo = orderRepo;
        this.dayService = dayService;
        this.orderDetailService = orderDetailService;
        this.channelRepo = channelRepo;
    }

    @Override
    public OrderResultSet saveOrder(OrderResultSet orderResultSet) {
        Order order = new Order();
        order.setText(orderResultSet.getText());
        order.setName(orderResultSet.getName());
        order.setPhone(orderResultSet.getPhone());
        order.setEmail(orderResultSet.getEmail());
        order.setAddDate(new Date());
        order.setTotalPrice(orderResultSet.getTotalPrice());
        order.setStatus(OrderStatus.ACCEPTED);
        orderRepo.save(order);

        List<OrderDetail> orderDetailList = new ArrayList<>();
        List<Day> days = new ArrayList<>();

        for (OrderChannelDto orderChannelDto : orderResultSet.getChannels()) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setChannel(channelRepo.findById(orderChannelDto.getChannelId())
                    .orElseThrow(() -> new NotFoundException("Канал не найден!")));
            orderDetail.setOrder(order);
            orderDetail.setPrice(orderChannelDto.getPrice());
            orderDetailList.add(orderDetail);
            orderDetailService.saveOrderDetail(orderDetail);
            for (String orderDay : orderChannelDto.getDays()) {
                Day day = new Day();
                day.setOrderDetail(orderDetail);
                day.setDays(orderDay);
                days.add(day);
                dayService.save(day);
            }
        }
        return orderResultSet;
    }

}
