package app.springbootproject3web.Farm.ServiceFarm;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.springbootproject3web.Farm.Pojo.Farm;
import app.springbootproject3web.Farm.RepositoryFarm.RepoFarm;

@Service
public class ServiceFarm {

    @Autowired
    private RepoFarm repoFarm;


    public void saveFarm(Farm Farm) {
        repoFarm.save(Farm);
    }


    public List<Farm> getAllFarms() {
        return repoFarm.findAll();
    }


    public Optional<Farm> getFarmById(Integer ID) {
        return repoFarm.findById(ID);
    }


    public void deleteFarm(Farm Farm) {
        repoFarm.delete(Farm);

    }
}
