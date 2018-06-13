package iss.sa46team12.springclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iss.sa46team12.springclub.models.Timeslots;

public interface TimeslotRepository extends JpaRepository<Timeslots, Integer> {

	@Query("select t from Timeslots t WHERE t.time = :tvalue")
	Timeslots getOneTimeSlot(@Param("tvalue") String tvalue);
}
