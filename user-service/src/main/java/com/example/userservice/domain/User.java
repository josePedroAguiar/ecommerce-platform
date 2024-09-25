package com.example.userservice.domain;



import lombok.Data;
import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.Setter;


import java.util.List;


@Data
@EqualsAndHashCode(of = "email")
//@Getter
//@Setter
public class User {
    private String id;
    private String name;
    private String email;
    private Wallet wallet;
    private List<String> orderHistory;


}

