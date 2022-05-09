package kg.easy.javaspringbootnatv.dao;

import kg.easy.javaspringbootnatv.models.entity.Price;
import kg.easy.javaspringbootnatv.models.json.ChannelsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PriceRepo extends JpaRepository<Price, Long> {

    @Query("select new kg.easy.javaspringbootnatv.models.json.ChannelsDto(p.channel.id, p.channel.name, p.channel.photo, p.price)" +
            " from Price p where ?1 between p.startDate and p.endDate and p.channel.active = true")
    List<ChannelsDto> findChannelsWithPrice(Date date);

}
