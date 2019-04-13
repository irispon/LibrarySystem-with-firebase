package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.x.protobuf.Mysqlx.OkOrBuilder;

import Control.JoinControl;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JoinGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField password;
	private JTextField id;
	private JoinControl joinControl;

	/**
	 * Launch the application.
	 */

	public static void comeJoin() {
		
		try {
			
			JoinGUI dialog = new JoinGUI();
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
	private JoinGUI() {
		joinControl = new JoinControl();
		this.setLocationRelativeTo(null);
		setTitle("\uD68C\uC6D0\uAC00\uC785");
		setBounds(100, 100, 345, 190);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		{
			JLabel lblId = new JLabel("ID");
			contentPanel.add(lblId);
		}
		{
			id = new JTextField();
			contentPanel.add(id);
			id.setColumns(10);
		}
		{
			JLabel lblPassword = new JLabel("\uBE44\uBC00\uBC88\uD638");
			contentPanel.add(lblPassword);
		}
		{
			password = new JTextField();
			contentPanel.add(password);
			password.setColumns(10);
		}
		{
			Box verticalBox = Box.createVerticalBox();
			contentPanel.add(verticalBox);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\uB4F1\uB85D");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						joinControl.join(id.getText(), password.getText());
						id.setText("");
						password.setText("");
						
					}
				});
			}
		}
		
		
		
		
		
	}

}
