package app.springbootproject3web.Farm.RepositoryFarm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.springbootproject3web.Farm.Pojo.Farm;

@Repository
public interface RepoFarm extends JpaRepository<Farm, Integer> {

}
