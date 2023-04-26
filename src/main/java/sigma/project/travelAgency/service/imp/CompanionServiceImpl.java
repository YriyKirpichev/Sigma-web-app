package sigma.project.travelAgency.service.imp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sigma.project.travelAgency.entity.Companion;
import sigma.project.travelAgency.entity.Hotel;
import sigma.project.travelAgency.repository.CompanionRepository;
import sigma.project.travelAgency.service.CompanionService;


@Slf4j
@Service
@AllArgsConstructor
public class CompanionServiceImpl implements CompanionService {

    private CompanionRepository companionRepository;

    @Override
    public Companion create(Companion companion) {
        log.info("Create companion: '{}' '{}'", companion.getFirstName() , companion.getSecondName());
        return companionRepository.save(companion);
    }

    @Override
    public Companion getCompanionById(Long id) {
        log.info("Searching companion by id: '{}'", id);
        return companionRepository.findCompanionById(id)
                .orElseThrow(() -> new IllegalArgumentException("Companion doesn't exists"));
    }

    @Override
    public boolean checkCompanion(String phone) {
        return companionRepository.existsByPhone(phone);
    }

    @Override
    public Companion getCompanionByHotel(Hotel hotel) {
        log.info("Searching companion by hotel: '{}'", hotel.getHotelName());
        return companionRepository.findCompanionByHotel(hotel);
    }

    @Override
    public void deleteCompanion(Long id) {
        log.info("Deleting companion by id: '{}'", id);
        companionRepository.deleteById(id);
    }
}
