package dao;

import java.util.List;

public interface IDao<T> {
    T guardar(T t);
    T buscarPorMatricula(Integer numeroMatricula);
    void eliminar(Integer numeroMatricula);
    void actualizar(T t);
    List<T> listarTodos();

}
