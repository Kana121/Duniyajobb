package com.microden.in.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.microden.in.UserRepository;
import com.microden.in.dto.Login;
import com.microden.in.dto.Registration;
import com.microden.in.entity.UserEntity;
import com.microden.in.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	@Autowired
	private JavaMailSender javaMailSender;


	@Override
	public UserEntity registeruser(Registration user) {
	
		UserEntity usr=new UserEntity();
		usr.setName(user.getName());
		usr.setEmailAdress(user.getEmailAdress());
		usr.setPhno(user.getPhno());
		usr.setPassword(user.getPassword());
		return repository.save(usr);
	}

	@Override
	public String login(Login login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserEntity> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity getuser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public  Boolean getOtp(String emailAdress, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("officialkanhaiya121@gmail.com");
        message.setTo(emailAdress);
        message.setSubject("Your OTP for Verification");
        message.setText("Your OTP is: " + otp);

       javaMailSender.send(message);
	return true;
	

	}

	@Override
	public String verifyOtp(String email, String Otp) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
