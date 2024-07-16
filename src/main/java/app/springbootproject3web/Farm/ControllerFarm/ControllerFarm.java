package app.springbootproject3web.Farm.ControllerFarm;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.springbootproject3web.Farm.FarmDTO.FarmDTO;
import app.springbootproject3web.Farm.Pojo.Farm;
import app.springbootproject3web.Farm.ServiceFarm.ServiceFarm;

@RestController
@RequestMapping("farm")
public class ControllerFarm {

    @Autowired
    private ServiceFarm serviceFarm;

    @GetMapping("")
    public ResponseEntity<List<Farm>> getAllFarms() {
        List<Farm> farms = serviceFarm.getAllFarms();
        return ResponseEntity.ok().body(farms);
    }

    @PostMapping("")
    public ResponseEntity<Farm> addFarm(@RequestBody FarmDTO FarmDTO) {
        Optional<Farm> farmFind = serviceFarm.getFarmById(FarmDTO.getId());

        if (farmFind.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        Farm newFarm = new Farm(FarmDTO);

        serviceFarm.saveFarm(newFarm);
        return ResponseEntity.ok(newFarm);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Farm> updateFarm(@PathVariable int id, @RequestBody FarmDTO FarmDTO) {
        Optional<Farm> farmFind = serviceFarm.getFarmById(id);

        if (farmFind.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Farm newFarm = farmFind.get();
        newFarm.updateFarm(FarmDTO);

        serviceFarm.saveFarm(newFarm);
        return ResponseEntity.ok(newFarm);
    }

}
