package com.microden.in.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data

public class UserEntity {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
private String name;
private String emailAdress;
private String password;
private String phno;
//for jobpost
private long jobid;
private String title;
private String description;
}
