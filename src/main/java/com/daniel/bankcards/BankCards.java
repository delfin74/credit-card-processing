/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.daniel.bankcards;

import com.daniel.bankcards.exceptions.CardsMatchException;
import com.daniel.bankcards.exceptions.ExpiredCardException;
import com.daniel.bankcards.exceptions.InvalidOperationException;
import java.text.DecimalFormat;
import java.time.LocalDate;
/**
 *
 * @author Daniel
 */
public class BankCards {
    public static void main(String[] args) {
        // Crear 3 objetos de tarjetas de crédito
        CreditCard card1 = new CreditCard("VISA", "1234567890123456", "Daniel Carrizo", LocalDate.of(2025, 12, 31));
        CreditCard card2 = new CreditCard("NARA", "6543210987654321", "Elsa Benitez", LocalDate.of(2024, 6, 15));
        CreditCard card3 = new CreditCard("AMEX", "9876543210987654", "Lautaro Flores", LocalDate.of(2023, 9, 30));

        // Mostrar la información de la tarjeta
        card1.showCardInfo();
        card2.showCardInfo();
        card3.showCardInfo();
        
        // Validar si la tarjeta es válida para operar
        try {
            card3.isValid();
            System.out.println("Card3 is valid for operation.");
        } catch (ExpiredCardException e) {
            System.out.println(e.getMessage());
        }

        // Validar si una operación es válida
        double amount = 1950;
        try {
            card1.isOperationValid(amount);
            System.out.println("Operation is valid.");
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }

        // Verificar si las tarjetas son distintas
        try {
            card1.isDifferent(card2);
            System.out.println("Card1 is different from card2.");
        } catch (CardsMatchException e) {
            System.out.println(e.getMessage());
        }

        // Obtener la tasa de una operación
        try {
            double serviceRate = card1.getServiceRate(amount);
            DecimalFormat df = new DecimalFormat("#.00");
            System.out.println("Service rate for card1: " + df.format(serviceRate));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
