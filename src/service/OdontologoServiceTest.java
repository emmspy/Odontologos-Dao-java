package service;

import implementacion.OdontologoDaoH2;
import model.Odontologo;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.ArrayList;

public class OdontologoDAOTest {

    @Test
    public void testListarOdontologos() {
        OdontologoDaoH2 odontologoDAO = new OdontologoDaoH2();

        Odontologo odontologo1 = new Odontologo(1, "Nombre1", "Apellido1");
        Odontologo odontologo2 = new Odontologo(2, "Nombre 2", "Apellido2");


        Odontologo.guardar(odontologo1);
        Odontologo.guardar(odontologo2);

        // Obtener la lista de odontólogos
        List<Odontologo> resultado = odontologoDAO.listarOdontologos();

        // Verificar que el resultado contiene los odontólogos esperados
        assertEquals(2, resultado.size());
        assertEquals(odontologo1, resultado.get(0));