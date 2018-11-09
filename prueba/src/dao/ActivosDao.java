/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import model.Activos;

/**
 *
 * @author jsanchez
 */
public interface ActivosDao extends ModelDaoInterface<Activos,Long>{
    
    public Activos findByCode(String object)throws DAOCustomException, SQLException;
    
    
}
