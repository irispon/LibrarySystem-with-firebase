package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Control.MemManageContol;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class MemManageGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable member;
	private MemManageContol memberConrol;
	public static void comeManage() {
		
		try {
			MemManageGUI dialog = new MemManageGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private MemManageGUI() {
		member = new JTable();
		memberConrol = new MemManageContol(member);

		this.setLocationRelativeTo(null);
		setTitle("\uD68C\uC6D0 \uAD00\uB9AC");
		setBounds(100, 100, 535, 488);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			member.setFillsViewportHeight(true); 
			JScrollPane scrollPane = new JScrollPane (member);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			contentPanel.add ( scrollPane , BorderLayout.CENTER ) ; 
			memberConrol.settingData();
			
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton update = new JButton("\uC0C8\uB85C\uACE0\uCE68");
				update.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						memberConrol.settingData();
						
					}
				});
				buttonPane.add(update);
			}
			{
				JButton changepassword = new JButton("\uBE44\uBC00\uBC88\uD638\uBCC0\uACBD");
				buttonPane.add(changepassword);
				changepassword.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						  int low = member.getSelectedRow();
						  memberConrol.change(low);
						  System.out.println("테스트"+low);
						
					}
				});
			}
			{
				JButton addMember = new JButton("\uD68C\uC6D0 \uB4F1\uB85D");
				buttonPane.add(addMember);
				addMember.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JoinGUI.comeJoin();
						
					}
				});
			}
			{
				JButton delete = new JButton("\uD68C\uC6D0 \uC0AD\uC81C");
				delete.setActionCommand("OK");
				buttonPane.add(delete);
				getRootPane().setDefaultButton(delete);
				delete.addActionListener(new ActionListener() {
	
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						int result= JOptionPane.showConfirmDialog(null, "회원삭제 하시겠습니까??", 

								"종료", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

								 
									System.out.println(result);
								  if(result == 0){
									  int low = member.getSelectedRow();
									  memberConrol.delete(low);
										

								}
								

						

					}
				});
			}
		}
	}


	
}
