package com.example.userservice.application.ports;


//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;

import java.math.BigDecimal;

public class WalletDTO {

    // @NotBlank(message = "Wallet ID is required")
    private String id;

    //@NotNull(message = "Balance is required")
    //@Min(value = 0, message = "Balance must be zero or positive")
    private BigDecimal balance;

    // @NotBlank(message = "Currency is required")
    private String currency;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
