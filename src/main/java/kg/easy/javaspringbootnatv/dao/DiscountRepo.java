package kg.easy.javaspringbootnatv.dao;

import kg.easy.javaspringbootnatv.models.entity.Discount;
import kg.easy.javaspringbootnatv.models.json.DiscountsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DiscountRepo extends JpaRepository<Discount, Long> {

    @Query("select new kg.easy.javaspringbootnatv.models.json.DiscountsDto(u.minDays, u.percent)" +
            " from Discount u where u.channel.id = ?1 and ?2 between u.startDate and u.endDate")
    List<DiscountsDto> findDiscountsByChannelId(Long channelId, Date date);

}
