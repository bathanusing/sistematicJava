/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author PERSONAL
 */
public class DAOCustomException extends Exception{

    public DAOCustomException(String message) {
        super(message);
    }

    public DAOCustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOCustomException(Throwable cause) {
        super(cause);
    }
    
}
