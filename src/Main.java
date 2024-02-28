import dao.BD;
import implementacion.OdontologoDao;
import model.Odontologo;
import service.OdontologoService;

public class Main {
    public static void main(String[] args) {
        BD.crearTablas();

        Odontologo odontologo = new Odontologo(123, "Carlos", "Luján");
        Odontologo odontologo2 = new Odontologo(125, "Juan", "Luján");



        //creo una instancia de la clase para usar sus métodos
        OdontologoService odontologoService = new OdontologoService();

        odontologoService.guardar(odontologo2);
        odontologoService.guardar(odontologo);


        odontologoService.listarTodos();
    }
}
