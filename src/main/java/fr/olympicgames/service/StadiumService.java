package fr.olympicgames.service;

import fr.olympicgames.model.Stadium;
import fr.olympicgames.repository.StadiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StadiumService {

    @Autowired
    private StadiumRepository stadiumRepository;

    public List<Stadium> getAllStadiums() {
        return stadiumRepository.findAll();
    }

    public Stadium getStadiumById(Long id) {
        return stadiumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stadium not found"));
    }

    public Stadium createStadium(Stadium stadium) {
        return stadiumRepository.save(stadium);
    }

    public Stadium updateStadium(Long id, Stadium stadiumDetails) {
        Stadium stadium = getStadiumById(id);
        stadium.setName(stadiumDetails.getName());
        stadium.setLocation(stadiumDetails.getLocation());
        stadium.setCapacity(stadiumDetails.getCapacity());
        return stadiumRepository.save(stadium);
    }

    public void deleteStadium(Long id) {
        Stadium stadium = getStadiumById(id);
        stadiumRepository.delete(stadium);
    }
}
