package ejercicio41;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VentanaInicio extends JFrame implements ActionListener
{
	
	private Label lNombre, lApellido, lTextEmpl, lTextCantHsTrab, lCantHsTrab, lTextCantHsSimples, lCantHsSimples, lTextCantHsExtras, lCantHsExtras, lTextSueldBas, lSueldBas, lTextDesc, lDesc, lTextPremio, lPremio, lTextCobrar, lCobrar;
	private JButton btnCargarEmp, btnCargarDefaultEmp, btnMostrarJornal, btnOtroEmpleado, btnSalir;
	private JPanel panelEmpleado, panelCantHsTrab, panelCantHsSimples, panelCantHsExtras, panelSueldBas, panelDesc, panelPremio, panelCobrar;
	int index;
	public VentanaInicio ()
	{
		super ("Elegir Opcion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		btnCargarEmp = new JButton( "Cargar Empleados" );
		btnCargarEmp.addActionListener(this);
		btnCargarDefaultEmp = new JButton( "Cargar Empleados predefinidos de prueba" );
		btnCargarDefaultEmp.addActionListener(this);
		btnMostrarJornal = new JButton( "Mostrar Jornal de todos los empleados" );
		btnMostrarJornal.addActionListener(this);
		btnOtroEmpleado = new JButton("Siguiente Empleado");
		btnOtroEmpleado.addActionListener(this);
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		add(btnCargarEmp);
		add(btnCargarDefaultEmp);
		add(btnMostrarJornal);
		add(btnOtroEmpleado);
		add(btnSalir);
		
		btnOtroEmpleado.setVisible(false);
		inicializarParaMostrar();
		desactivarPanels();
		setSize(800, 500);
		setVisible(true);
		
	}
	public void desactivarParaMostrar1()
	{
		btnCargarDefaultEmp.setVisible(false);
		btnCargarEmp.setVisible(false);
		btnMostrarJornal.setVisible(false);
	}
	public void desactivarParaMostrar2()
	{
		btnCargarDefaultEmp.setVisible(false);
		btnCargarEmp.setVisible(false);
		btnMostrarJornal.setVisible(true);
	}
	public void inicializarParaMostrar()
	{
		panelEmpleado = new JPanel();
		lTextEmpl = new Label("EMPLEADO: ");
		lNombre = new Label();
		lApellido = new Label();
		panelEmpleado.add(lTextEmpl);
		panelEmpleado.add(lNombre);
		panelEmpleado.add(lApellido);
		panelCantHsTrab = new JPanel();
		lTextCantHsTrab = new Label("CANTIDAD HORAS TRABAJADAS: ");
		lCantHsTrab = new Label();
		panelCantHsTrab.add(lTextCantHsTrab);
		panelCantHsTrab.add(lCantHsTrab);
		panelCantHsSimples = new JPanel();
		lTextCantHsSimples = new Label("CANTIDAD HORAS SIMPLES: ");
		lCantHsSimples = new Label();
		panelCantHsSimples.add(lTextCantHsSimples);
		panelCantHsSimples.add(lCantHsSimples);
		panelCantHsExtras = new JPanel();
		lTextCantHsExtras = new Label("CANTIDAD HORAS EXCEDENTES: ");
		lCantHsExtras = new Label();
		panelCantHsExtras.add(lTextCantHsExtras);
		panelCantHsExtras.add(lCantHsExtras);
		panelSueldBas = new JPanel();
		lTextSueldBas = new Label("SUELDO BASICO: ");
		lSueldBas = new Label();
		panelSueldBas.add(lTextSueldBas);
		panelSueldBas.add(lSueldBas);
		panelDesc = new JPanel();
		lTextDesc = new Label("DESCUENTOS: ");
		lDesc = new Label();
		panelDesc.add(lTextDesc);
		panelDesc.add(lDesc);
		panelPremio = new JPanel();
		lTextPremio = new Label("PREMIO: ");
		lPremio = new Label();
		panelPremio.add(lTextPremio);
		panelPremio.add(lPremio);
		panelCobrar = new JPanel();
		lTextCobrar = new Label ("A COBRAR: ");
		lCobrar = new Label();
		panelCobrar.add(lTextCobrar);
		panelCobrar.add(lCobrar);
		
		Container grillaContenedoraPaneles = getContentPane();
		grillaContenedoraPaneles.setLayout(new GridLayout(5, 5));
		grillaContenedoraPaneles.add(panelEmpleado);
		grillaContenedoraPaneles.add(panelCantHsTrab);
		grillaContenedoraPaneles.add(panelCantHsSimples);
		grillaContenedoraPaneles.add(panelCantHsExtras);
		grillaContenedoraPaneles.add(panelSueldBas);
		grillaContenedoraPaneles.add(panelDesc);
		grillaContenedoraPaneles.add(panelPremio);
		grillaContenedoraPaneles.add(panelCobrar);
		
	}
	public void activarParaMostrar()
	{
		
		panelEmpleado.setVisible(true);
		panelCantHsTrab.setVisible(true);
		panelCantHsSimples.setVisible(true);
		panelCantHsExtras.setVisible(true);
		panelSueldBas.setVisible(true);
		panelDesc.setVisible(true);
		panelPremio.setVisible(true);
		panelCobrar.setVisible(true);
		btnOtroEmpleado.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == btnCargarEmp)
		{
			Main.cargarEmpleados();
		}
		if (e.getSource() == btnCargarDefaultEmp)
		{
			Main.cargarDefaultEmpleados();
		}
		if (e.getSource() == btnMostrarJornal)
		{
			desactivarParaMostrar1();
			index = 0;
			activarParaMostrar();
			mostrarEmpleado(index);
		}
		if (e.getSource() == btnOtroEmpleado)
		{
			index++;
			mostrarEmpleado(index);
		}
		if (e.getSource() == btnSalir)
		{
			System.exit(0);
		}
	}
	public void mostrarEmpleado(int index)
	{
		float valorHora = 25f;
		float valorExtras = 30f;
		float porcDesc = 0.195f;
		float valorBono = 100f;
		float horasExtras;
		float horasSimples;
		float bono;
		float total;
		ArrayList<Empleado> empleados = Main.getEmpleados();
		if (index >= Main.getEmpleados().size())
		{
			JOptionPane.showMessageDialog(null, "No hay mas empleados que mostrar");
			retorno();
		}
		else
		{
		Empleado empleado = empleados.get(index);
		lNombre.setText(empleado.getNombre()); 
		lApellido.setText(empleado.getApellido());
		float totalHoras = empleado.getTotalHoras();
		lCantHsTrab.setText(String.valueOf(totalHoras));
		if (totalHoras >= 40f)
		{
			horasExtras = totalHoras - 40f;
			horasSimples = 40f;
			bono = valorBono;
		}
		else
		{
			horasExtras = 0f;
			horasSimples = totalHoras;
			bono = 0f;
		}
		lCantHsExtras.setText(String.valueOf(horasExtras));
		lCantHsSimples.setText(String.valueOf(horasSimples));
		float basico = horasSimples * valorHora;
		lSueldBas.setText(String.valueOf(basico));
		float descuento = basico * porcDesc;
		lDesc.setText(String.valueOf(descuento));
		lPremio.setText(String.valueOf(bono));
		total = basico - descuento + bono + horasExtras * valorExtras;
		lCobrar.setText(String.valueOf(total));
		}
		
	}
	public void desactivarPanels()
	{

		panelEmpleado.setVisible(false);
		panelCantHsTrab.setVisible(false);
		panelCantHsSimples.setVisible(false);
		panelCantHsExtras.setVisible(false);
		panelSueldBas.setVisible(false);
		panelDesc.setVisible(false);
		panelPremio.setVisible(false);
		panelCobrar.setVisible(false);
		
	}
	public void retorno()
	{
		desactivarPanels();
		btnCargarEmp.setVisible(true);
		btnCargarDefaultEmp.setVisible(true);
		btnMostrarJornal.setVisible(true);
		btnOtroEmpleado.setVisible(false);
	}

}


