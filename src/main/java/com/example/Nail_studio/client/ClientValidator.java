package com.example.Nail_studio.client;

import com.example.Nail_studio.validator.ValidatorResult;

import java.util.function.Function;

import static com.example.Nail_studio.validator.ValidatorResult.*;

public interface ClientValidator extends Function<Client, ValidatorResult> {

    /*static ClientValidator validateFirstName(){
        return client -> client.getFirstName().length() > 0 ? SUCCESS : NOT_VALID;
    }

    static ClientValidator validateLastName(){
        return client -> client.getLastName().length() > 0 ? SUCCESS : NOT_VALID;
    }

    static ClientValidator validateEmail(){
        return client -> client.getEmail().length() > 0 ? SUCCESS : NOT_VALID;
    }

    static ClientValidator validateAllClient(){
        return client -> validateFirstName()
                .and(validateLastName())
                .and(validateEmail())
                .apply(client);
    }*/

    static ClientValidator validateNotNull(String string){
        return client -> string.length() > 0 ? SUCCESS : NOT_VALID_STRING_IS_EMPTY;
    }

    static ClientValidator validateEmail(String email){
        return client -> email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$") ? SUCCESS : NOT_VALID_EMAIL_REGEX;
    }

    static ClientValidator validatePhone(String phone){
        return client -> phone.matches("(?:\\\\(\\\\d{3}\\\\)|\\\\d{3}[-]*)\\\\d{3}[-]*\\\\d{4}") ? SUCCESS : NOT_VALID_PHONE_REGEX;
    }



    static ClientValidator allValidations(){
        return client -> validateNotNull(client.getFirstName())
                .and(validateNotNull(client.getLastName()))
                .and(validateNotNull(client.getEmail()))
                .and(validateNotNull(client.getPhone()))
                .and(validateEmail(client.getEmail()))
                .and(validatePhone(client.getPhone()))
                .apply(client);
    }



    default ClientValidator and(ClientValidator other){
        return client -> {
            ValidatorResult result = this.apply(client);
            return result.equals(SUCCESS) ? other.apply(client) : result;
        };
    }


}


