package com.poly.lab8.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "users")
public class Account implements Serializable {
    @Id
    String username;
    String password;
    Boolean admin = false;
}
