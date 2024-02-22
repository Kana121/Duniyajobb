package com.microden.in.controller;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microden.in.dto.JobPost;
import com.microden.in.dto.Registration;
import com.microden.in.entity.UserEntity;
import com.microden.in.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")

public class UserController {

@Autowired
private UserService userservice;

@PostMapping("/register")

public UserEntity registeruser(@RequestBody Registration user){
	
	return userservice.registeruser(user);
}
//working on opt
@PostMapping("/get-otp")
public Boolean getOtp(@RequestParam String emailAdress, String otp ) {
    String newotp = RandomStringUtils.randomNumeric(6);

    return userservice.getOtp(emailAdress, newotp);
	
}
@PostMapping("/verify-otp")
public String verifyOtp(@RequestBody String email, String Otp) {
	return "otp verified Succesfully";
}
@PostMapping("/post")
public UserEntity saveJob(@RequestBody JobPost job) {
	return userservice.saveJob(job);
}
@GetMapping("/jobsList")
  public List<UserEntity> getAllJobs() {
    return userservice.getAllJobs();
}
@GetMapping("/{jobid}")
public ResponseEntity< UserEntity> getJobByjobid(@PathVariable Long jobid) {
	UserEntity job= userservice.getJobByjobid(jobid);
    return ResponseEntity.ok(job);
}
@DeleteMapping("/{jobid}")
public ResponseEntity<UserEntity> deleteJob(@PathVariable Long jobid) {
    UserEntity deletedJob = userservice.deleteJob(jobid);

    if (deletedJob != null) {
        return ResponseEntity.ok(deletedJob);
    } else {
        // Handle the case where the job with the given ID is not found
        return ResponseEntity.notFound().build();
    }
}
}
