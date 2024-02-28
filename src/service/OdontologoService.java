package service;

import dao.IDao;
import implementacion.OdontologoDao;
import implementacion.OdontologoDaoH2;
import model.Odontologo;

import java.util.List;

public class OdontologoService {
    private IDao<Odontologo> iDao;

    public OdontologoService() {this.iDao = new OdontologoDaoH2(); }

    public Odontologo guardar (Odontologo odontologo) { return iDao.guardar(odontologo); }

    public List<Odontologo> listarTodos() {
        return iDao.listarTodos();
    }

}
