package com.auto_store.auto_store.dto;

import com.auto_store.auto_store.model.Address;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class UserDTO implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private byte[] avatar;
    private Set<Address> addresses;
}