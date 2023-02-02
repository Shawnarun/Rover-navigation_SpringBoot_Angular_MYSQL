package com.shawn.roverproject.Service;

import com.shawn.roverproject.DTO.RoverDTO;
import com.shawn.roverproject.DTO.RoverReplayDTO;
import com.shawn.roverproject.DTO.RoverSaveDTO;
import com.shawn.roverproject.RoverRepo.RoverRepo;
import com.shawn.roverproject.entity.Rover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoverClassIMPL implements RoverService {

    @Autowired
    private RoverRepo roverRepo;

    @Override
    public String addRover(RoverSaveDTO roversaveDTO) {
        // TODO Auto-generated method stub


        Rover rover= new Rover(
                roversaveDTO.getX(),
                roversaveDTO.getY(),
                roversaveDTO.getDirection(),
                roversaveDTO.getPath(),
                roversaveDTO.getDestination()
        );

        roverRepo.save(rover);
        return rover.getDestination();
    }

    @Override
    public List<RoverDTO> getAllrovers(){

        List<Rover> getRovers=roverRepo.findAll();
        List<RoverDTO> roverDTOList = new ArrayList<>();
        for(Rover a:getRovers) {
            RoverDTO roverDTO= new RoverDTO(
                    a.getRoverid(),
                    a.getX(),
                    a.getY(),
                    a.getDirection(),
                    a.getPath(),
                    a.getLastUpdate(),
                    a.getDestination()
            );
            roverDTOList.add(roverDTO);
        }
        return roverDTOList;

    }

    @Override
    public String updateRovers(RoverReplayDTO roverreplayDTO) {

        if(roverRepo.existsById(roverreplayDTO.getRoverid()))
        {
            Rover rover = roverRepo.getById(roverreplayDTO.getRoverid());
            rover.setX(roverreplayDTO.getX());
            rover.setY(roverreplayDTO.getY());
            rover.setDirection(roverreplayDTO.getDirection());
            rover.setPath(roverreplayDTO.getPath());
            rover.setLastUpdate(roverreplayDTO.getLastUpdate());
            rover.setDestination(roverreplayDTO.getDestination());
         roverRepo.save(rover);
        }
        else {
            System.out.println("Rover Not Found");
        }
        return null;
    }

    @Override
    public boolean deleteHistory(int id) {

        if(roverRepo.existsById(id))
        {
            roverRepo.deleteById(id);
        }
        else {
            System.out.println("Rover Not Found");
        }
        return false;
    }


}
