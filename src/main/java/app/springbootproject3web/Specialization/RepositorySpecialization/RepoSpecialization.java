package app.springbootproject3web.Specialization.RepositorySpecialization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.springbootproject3web.Specialization.Pojo.Specialization;

@Repository
public interface RepoSpecialization extends JpaRepository<Specialization, Integer> {

}
