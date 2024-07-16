package app.springbootproject3web.Farmer.RepositoryFarmer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.springbootproject3web.Farmer.Pojo.Farmer;

@Repository
public interface FarmerRepo extends JpaRepository<Farmer, Integer> {

}
