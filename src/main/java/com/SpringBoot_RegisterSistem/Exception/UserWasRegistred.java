package com.SpringBoot_RegisterSistem.Exception;

public class UserWasRegistred extends RuntimeException {
    public UserWasRegistred(String message) {
        super(message);
    }
}
