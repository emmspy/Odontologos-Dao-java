package implementacion;

import dao.BD;
import dao.IDao;
import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoH2.class);
    private static final String INSERT_ODONTOLOGO = "INSERT INTO ODONTOLOGOS (NOMBRE, APELLIDO) VALUES (?,?)";
    private static final String SELECT_ALL = "SELECT * FROM ODONTOLOGOS";

    public OdontologoDaoH2() {
        super();
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        LOGGER.info("Vamos a guardar un odontologo");
        Connection connection = null;


        try {

            connection = BD.getConnection();
            PreparedStatement psInsert = connection.prepareStatement(INSERT_ODONTOLOGO, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, odontologo.getNombre());
            psInsert.setString(2, odontologo.getApellido());

            psInsert.execute();

            ResultSet resultSet = psInsert.getGeneratedKeys();
            while (resultSet.next()) {
                odontologo.setNumeroMatricula(resultSet.getInt(1));

            }

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        LOGGER.info("Se ha gurdado el odontologo : " + odontologo.getNombre());
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        LOGGER.info("Estos son todos nuestros odontologos: ");
        Connection connection = null;
        List<Odontologo> odontologoList = new ArrayList<>();
        Odontologo odontologo = null;

        try {
            connection = BD.getConnection();
            PreparedStatement psSelect = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = psSelect.executeQuery();

            while (rs.next()) {
                odontologo = new Odontologo(rs.getInt(1), rs.getString(2), rs.getString(3));

                odontologoList.add(odontologo);
            }

        } catch (Exception e) {
            LOGGER.error("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        LOGGER.info("Esta es la lista de odontologos " + odontologoList);
        return odontologoList;
    }

    @Override
    public Odontologo buscarPorMatricula(Integer numeroMatricula) {
        return null;
    }

    @Override
    public void eliminar(Integer numeroMatricula) {

    }

    @Override
    public void actualizar(Odontologo odontologo) {

    }

}
