package kg.easy.javaspringbootnatv.dao;

import kg.easy.javaspringbootnatv.models.entity.Channel;
import kg.easy.javaspringbootnatv.models.sql.ChannelResultSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelRepo extends JpaRepository<Channel, Long> {

    @Query(value = "select new kg.easy.javaspringbootnatv.models.sql.ChannelResultSet" +
            "(c.id, c.name, c.photo, p.price, d.minDays, d.percent) from Channel c " +
            "join Price p " +
            "on c = p.channel " +
            "join Discount d " +
            "on c = d.channel " +
            "where current_timestamp between p.startDate and p.endDate " +
            "and current_timestamp between d.startDate and d.endDate ")
    List<ChannelResultSet> findAllChannels();

}
