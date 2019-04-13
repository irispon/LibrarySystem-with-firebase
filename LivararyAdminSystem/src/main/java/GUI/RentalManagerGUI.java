package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Control.RentalManagerControl;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;

public class RentalManagerGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField idBox;
	private JTextField barcodeBox;
	private RentalManagerControl rentalControl;
	private JTable retalList;
	/**
	 * Launch the application.
	 */
	public static void comeManage() {
		
		try {
			RentalManagerGUI dialog = new RentalManagerGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	private RentalManagerGUI() {
		
		retalList = new JTable();
		rentalControl = new RentalManagerControl(retalList);
		this.setLocationRelativeTo(null);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblId = new JLabel("ID");
				panel.add(lblId);
			}
			{
				idBox = new JTextField();
				panel.add(idBox);
				idBox.setColumns(10);
			}
			{
				JButton check = new JButton("\uD655\uC778");
				panel.add(check);
				check.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						rentalControl.settingList(idBox.getText());  
					}
				});
				check.setActionCommand("OK");
				getRootPane().setDefaultButton(check);
			}
		}
		{
			
	
			retalList.setFillsViewportHeight(true); 
			JScrollPane scrollPane = new JScrollPane (retalList);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			contentPanel.add ( scrollPane , BorderLayout.CENTER ) ; 
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				barcodeBox = new JTextField();
				barcodeBox.setColumns(10);
				buttonPane.add(barcodeBox);
			}
			{
				JButton rental = new JButton("\uB300\uC5EC");
			
				buttonPane.add(rental);
				rental.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						rentalControl.RentalBook(barcodeBox.getText(),idBox.getText());
						
					}
				});
			}
			{
				JButton delete = new JButton("\uBC18\uB0A9");
				delete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int result= JOptionPane.showConfirmDialog(null, "반납 처리 하시겠습니까?", 

								"종료", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

								 
									System.out.println(result);
								  if(result == 0){
									  int low = retalList.getSelectedRow();
									
									  rentalControl.Delete(idBox.getText(),low);
								  }
					}
				});
				buttonPane.add(delete);
			}
		}
	}

}
