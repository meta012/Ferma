import java.awt.EventQueue;

import farmer.calculators.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.TextField;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Checkbox;
import javax.swing.JCheckBox;

public class FarmCalculatorTable {

	private JFrame frame;
	private JTable table;
	private JTextField vardas;
	private JTextField valSavaite;
	private JTextField valAlga;
	private Label label_1;
	private Label label_2;
	private Label label_4;
	private Label label_3;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FarmCalculatorTable window = new FarmCalculatorTable();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FarmCalculatorTable() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 814, 406);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(243, 72, 533, 269);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Vardas", "ID", "Val/sav darbo", "Val. alga", "Bruto alga", "Neto alga"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Long.class, Double.class, Double.class, Object.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		vardas = new JTextField();
		vardas.setBounds(125, 76, 96, 19);
		frame.getContentPane().add(vardas);
		vardas.setColumns(10);
		
		valSavaite = new JTextField();
		valSavaite.setBounds(125, 128, 96, 19);
		frame.getContentPane().add(valSavaite);
		valSavaite.setColumns(10);
		
		valAlga = new JTextField();
		valAlga.setBounds(125, 159, 96, 19);
		frame.getContentPane().add(valAlga);
		valAlga.setColumns(10);
		
		Label label = new Label("Vardas");
		label.setFont(new Font("Dialog", Font.PLAIN, 12));
		label.setBounds(12, 74, 107, 21);
		frame.getContentPane().add(label);
		
		label_1 = new Label("Val. per savait\u0119");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_1.setBounds(12, 126, 107, 21);
		frame.getContentPane().add(label_1);
		
		label_2 = new Label("Valandin\u0117 alga");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_2.setBounds(12, 157, 107, 21);
		frame.getContentPane().add(label_2);
		
		label_4 = new Label("Fermerio algos skai\u010Diuokl\u0117");
		label_4.setFont(new Font("Dialog", Font.BOLD, 16));
		label_4.setAlignment(Label.CENTER);
		label_4.setBounds(10, 23, 780, 21);
		frame.getContentPane().add(label_4);
		
		JButton btnSkaiiuoti = new JButton("Skai\u010Diuoti");
		btnSkaiiuoti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.addRow(new Object [] {
						vardas.getText(),
						Long.parseLong(id.getText()),
						Integer.parseInt(valSavaite.getText()),
						Integer.parseInt(valAlga.getText()),
						(new FarmerTaxCalculator(vardas.getText(), Long.parseLong(id.getText()), Integer.parseInt(valSavaite.getText()), Integer.parseInt(valAlga.getText()))).getGrossPay(),
						(new FarmerTaxCalculator(vardas.getText(), Long.parseLong(id.getText()), Integer.parseInt(valSavaite.getText()), Integer.parseInt(valAlga.getText()))).getNetPay()} );
			}
		});
		btnSkaiiuoti.setBounds(125, 199, 96, 21);
		frame.getContentPane().add(btnSkaiiuoti);
		
		label_3 = new Label("ID");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_3.setBounds(12, 99, 107, 21);
		frame.getContentPane().add(label_3);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(125, 99, 96, 19);
		frame.getContentPane().add(id);
		
		
		
		
	}
}
