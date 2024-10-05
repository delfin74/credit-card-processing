/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daniel.bankcards;

import com.daniel.bankcards.exceptions.CardsMatchException;
import com.daniel.bankcards.exceptions.ExpiredCardException;
import com.daniel.bankcards.exceptions.InvalidOperationException;
import java.time.LocalDate;
/**
 *
 * @author Daniel
 */

public class CreditCard {
    private String brand;
    private String cardNumber;
    private String cardHolder;
    private LocalDate expirationDate;

    // Constructor
    public CreditCard(String brand, String cardNumber, String cardHolder, LocalDate expirationDate) {
        this.brand = brand;
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expirationDate = expirationDate;
    }

    // Método para mostrar la información completa de la tarjeta
    public void showCardInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Cardholder: " + cardHolder);
        System.out.println("Expiration Date: " + expirationDate);
    }

    // Método para validar si la tarjeta es válida para operar
    public void isValid() throws ExpiredCardException {
        if (expirationDate.isBefore(LocalDate.now())) {
            throw new ExpiredCardException("The card has expired.");
        }
    }

    // Método para validar si una operación es válida
    public void isOperationValid(double amount) throws InvalidOperationException {
        if (amount >= 1000) {
            throw new InvalidOperationException("Operation exceeds the allowed limit of 1000 pesos.");
        }
    }

    // Método para verificar si esta tarjeta es distinta a otra
    public void isDifferent(CreditCard otherCard) throws CardsMatchException {
        if (this.cardNumber.equals(otherCard.cardNumber)) {
            throw new CardsMatchException("Both cards are the same.");
        }
    }

    // Método para calcular la tasa de servicio
    public double getServiceRate(double amount) throws Exception {
        double rate = 0;

        switch (brand.toUpperCase()) {
            case "VISA":
                rate = (double) (expirationDate.getYear() % 100) / expirationDate.getMonthValue();
                break;
            case "NARA":
                rate = expirationDate.getDayOfMonth() * 0.5;
                break;
            case "AMEX":
                rate = expirationDate.getMonthValue() * 0.1;
                break;
            default:
                throw new Exception("Unknown brand: " + brand);
        }

        return amount * (rate / 100);  // Devuelve el importe calculado con la tasa
    }
}

