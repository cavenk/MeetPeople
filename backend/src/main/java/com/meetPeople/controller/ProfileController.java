package com.meetPeople.controller;

import com.meetPeople.model.Profile;
import com.meetPeople.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
@CrossOrigin("*")
public class ProfileController {

    @Autowired
    ProfileService profileService;


    @GetMapping("/availableProfile/{id}")
    public List<Profile> getAvailableProfile(@PathVariable int id){
        return profileService.getAvailableProfile(id);
    }

    @GetMapping("/{id}")
    public Profile getProfile(@PathVariable int id){
        return profileService.getShortProfile(id);
    }

    @GetMapping("/detailProfil/{myId}/{potentialMatchId}")
    public Profile showMatchDetailedProfile(@PathVariable int myId, @PathVariable int potentialMatchId){
        return profileService.showMatchDetailedProfile(myId, potentialMatchId);
    }

    @GetMapping("/searchByAge/{idMemberLooking}/{ageMin}/{ageMax}")
    public List<Profile> showAvailableProfileByAge (@PathVariable int idMemberLooking,@PathVariable int ageMin,@PathVariable int ageMax){
        return profileService.showAvailableProfilesByAge(idMemberLooking,ageMin,ageMax);
    }

    @GetMapping("/searchByGender/{idMemberLooking}/{genderWanted}")
    public List<Profile> showAvailableProfilesByGender (@PathVariable int idMemberLooking,@PathVariable String genderWanted){
        return profileService.showAvailableProfilesByGender(idMemberLooking,genderWanted);
    }

}
