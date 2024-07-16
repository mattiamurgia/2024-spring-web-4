package app.springbootproject3web.Farmer.ControllerFarmer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.springbootproject3web.Farm.Pojo.Farm;
import app.springbootproject3web.Farm.ServiceFarm.ServiceFarm;
import app.springbootproject3web.Farmer.FarmerDTO.FarmerDTO;
import app.springbootproject3web.Farmer.Pojo.Farmer;
import app.springbootproject3web.Farmer.ServiceFarmer.ServiceFarmer;

@RestController
@RequestMapping("farmers")
public class ControllerFarmer {
    @Autowired
    private ServiceFarmer serviceFarmer;

    @Autowired
    private ServiceFarm serviceFarm;

    @PostMapping("add")
    public ResponseEntity<Farmer> addFarmers() {

        Farm farm1 = new Farm("Location 1", "New York");
        Farm farm2 = new Farm("Location 2", "Parigi");
        Farm farm3 = new Farm("Location 3", "Roma");

        serviceFarm.saveFarm(farm1);
        serviceFarm.saveFarm(farm2);
        serviceFarm.saveFarm(farm3);

        Farmer f1 = new Farmer("Alessio", "HAjdkkd", 13, farm1);
        Farmer f2 = new Farmer("Filippo", "Ajdkdm", 25, farm2);
        Farmer f3 = new Farmer("Mattia", "Murgia", 18, farm3);

        serviceFarmer.saveFarmer(f1);
        serviceFarmer.saveFarmer(f2);
        serviceFarmer.saveFarmer(f3);

        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<List<Farmer>> getAllFarmers() {
        List<Farmer> farmers = serviceFarmer.getAllFarmers();
        return ResponseEntity.ok().body(farmers);
    }

    @PostMapping("")
    public ResponseEntity<Farmer> addFarmer(
            @RequestBody FarmerDTO FarmerDTO) {

        Optional<Farmer> farmerFind = serviceFarmer.getFarmerById(FarmerDTO.getId());
        if (farmerFind.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        Optional<Farm> farmFind = serviceFarm.getFarmById(FarmerDTO.getFarmId());
        if (farmFind.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        Farm newFarm = farmFind.get();
        Farmer newFarmer = new Farmer(FarmerDTO);
        newFarmer.setFarm(newFarm);

        serviceFarmer.saveFarmer(newFarmer);

        return ResponseEntity.ok(newFarmer);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteFarmer(@PathVariable int id) {
        Optional<Farmer> findFarmer = serviceFarmer.getFarmerById(id);

        if (findFarmer.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Farmer newFarmer = findFarmer.get();
        serviceFarmer.deleteFarmer(newFarmer);

        return ResponseEntity.ok().build();
    }

    @PatchMapping("{id}")
    public ResponseEntity<Farmer> updateFarmer(@PathVariable int id, @RequestBody FarmerDTO FarmerDTO) {

        Optional<Farmer> findFarmer = serviceFarmer.getFarmerById(id);

        if (findFarmer.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Farmer newFarmer = findFarmer.get();
        newFarmer.updateFarmer(FarmerDTO);

        Optional<Farm> farmFind = serviceFarm.getFarmById(FarmerDTO.getFarmId());

        if (farmFind.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        Farm newFarm = farmFind.get();
        newFarmer.setFarm(newFarm);

        serviceFarmer.saveFarmer(newFarmer);

        return ResponseEntity.ok(newFarmer);
    }

}
