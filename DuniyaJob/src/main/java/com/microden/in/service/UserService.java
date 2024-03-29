package com.microden.in.service;

import java.util.List;

import com.microden.in.dto.JobPost;
import com.microden.in.dto.Login;
import com.microden.in.dto.Registration;
import com.microden.in.entity.UserEntity;

public interface UserService {
UserEntity registeruser(Registration user);

String login(Login login);

List<UserEntity> getUsers();

UserEntity getuser(Long id);

 Boolean getOtp(String emailAdress, String otp);
 
 String verifyOtp(String email, String Otp); 
 
// for posting job
 UserEntity saveJob(JobPost job);
 
 List<UserEntity> getAllJobs();
 
 
 UserEntity getJobByjobid(Long jobid);
 

 UserEntity  deleteJob(Long jobid); 


}