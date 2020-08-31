package ejercicio41;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main 
{
	private static ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	private static VentanaInicio laVentana;
	public static void main(String[] args) 
	{
		laVentana = new VentanaInicio();	
	}
	public static void cargarEmpleados()
	{
		String error = null;
		empleados.clear();
		int otro = 0;
		int totalHoras;
		try
		{
		while (otro == 0)
		{
			
			Empleado empleado = new Empleado();
			empleado.setNombre(JOptionPane.showInputDialog("Ingrese el nombre del empleado"));
			empleado.setApellido(JOptionPane.showInputDialog("Ingrese el apellido del empleado"));
			totalHoras = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de horas semanales trabajadas por el empleado"));
			empleado.setTotalHoras(totalHoras);
			empleados.add(empleado);
			otro = JOptionPane.showConfirmDialog(null, "¿Desea ingresar otro empleado?");
			
		}
		}
		catch (NumberFormatException error1) 
		{
			error="Debe escribir un numero de horas y Completar todos los campos";
		}
		JOptionPane.showMessageDialog(null, error);
		laVentana.desactivarParaMostrar2();
	}
	public static void cargarDefaultEmpleados()
	{
		empleados.clear();
		Empleado empleado1 = new Empleado();
		empleado1.setNombre("Leonardo");
		empleado1.setApellido("Cristalli");
		empleado1.setTotalHoras(60);
		Empleado empleado2 = new Empleado();
		empleado2.setNombre("Luis");
		empleado2.setApellido("Gonzalez");
		empleado2.setTotalHoras(35);
		Empleado empleado3 = new Empleado();
		empleado3.setNombre("Nicolas");
		empleado3.setApellido("Guzman");
		empleado3.setTotalHoras(40);
		empleados.add(empleado1);
		empleados.add(empleado2);
		empleados.add(empleado3);
	}
	public static ArrayList<Empleado> getEmpleados() 
	{
		return empleados;
	}
}

