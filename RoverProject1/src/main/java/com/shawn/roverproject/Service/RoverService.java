package com.shawn.roverproject.Service;


import com.shawn.roverproject.DTO.RoverDTO;
import com.shawn.roverproject.DTO.RoverReplayDTO;
import com.shawn.roverproject.DTO.RoverSaveDTO;

import java.util.List;

public interface RoverService {

    String addRover(RoverSaveDTO roversaveDTO);

    List<RoverDTO> getAllrovers();

    String updateRovers(RoverReplayDTO roverreplayDTO);

    boolean deleteHistory(int id);
}
