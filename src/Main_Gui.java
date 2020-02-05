import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class Main_Gui {

	private JFrame frame;
	static DefaultListModel listModel = new DefaultListModel();	
	private static JList list;
	private static JTextPane txtpnA;
	private static JTextField txtSearch;
	public static String SearchText = "";
	private static JButton btnSearch;
	private static JButton btnOpen;
	public static JLabel lblSearching;
	
	public static void Run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Gui window = new Main_Gui();
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
	public Main_Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 970, 590);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtSearch = new JTextField();
		txtSearch.setToolTipText("Click To Search Through The Computer");
		txtSearch.setHorizontalAlignment(SwingConstants.CENTER);
		txtSearch.setColumns(10);
				
		btnSearch = new JButton("Search");
		
		list = new JList(listModel);
		list.setSelectedIndex(0);
		
		txtpnA = new JTextPane();
		txtpnA.setEditable(false);
		
		JLabel lblFiles = new JLabel("Files");
		lblFiles.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblFiles.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblOverView = new JLabel("Content");
		lblOverView.setHorizontalAlignment(SwingConstants.CENTER);
		lblOverView.setFont(new Font("Tahoma", Font.BOLD, 23));
		
		lblSearching = new JLabel("");
		lblSearching.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearching.setFont(new Font("Tahoma", Font.BOLD, 23));
		
		btnOpen = new JButton("open");
		btnOpen.setEnabled(false);

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblFiles, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
								.addComponent(list, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnOpen)
							.addGap(54)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblOverView, GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
								.addComponent(txtpnA, GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE))
							.addGap(38))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(272)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblSearching, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
								.addComponent(txtSearch, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
							.addGap(12)
							.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
							.addGap(158))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnSearch, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtSearch, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSearching, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addComponent(lblFiles, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblOverView, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(list, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
								.addComponent(txtpnA, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
							.addGap(10))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(82)
							.addComponent(btnOpen, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.add(new JScrollPane(list));

		frame.setTitle("Search Engine");
		
		SearchButtonClicked();
		List_Listener();
		openFile();
	}

	public static void AddToList(String word) 
	{
		listModel.addElement(word);	
	}
	
	public static void UpdateDescription(String description) 
	{
		txtpnA.setText(description);
	}
	
	public static void ClearList_Discription() 
	{
		list.clearSelection();
		listModel.clear();
		txtpnA.setText("");
		btnOpen.setEnabled(false);
	}
	
	private void SearchButtonClicked() 
	{
		btnSearch.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  ClearList_Discription();
			  SearchText = txtSearch.getText();
			  if(SearchText.isEmpty() == false)
			  {
				  Engine.ButtonClicked();
			  }
		  }
		});
	}

	public void List_Listener()
	{
		list.addListSelectionListener(new ListSelectionListener() {

	            @Override
	            public void valueChanged(ListSelectionEvent arg0) {
	                if (!arg0.getValueIsAdjusting() && list.isSelectionEmpty() == false) 
	                {
	                	Engine.UpdateDescription(list.getSelectedIndex());
	            		btnOpen.setEnabled(true);
	                }
	            }
	        });
	}

	public void openFile() 
	{
		btnOpen.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					Engine.OpenFile(list.getSelectedIndex());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	public static void Display_InfoTo_User(String info) 
	{
		lblSearching.setText(info);
	}
	
}
