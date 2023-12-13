package com.example.demo.views;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProfileView {
    String username;
    String firstName;
    String lastName;
}
