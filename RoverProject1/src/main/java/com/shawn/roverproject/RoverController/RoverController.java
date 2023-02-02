package com.shawn.roverproject.RoverController;

import com.shawn.roverproject.DTO.RoverDTO;
import com.shawn.roverproject.DTO.RoverReplayDTO;
import com.shawn.roverproject.DTO.RoverSaveDTO;
import com.shawn.roverproject.Service.RoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/rover")
public class RoverController {

    @Autowired
    private RoverService roverservice;




    @PostMapping(path="/save")
    public String saveRover(@RequestBody RoverSaveDTO roversaveDTO)
    {
        String id = roverservice.addRover(roversaveDTO);
        return id;
    }

    @GetMapping(path="/getAllrovers")
    @ResponseBody
    public List<RoverDTO> getAllrovers()
    {
        List<RoverDTO>allRovers =roverservice.getAllrovers();
        return allRovers;
    }


    @PutMapping(path="/replay")
    public String replayrover(@RequestBody RoverReplayDTO roverreplayDTO)
    {
        String id = roverservice.updateRovers(roverreplayDTO);
        return id;
    }

    @DeleteMapping(path="/delete/{id}")
    public String deletehistory(@PathVariable(value ="id") int id)
    {
      boolean deletehistory = roverservice.deleteHistory(id);
        return "deleted";
    }
}
