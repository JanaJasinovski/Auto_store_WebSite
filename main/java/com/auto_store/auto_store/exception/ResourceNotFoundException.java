package com.auto_store.auto_store.exception;

public class ResourceNotFoundException extends IllegalArgumentException {

    public ResourceNotFoundException(String name, String value, Object obj) {
        super(String.format("%s was not found with %s = %s", name, value, obj));
    }
}