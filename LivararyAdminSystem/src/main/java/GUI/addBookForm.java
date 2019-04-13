package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import Control.BookEntity;
import Control.AddBook;

import javax.swing.JLabel;
import javax.swing.SpringLayout;

public class addBookForm extends JDialog {
	private JTextField price;
	private JTextField barcord;
	private JTextField author;
	private JTextField bookName;
	private JTextField publisher;
	private AddBook addBook;

	/**
	 * Launch the application.
	 */
	public static void comeaddBookForm() {
		
		try {
			addBookForm dialog = new addBookForm();
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
	public addBookForm() {
		setBounds(100, 100, 410, 372);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton add = new JButton("\uB4F1\uB85D");
				add.setActionCommand("OK");
				add.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						BookEntity book = new BookEntity();
						book.setData(price.getText(), author.getText(), bookName.getText(), publisher.getText(), barcord.getText());
						addBook = new AddBook();
						addBook.setData(book);
						BookManageGUI.comeBookManage();
						dispose();
					}
				});
				buttonPane.add(add);
				getRootPane().setDefaultButton(add);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			SpringLayout sl_panel = new SpringLayout();
			panel.setLayout(sl_panel);
			
			JLabel priceLabel = new JLabel("\uAC00\uACA9");
			sl_panel.putConstraint(SpringLayout.SOUTH, priceLabel, -226, SpringLayout.SOUTH, panel);
			panel.add(priceLabel);
			
			price = new JTextField();
			sl_panel.putConstraint(SpringLayout.WEST, priceLabel, -59, SpringLayout.WEST, price);
			sl_panel.putConstraint(SpringLayout.EAST, priceLabel, -6, SpringLayout.WEST, price);
			sl_panel.putConstraint(SpringLayout.NORTH, price, 56, SpringLayout.NORTH, panel);
			sl_panel.putConstraint(SpringLayout.WEST, price, 134, SpringLayout.WEST, panel);
			panel.add(price);
			price.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("\uBC14\uCF54\uB4DC(\uD544\uC218)");
			sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 11, SpringLayout.SOUTH, priceLabel);
			sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, -17, SpringLayout.WEST, priceLabel);
			sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, -200, SpringLayout.SOUTH, panel);
			sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, priceLabel);
			panel.add(lblNewLabel);
			
			barcord = new JTextField();
			sl_panel.putConstraint(SpringLayout.NORTH, barcord, 6, SpringLayout.SOUTH, price);
			sl_panel.putConstraint(SpringLayout.WEST, barcord, 0, SpringLayout.WEST, price);
			panel.add(barcord);
			barcord.setColumns(10);
			
			JLabel aa = new JLabel("\uC800\uC790");
			sl_panel.putConstraint(SpringLayout.WEST, aa, 0, SpringLayout.WEST, priceLabel);
			panel.add(aa);
			
			author = new JTextField();
			sl_panel.putConstraint(SpringLayout.NORTH, aa, 3, SpringLayout.NORTH, author);
			sl_panel.putConstraint(SpringLayout.NORTH, author, 6, SpringLayout.SOUTH, barcord);
			sl_panel.putConstraint(SpringLayout.WEST, author, 0, SpringLayout.WEST, price);
			panel.add(author);
			author.setColumns(10);
			
			JLabel booknamel = new JLabel("\uCC45\uC774\uB984");
			sl_panel.putConstraint(SpringLayout.WEST, booknamel, 0, SpringLayout.WEST, priceLabel);
			panel.add(booknamel);
			
			bookName = new JTextField();
			sl_panel.putConstraint(SpringLayout.NORTH, booknamel, 3, SpringLayout.NORTH, bookName);
			sl_panel.putConstraint(SpringLayout.NORTH, bookName, 6, SpringLayout.SOUTH, author);
			sl_panel.putConstraint(SpringLayout.WEST, bookName, 0, SpringLayout.WEST, price);
			panel.add(bookName);
			bookName.setColumns(10);
			
			JLabel publ = new JLabel("\uCD9C\uD310\uC0AC");
			sl_panel.putConstraint(SpringLayout.WEST, publ, 0, SpringLayout.WEST, priceLabel);
			panel.add(publ);
			
			publisher = new JTextField();
			sl_panel.putConstraint(SpringLayout.NORTH, publ, 3, SpringLayout.NORTH, publisher);
			sl_panel.putConstraint(SpringLayout.NORTH, publisher, 6, SpringLayout.SOUTH, bookName);
			sl_panel.putConstraint(SpringLayout.EAST, publisher, 0, SpringLayout.EAST, price);
			panel.add(publisher);
			publisher.setColumns(10);
		}
	}
}
