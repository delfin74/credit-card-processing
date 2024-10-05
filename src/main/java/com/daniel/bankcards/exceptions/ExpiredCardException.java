/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daniel.bankcards.exceptions;

/**
 *
 * @author Daniel
 */
public class ExpiredCardException extends Exception{
    public ExpiredCardException(String message) {
        super(message);
    }
}
