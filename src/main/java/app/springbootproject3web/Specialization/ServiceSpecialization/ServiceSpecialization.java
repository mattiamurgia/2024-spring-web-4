package app.springbootproject3web.Specialization.ServiceSpecialization;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.springbootproject3web.Specialization.Pojo.Specialization;
import app.springbootproject3web.Specialization.RepositorySpecialization.RepoSpecialization;

@Service
public class ServiceSpecialization {
    @Autowired
    private RepoSpecialization repoSpecialization;

    public void saveSpecialization(Specialization Specialization) {
        repoSpecialization.save(Specialization);
    }

    public List<Specialization> getAllSpecializations() {
        return repoSpecialization.findAll();
    }

    public Optional<Specialization> getSpecializationById(Integer ID) {
        return repoSpecialization.findById(ID);
    }

    public void deleteSpecialization(Specialization Specialization) {
        repoSpecialization.delete(Specialization);
    }

}
