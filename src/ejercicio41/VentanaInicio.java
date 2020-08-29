package ejercicio41;

import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class VentanaInicio extends JFrame implements ActionListener
{
	public VentanaInicio ()
	{
		super ("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		Label lChoose = new Label();
		lChoose.setText("Elegir opción          ");
		JButton btnCargarEmp = new JButton( "Cargar Empleados" );
		JButton btnCargarDefaultEmp = new JButton( "Cargar Empleados predefinidos de prueba" );
		JButton btnMostrarJornal = new JButton( "Mostrar Jornal de todos los empleados" );
		add(lChoose);
		add(btnCargarEmp);
		add(btnCargarDefaultEmp);
		add(btnMostrarJornal);
		btnCargarEmp.addActionListener(new ActionListener() 
			{
			public void actionPerformed(ActionEvent accionCargarEmp) 
				{
					Main.cargarEmpleados();
				}
			});
		btnCargarDefaultEmp.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent accionCargarDefaultEmp) 
			{
				Main.cargarDefaultEmpleados();
			}
		});
		
		
	}
}
