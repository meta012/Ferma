import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
public class Swing extends JFrame
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Swing()
    {
        //headers for the table
        String[] columns = new String[] {
            "Nr", "Vardas", "Valandine alga", "Valandu/savaite", "Bonus"
        };
         
        //actual data for the table in a 2d array
        Object[][] data = new Object[][] {
            {1, "Jonas", 10.0, 40.0, false },
            {2, "Arturas", 7.5, 38.0, false },
            {3, "Algis", 5.2,  40.0, true },
        };
         
        final Class[] columnClass = new Class[] {
            Integer.class, String.class, Double.class, Double.class, Boolean.class
        };
        //create table model with data
        DefaultTableModel model = new DefaultTableModel(data, columns) {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
            @Override
            public Class<?> getColumnClass(int columnIndex)
            {
                return columnClass[columnIndex];
            }
        };
         
        JTable table = new JTable(model);
        table.setCellSelectionEnabled(true);
        table.setColumnSelectionAllowed(true);
        table.setRowSelectionAllowed(false);
        table.setEnabled(false);
         
        //add the table to the frame
        getContentPane().add(new JScrollPane(table));
         
        this.setTitle("Table Example");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        this.pack();
        this.setVisible(true);
    }
     
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Swing();
            }
        });
    }   
}