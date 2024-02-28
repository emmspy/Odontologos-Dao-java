package implementacion;

import dao.IDao;
import model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDao implements IDao<Odontologo> {
    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoH2.class);
    private List<Odontologo> odontologoList = new ArrayList<>();


    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologoList.add(odontologo);
        LOGGER.info("Vamos a guardar un odontologo en memoria: ");
        return odontologo;

    }

    @Override
    public List<Odontologo> listarTodos() {
        LOGGER.info("Nuestra lista de odontologos: ");
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
