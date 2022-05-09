package kg.easy.javaspringbootnatv.service;

import kg.easy.javaspringbootnatv.models.json.OrderResultSet;

public interface OrderService {

    OrderResultSet saveOrder(OrderResultSet orderResultSet);

}
