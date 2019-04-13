package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.BookManageControl;
import Control.MemManageContol;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;

public class BookManageGUI extends JDialog {

	/**
	 * Launch the application.
	 */
	JTable booList;
	BookManageControl listControl;
	private final JPanel contentPanel = new JPanel();
	public static void comeBookManage() {
		
		try {
			BookManageGUI dialog = new BookManageGUI();
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
	private BookManageGUI() {
		booList = new JTable();
		BookManageControl listControl= new BookManageControl(booList);

		this.setLocationRelativeTo(null);
		setTitle("\uCC45 \uAD00\uB9AC");
		setBounds(100, 100, 535, 442);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			booList.setFillsViewportHeight(true); 
			JScrollPane scrollPane = new JScrollPane (booList);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			contentPanel.add ( scrollPane , BorderLayout.CENTER ) ; 
			listControl.settingList();
			
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton update = new JButton("\uC0C8\uB85C\uACE0\uCE68");
				update.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						listControl.settingList();
						
					}
				});
				buttonPane.add(update);
			}
			{
				JButton addBook = new JButton("\uCC45 \uB4F1\uB85D");
				buttonPane.add(addBook);
				addBook.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						addBookForm.comeaddBookForm();
						dispose();
						
					}
				});
			}
			{
				JButton delete = new JButton("\uCC45 \uC0AD\uC81C");
				delete.setActionCommand("OK");
				buttonPane.add(delete);
				getRootPane().setDefaultButton(delete);
				delete.addActionListener(new ActionListener() {
	
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						int result= JOptionPane.showConfirmDialog(null, "책을 지우겠습니까??", 

								"종료", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

								 
									System.out.println(result);
								  if(result == 0){
									  int low = booList.getSelectedRow();
									  listControl.delete(low);
										

								}
								

						

					}
				});
			}
		}
		
		
	}

}
