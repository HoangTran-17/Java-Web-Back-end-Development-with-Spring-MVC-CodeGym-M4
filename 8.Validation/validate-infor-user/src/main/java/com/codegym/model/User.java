package com.codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class User implements Validator {
//    @NotEmpty(message = "Name not empty")
//    @Size(min = 2, max = 30, message = "2-30")
    private String name;

//    @Min(value = 18,message = ">=18")
    private int age;


    private String phoneNumber;

    public User(){}

//    public User(@NotEmpty @Size(min = 2, max = 30) String name, @Min(18) int age) {
//        this.name = name;
//        this.age = age;
//    }

    public User(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String name = user.getName();
        int age = user.getAge();
        String phoneNumber = user.getPhoneNumber();

        ValidationUtils.rejectIfEmpty(errors,"name","name.empty");
        if (name.length() > 30 || name.length() < 2) {
            errors.rejectValue("name","name.length");
        }

        ValidationUtils.rejectIfEmpty(errors,"age","age.empty");
        if (age < 18) {
            errors.rejectValue("age","age.value");
        }

        ValidationUtils.rejectIfEmpty(errors,"phoneNumber","phoneNumber.empty");
        if (!phoneNumber.matches("([\\+84|84|0]+(3|5|7|8|9))+([0-9]{8})")) {
            errors.rejectValue("phoneNumber","phoneNumber.pattern");
        }

    }


}
