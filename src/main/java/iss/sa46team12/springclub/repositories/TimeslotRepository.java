package iss.sa46team12.springclub.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iss.sa46team12.springclub.models.Timeslots;

public interface TimeslotRepository extends JpaRepository<Timeslots, Integer> {
<<<<<<< HEAD

	@Query("select t from Timeslots t WHERE t.time = :tvalue")
	Timeslots getOneTimeSlot(@Param("tvalue") String tvalue);
=======
	@Query("SELECT t from Timeslots t WHERE t.time = :tName")
	Timeslots findTimeslotByName(@Param("tName") String tName);
>>>>>>> aae6780ba740af52ff444667825e2f953f835cdf
}
