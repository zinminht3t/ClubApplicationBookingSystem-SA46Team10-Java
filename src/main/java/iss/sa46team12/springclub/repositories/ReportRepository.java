package iss.sa46team12.springclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import iss.sa46team12.springclub.models.User;

public interface ReportRepository extends JpaRepository<User, Integer> {

}
