package ejercicio41;

import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VentanaInicio extends JFrame 
{
	private Label lChoose, lNombre, lApellido, lTextEmpl, lTextCantHsTrab, lCantHsTrab, lTextCantHsSimples, lCantHsSimples, lTextCantHsExtras, lCantHsExtras, lTextSueldBas, lSueldBas, lTextDesc, lDesc, lTextPremio, lPremio, lTextCobrar, lCobrar;
	private JButton btnCargarEmp, btnCargarDefaultEmp, btnMostrarJornal;
	public VentanaInicio (ArrayList<Empleado> empleados)
	{
		super ("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
	    lChoose = new Label();
		lChoose.setText("Elegir opci�n          ");
		btnCargarEmp = new JButton( "Cargar Empleados" );
		btnCargarDefaultEmp = new JButton( "Cargar Empleados predefinidos de prueba" );
		btnMostrarJornal = new JButton( "Mostrar Jornal de todos los empleados" );
		add(lChoose);
		add(btnCargarEmp);
		add(btnCargarDefaultEmp);
		add(btnMostrarJornal);
		setSize(500, 300);
		setVisible(true);
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
		btnMostrarJornal.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent accionMostrarJornal) 
			{
				mostrarJornal(empleados);
			}
		});
	}
	public void desactivaParaMostrar()
	{
		lChoose.setVisible(false);
		btnCargarDefaultEmp.setVisible(false);
		btnCargarEmp.setVisible(false);
		btnMostrarJornal.setVisible(false);
	}
	public void inicializarParaMostrar()
	{
		JPanel panelEmpleado = new JPanel();
		lTextEmpl = new Label("EMPLEADO: ");
		lNombre = new Label();
		lApellido = new Label();
		panelEmpleado.add(lTextEmpl);
		panelEmpleado.add(lNombre);
		panelEmpleado.add(lApellido);
		JPanel panelCantHsTrab = new JPanel();
		lTextCantHsTrab = new Label("CANTIDAD HORAS TRABAJADAS: ");
		lCantHsTrab = new Label();
		panelCantHsTrab.add(lTextCantHsTrab);
		panelCantHsTrab.add(lCantHsTrab);
		JPanel panelCantHsSimples = new JPanel();
		lTextCantHsSimples = new Label("CANTIDAD HORAS SIMPLES: ");
		lCantHsSimples = new Label();
		panelCantHsSimples.add(lTextCantHsSimples);
		panelCantHsSimples.add(lCantHsSimples);
		JPanel panelCantHsExtras = new JPanel();
		lTextCantHsExtras = new Label("CANTIDAD HORAS EXCEDENTES: ");
		lCantHsExtras = new Label();
		panelCantHsExtras.add(lTextCantHsExtras);
		panelCantHsExtras.add(lCantHsExtras);
		JPanel panelSueldBas = new JPanel();
		lTextSueldBas = new Label("SUELDO BÁSICO: ");
		lSueldBas = new Label();
		panelSueldBas.add(lTextSueldBas);
		panelSueldBas.add(lSueldBas);
		JPanel panelDesc = new JPanel();
		lTextDesc = new Label("DESCUENTOS: ");
		lDesc = new Label();
		panelDesc.add(lTextDesc);
		panelDesc.add(lDesc);
		JPanel panelPremio = new JPanel();
		lTextPremio = new Label("PREMIO: ");
		lPremio = new Label();
		panelPremio.add(lTextPremio);
		panelPremio.add(lPremio);
		JPanel panelCobrar = new JPanel();
		lTextCobrar = new Label ("A COBRAR: ");
		lCobrar = new Label();
		panelCobrar.add(lTextCobrar);
		panelCobrar.add(lCobrar);
		lTextEmpl.setVisible(true);
		lTextCantHsTrab.setVisible(true);
		lTextCantHsSimples.setVisible(true);
		lTextCantHsExtras.setVisible(true);
		lTextSueldBas.setVisible(true);
		lTextDesc.setVisible(true);
		lTextPremio.setVisible(true);
		lTextCobrar.setVisible(true);
		
	}
	public void mostrarJornal(ArrayList<Empleado> empleados)
	{
		desactivaParaMostrar();
		inicializarParaMostrar();
		int otro = JOptionPane.OK_OPTION;
		int i = 0;
		while ((otro == JOptionPane.OK_OPTION) && (i < empleados.size()))
			{
				Empleado empleado = empleados.get(i);
				lNombre.setText(empleado.getNombre()); 
				lApellido.setText(empleado.getApellido());
				lCantHsTrab.setText(String.valueOf(empleado.getTotalHoras()));
				
			}
	}
}
