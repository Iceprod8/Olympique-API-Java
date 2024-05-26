package fr.olympicgames.controller;

import fr.olympicgames.model.Stadium;
import fr.olympicgames.service.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stadiums")
public class StadiumController {

    @Autowired
    private StadiumService stadiumService;

    @GetMapping
    public ResponseEntity<List<Stadium>> getAllStadiums() {
        List<Stadium> stadiums = stadiumService.getAllStadiums();
        return ResponseEntity.ok(stadiums);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stadium> getStadiumById(@PathVariable Long id) {
        Stadium stadium = stadiumService.getStadiumById(id);
        return ResponseEntity.ok(stadium);
    }

    @PostMapping
    public ResponseEntity<Stadium> createStadium(@RequestBody Stadium stadium) {
        Stadium newStadium = stadiumService.createStadium(stadium);
        return ResponseEntity.ok(newStadium);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stadium> updateStadium(@PathVariable Long id, @RequestBody Stadium stadiumDetails) {
        Stadium updatedStadium = stadiumService.updateStadium(id, stadiumDetails);
        return ResponseEntity.ok(updatedStadium);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStadium(@PathVariable Long id) {
        stadiumService.deleteStadium(id);
        return ResponseEntity.noContent().build();
    }
}
