package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MainGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public MainGUI() {
		setTitle("\uB3C4\uC11C\uAD00\uB9AC\uC2DC\uC2A4\uD15C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 349);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		this.setLocationRelativeTo(null);
		JButton join = new JButton("\uD68C\uC6D0\uAC00\uC785");
		join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(join);
		
		JButton manager = new JButton("\uD68C\uC6D0 \uAD00\uB9AC");
		manager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(manager);
		
		JButton bookM = new JButton("\uCC45 \uAD00\uB9AC");
		panel.add(bookM);
		
		JButton rental = new JButton("\uB300\uC5EC/\uBC18\uB0A9");
		panel.add(rental);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(MainGUI.class.getResource("/TEST/index.jpg")));
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		
	      join.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	  			JoinGUI.comeJoin();
	  			
	            }
	        });
	      manager.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MemManageGUI.comeManage();
			}
		});

	      bookM.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BookManageGUI.comeBookManage();
			}
		});
		
	      rental.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RentalManagerGUI.comeManage();
			}
		});	
	}

}
