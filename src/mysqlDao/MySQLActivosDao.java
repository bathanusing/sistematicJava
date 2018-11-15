/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqlDao;

import java.sql.Connection;

import dao.ActivosDao;
import dao.DAOCustomException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Activos;
import prueba.FormularioPrueba;

/**
 *
 * @author jsanchez
 */
public class MySQLActivosDao implements ActivosDao {

    final String INSERT = "INSERT INTO Activos(codigo, articulo, numero_ser, marca, fecha, precio_com, precio_act, moneda, peso, ubicacion) VALUES (?,?,?,?,?,?,?,?,?,?)";
    final String UPDATE = "UPDATE Activos SET articulos= ?, numero_ser= ?, marca = ?, fecha = ?, precio_com= ?, precio_act= ?, moneda= ?, peso= ?, ubicacion= ? WHERE codigo = ?";
    final String DELETE = "DELETE from Activos WHERE codigo LIKE ?";
    final String GETONE = "SELECT idproducto,codigo,articulo, numero_ser, marca, fecha, precio_com, precio_act, moneda, peso, ubicacion from Activos WHERE codigo LIKE ?";
    final String GETALL = "SELECT * FROM Activos";
    private Connection conex;

    public MySQLActivosDao(Connection conex) {
        this.conex = conex;
    }

    @Override
    public void insert(Activos object) throws DAOCustomException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        PreparedStatement psmt = null;
        try {
            psmt = conex.prepareStatement(INSERT);
            psmt.setString(1, object.getCodigo());
            psmt.setString(2, object.getArticulo());
            psmt.setString(3, object.getNumeroSer());
            psmt.setString(4, object.getMarca());
            java.sql.Date dateDB = new java.sql.Date(object.getFecha().getTime());
            psmt.setDate(5, dateDB);
            psmt.setDouble(6, object.getPrecioCom());
            psmt.setDouble(7, object.getPrecioAct());
            psmt.setString(8, object.getMoneda());
            psmt.setDouble(9, object.getPeso());
            psmt.setString(10, object.getUbicacion());
            if (psmt.executeUpdate() == 0) {
                throw new DAOCustomException("Tal vez no funciono el insertado de data");
            }
        } catch (SQLException ex) {
            throw new DAOCustomException("Error en SQL", ex);
        } finally {
            if (conex != null) {
                try {
                    conex.close();
                } catch (SQLException ex) {
                    throw new DAOCustomException("Error en SQL", ex);
                }
            }

        }
    }

    @Override
    public boolean delete(Activos object) throws DAOCustomException {
        PreparedStatement pstm = null;
        boolean success = false;
        try {
            pstm = conex.prepareStatement(DELETE);
            pstm.setString(1, object.getCodigo());
            success = true;
            if (pstm.executeUpdate() == 0) {
                throw new DAOCustomException("Puede que no se alla eliminado el registro");
            }
        } catch (SQLException ex) {
            throw new DAOCustomException("Error SQL", ex);
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException ex) {
                    throw new DAOCustomException("Error SQL", ex);
                }
            }
        }
        return success;
    }

    @Override
    public boolean update(Activos object) throws DAOCustomException {
        PreparedStatement pstm = null;
        boolean success = false;
        try {
            pstm = conex.prepareStatement(UPDATE);
            pstm.setString(1, object.getArticulo());
            pstm.setString(2, object.getNumeroSer());
            pstm.setString(3, object.getMarca());
            java.sql.Date dateDB = new java.sql.Date(object.getFecha().getTime());
            pstm.setDate(4, dateDB);
            pstm.setDouble(5, object.getPrecioCom());
            pstm.setDouble(6, object.getPrecioAct());
            pstm.setString(7, object.getMoneda());
            pstm.setDouble(8, object.getPeso());
            pstm.setString(9, object.getUbicacion());
            pstm.setString(10, object.getCodigo());

            if (pstm.executeUpdate() == 0) {
                throw new DAOCustomException("Puede que no se actualizara el registro");
            } else {
                success = true;
            }
        } catch (Exception e) {
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException ex) {
                    throw new DAOCustomException("Error en SQL", ex);
                }
            }
        }
        return success;
    }

    @Override
    public Activos findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(List<Activos> list) throws DAOCustomException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(List<Activos> list) throws DAOCustomException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(List<Activos> list) throws DAOCustomException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Activos findByCode(String object) throws DAOCustomException, SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Activos activos = null;
        try {
            pstm = conex.prepareStatement(GETONE);
            pstm.setString(1, object);
            rs = pstm.executeQuery();
            if (rs.next()) {
                activos = convertir(rs);
            } else {
                activos = null;
            }

        } catch (SQLException ex) {
            throw new DAOCustomException("Error en SQL", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOCustomException("Error en SQL", ex);
                }
            }
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException ex) {
                    throw new DAOCustomException("Error en SQL", ex);
                }
            }
        }
        return activos;
    }

    private Activos convertir(ResultSet rs, String codigo) throws SQLException {
        String articulo = rs.getString("articulo");
        String numeroSer = rs.getString("numero_ser");
        String marca = rs.getString("marca");
        Date fecha = rs.getDate("fecha");
        Double precioCom = rs.getDouble("precio_com");
        Double precioAct = rs.getDouble("precio_act");
        String moneda = rs.getString("moneda");
        Double peso = rs.getDouble("peso");
        String ubicacion = rs.getString("ubicacion");
        Activos act = new Activos(codigo, articulo, numeroSer, marca, fecha, precioCom, precioAct, moneda, peso, ubicacion);
        act.setIdproducto(rs.getInt("idproducto"));
        return act;
    }

    private Activos convertir(ResultSet rs) throws SQLException {
        String codigo = rs.getString("codigo");
        String articulo = rs.getString("articulo");
        String numeroSer = rs.getString("numero_ser");
        String marca = rs.getString("marca");
        Date fecha = rs.getDate("fecha");
        Double precioCom = rs.getDouble("precio_com");
        Double precioAct = rs.getDouble("precio_act");
        String moneda = rs.getString("moneda");
        Double peso = rs.getDouble("peso");
        String ubicacion = rs.getString("ubicacion");
        Activos act = new Activos(codigo, articulo, numeroSer, marca, fecha, precioCom, precioAct, moneda, peso, ubicacion);
        act.setIdproducto(rs.getInt("idproducto"));
        return act;
    }

    @Override
    public List<Activos> findAll() throws DAOCustomException, SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Activos> listaAct = new ArrayList<>();

        try {
            pstm = conex.prepareStatement(GETALL);
            rs = pstm.executeQuery();
            while (rs.next()) {
                listaAct.add(convertir(rs));
            }
        } catch (SQLException ex) {
            throw new DAOCustomException("Error en SQL", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOCustomException("Error SQL", ex);
                }
            }
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException ex) {
                    throw new DAOCustomException("Error SQL", ex);
                }
            }
        }
        return listaAct;
    }

}
