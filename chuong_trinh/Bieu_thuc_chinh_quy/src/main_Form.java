import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class main_Form {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_Form window = new main_Form();
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
	public main_Form() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 253);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 442, 194);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNhpLnhKhai = new JLabel("nh\u1EADp l\u1EC7nh khai b\u00E1o bi\u1EBFn ");
		lblNhpLnhKhai.setBounds(21, 44, 116, 14);
		panel.add(lblNhpLnhKhai);
		
		textField = new JTextField();
		textField.setBounds(147, 41, 285, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(146, 97, 286, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnKimTra = new JButton("Ki\u1EC3m Tra");
		btnKimTra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String a = textField.getText();
				BieuThucChinhQuy z = new BieuThucChinhQuy();
				boolean y = z.kiemtra(a);
				if(y==true)
					textField_1.setText("ban da khai bao dung");
				else
					textField_1.setText("khai bao khong chinh xac");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		btnKimTra.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnKimTra.setBounds(21, 92, 116, 41);
		panel.add(btnKimTra);
		
		JButton btnTest = new JButton("test");
		btnTest.setBounds(21, 69, 91, 23);
		panel.add(btnTest);
		btnTest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textField.setText(" ");
			}
		});
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
	}
}
