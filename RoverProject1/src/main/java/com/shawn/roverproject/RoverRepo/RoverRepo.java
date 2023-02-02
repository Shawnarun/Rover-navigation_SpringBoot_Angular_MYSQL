package com.shawn.roverproject.RoverRepo;

import com.shawn.roverproject.entity.Rover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface RoverRepo extends JpaRepository<Rover,Integer> {

}