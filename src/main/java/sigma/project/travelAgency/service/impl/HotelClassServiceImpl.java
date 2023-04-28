package sigma.project.travelAgency.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sigma.project.travelAgency.entity.HotelClass;
import sigma.project.travelAgency.repository.HotelClassRepository;
import sigma.project.travelAgency.service.HotelClassService;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class HotelClassServiceImpl implements HotelClassService{

    private HotelClassRepository hotelClassRepository;


    @Override
    public HotelClass createClass(HotelClass hotelClass) {
        log.info("Create Hotel Class: '{}'", hotelClass.getHotelClassName());
        return hotelClassRepository.save(hotelClass);
    }

    @Override
    public void deleteHotelClassById(Long id) {
        log.info("Delete Hotel Class with id: '{}'", id);
        hotelClassRepository.deleteById(id);
    }

    @Override
    public HotelClass getHotelClassByName(String name) {
        log.info("Searching Hotel Class by name: '{}'", name);
        return hotelClassRepository.findByHotelClassName(name)
                .orElseThrow(() -> new IllegalArgumentException("Hotel Class doesn't exists"));
    }

    @Override
    public List<HotelClass> findAll() {
        return hotelClassRepository.findAll();
    }
}