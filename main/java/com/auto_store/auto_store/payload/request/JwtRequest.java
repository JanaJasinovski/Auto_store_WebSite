package com.auto_store.auto_store.payload.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JwtRequest {
    private String email;
    private String password;
}
