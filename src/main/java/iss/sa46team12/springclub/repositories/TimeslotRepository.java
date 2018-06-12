package iss.sa46team12.springclub.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iss.sa46team12.springclub.models.Timeslots;

public interface TimeslotRepository extends JpaRepository<Timeslots, Integer> {
	@Query("SELECT t from Timeslots t WHERE t.time = :tName")
	Timeslots findTimeslotByName(@Param("tName") String tName);
}
