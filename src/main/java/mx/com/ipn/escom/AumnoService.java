package mx.com.ipn.escom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/alumnos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AumnoService 
{
	private static Map<Integer, Alumno> alumnos= new HashMap<>();
	static 
	{
		Alumno antonio=new Alumno(123454323, "Antonio", "Ortega", "sistemas", "jortega@gmail.com");
		Alumno karla=new Alumno(123454323, "Karla", "Ortega", "sistemas", "kortega@gmail.com");
		
		alumnos.put(1, antonio);
		alumnos.put(2, karla);
	}
	
	/**
	 * Este metodo nos regresara la lista de todos los clientes
	 * existentes en la base de datos
	 */
	
	@GET
	public List<Alumno> getAlumnos()
	{
		return new ArrayList<Alumno>(alumnos.values());
	}
	
	/**
	 * Este metodo guarda al alumno
	 * ingresando los datos
	 */
	@POST
	public void addAlumno(Alumno alumno) 
	{
		alumnos.put(alumnos.size() + 1, alumno);
	}
	
	@DELETE
	@Path("/{alumnoId}")
	public void deleteAlumno(@PathParam("alumnoId") int id) 
	{
		alumnos.remove(id);
	}
}
