package iss.sa46team12.springclub.repositories;

//import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import iss.sa46team12.springclub.models.Bookings;

public interface BookingsRepository extends JpaRepository<Bookings, Integer> {

	//Custom SQL Operations here
}
