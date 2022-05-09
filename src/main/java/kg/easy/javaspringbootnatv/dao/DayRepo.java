package kg.easy.javaspringbootnatv.dao;

import kg.easy.javaspringbootnatv.models.dto.DayDto;
import kg.easy.javaspringbootnatv.models.entity.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayRepo extends JpaRepository<Day, Long> {

    List<DayDto> findAllByOrderDetailId(Long orderDetailId);

}
