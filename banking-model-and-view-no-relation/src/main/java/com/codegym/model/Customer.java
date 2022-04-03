package codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer implements Validator {

    @Id
    private int customerID;

    private String fullName;
    private String phoneNumber;
    private String email;
    private String address;
    private Double currentBalance;

    public Customer() {

    }

    public Customer(int customerID, String fullName, String phoneNumber, String email,String address,Double currentBalance) {

        this.customerID = customerID;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.currentBalance = currentBalance;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Double currentBalance) {
        this.currentBalance = currentBalance;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;

        String fullName = customer.getFullName();
        ValidationUtils.rejectIfEmpty(errors, "fullName", "fullName.empty");
        if (fullName.length() < 5) {
            errors.rejectValue("fullName","fullName.length");
        }

        String email = customer.getEmail();
        ValidationUtils.rejectIfEmpty(errors, "email", "email.empty");
        if (!email.matches("(^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$)")) {
            errors.rejectValue("email","email.matches");
        }

        String address = customer.getAddress();
        ValidationUtils.rejectIfEmpty(errors, "address", "address.empty");
        if (address.length() < 5) {
            errors.rejectValue("address","address.length");
        }
    }
}

