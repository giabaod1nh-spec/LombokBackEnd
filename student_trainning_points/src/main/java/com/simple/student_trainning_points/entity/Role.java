package com.simple.student_trainning_points.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //when seeing AUTO INCREMENT
    Integer roleId;
    String roleName;    

    @OneToMany(mappedBy = "role")
    Set<User> users = new HashSet<>();

    @ManyToMany
    Set<Permission> permissions = new HashSet<>();
}
