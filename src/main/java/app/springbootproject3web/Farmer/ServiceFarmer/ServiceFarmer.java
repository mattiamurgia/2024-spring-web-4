package app.springbootproject3web.Farmer.ServiceFarmer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.springbootproject3web.Farmer.Pojo.Farmer;
import app.springbootproject3web.Farmer.RepositoryFarmer.FarmerRepo;

@Service
public class ServiceFarmer {
    @Autowired
    private FarmerRepo repoFarmer;

    public void saveFarmer(Farmer Farmer) {
        repoFarmer.save(Farmer);
    }

    public List<Farmer> getAllFarmers() {
        return repoFarmer.findAll();
    }

    public Optional<Farmer> getFarmerById(Integer ID) {
        return repoFarmer.findById(ID);
    }

    public void deleteFarmer(Farmer Farmer) {
        repoFarmer.delete(Farmer);

    }

}
