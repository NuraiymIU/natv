package kg.easy.javaspringbootnatv.service.impl;

import kg.easy.javaspringbootnatv.dao.DayRepo;
import kg.easy.javaspringbootnatv.models.entity.Day;
import kg.easy.javaspringbootnatv.service.DayService;
import org.springframework.stereotype.Service;

@Service
public class DayServiceImpl implements DayService {

    private final DayRepo dayRepo;

    public DayServiceImpl(DayRepo dayRepo) {
        this.dayRepo = dayRepo;
    }

    @Override
    public void save(Day day) {
        dayRepo.save(day);
    }

}
