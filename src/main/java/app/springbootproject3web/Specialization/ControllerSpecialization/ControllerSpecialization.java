package app.springbootproject3web.Specialization.ControllerSpecialization;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.springbootproject3web.Specialization.Pojo.Specialization;
import app.springbootproject3web.Specialization.ServiceSpecialization.ServiceSpecialization;

@RestController
@RequestMapping("specializations")
@CrossOrigin(origins = "http://localhost:5173")
public class ControllerSpecialization {

    @Autowired
    private ServiceSpecialization serviceSpecialization;

    @GetMapping("")
    public ResponseEntity<List<Specialization>> getAllSpecializations() {
        List<Specialization> specializations = serviceSpecialization.getAllSpecializations();
        return ResponseEntity.ok().body(specializations);
    }
}
