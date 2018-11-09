/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jsanchez
 */
public interface ModelDaoInterface<T,K> {
    
    public void insert(T object) throws DAOCustomException;
    
    public boolean delete(T object) throws DAOCustomException;
    
    public boolean update(T object) throws DAOCustomException;
    
    public T findById(K id);
    
    public List<T> findAll() throws DAOCustomException, SQLException;
    
    public boolean insert(List<T> list) throws DAOCustomException;
    
    public boolean update(List<T> list) throws DAOCustomException;
    
    public boolean delete(List<T> list) throws DAOCustomException;
    
    
    
}
