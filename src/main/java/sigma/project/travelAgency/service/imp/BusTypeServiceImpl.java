package sigma.project.travelAgency.service.imp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sigma.project.travelAgency.entity.BusType;
import sigma.project.travelAgency.repository.BusTypeRepository;
import sigma.project.travelAgency.service.BusTypeService;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class BusTypeServiceImpl implements BusTypeService {

    private BusTypeRepository busTypeRepository;

    @Override
    public BusType createBusType(BusType busType) {
        log.info("Added Bus Type: '{},{}'",busType.getName(), busType.getSeatCount());
        return busTypeRepository.save(busType);
    }

    @Override
    public BusType getBusTypeByName(String name) {

        log.info("Searching Bus Type by Name: '{}'", name);
        return busTypeRepository.findBusTypeByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Bus Type doesn't exists"));
    }

    @Override
    public boolean checkBusTypeName(String name) {
        log.info("Check if Bus Type with name: '{}' exists", name);
        return busTypeRepository.existsBusTypeByName(name);
    }

    @Override
    public List<BusType> getAllBusType() {
        return busTypeRepository.findAll();
    }
}
