package ui;

import java.awt.EventQueue;
import java.awt.Font;
import dao.TaskDAO;
import model.Task;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TaskManagementUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JTextField txtTaskId;
	private JTextField txtEmployeeName;

	// Declare ComboBoxes as class variables
	private JComboBox<String> cmbTaskTitle;
	private JComboBox<String> cmbCompleted;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaskManagementUI frame = new TaskManagementUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TaskManagementUI() {

		setTitle("Task Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Heading
		JLabel lblHeading = new JLabel("Task Management");
		lblHeading.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHeading.setBounds(105, 10, 220, 30);
		contentPane.add(lblHeading);

		// Task ID
		JLabel lblTaskId = new JLabel("Task Id");
		lblTaskId.setBounds(20, 60, 100, 20);
		contentPane.add(lblTaskId);

		txtTaskId = new JTextField();
		txtTaskId.setBounds(130, 60, 120, 22);
		contentPane.add(txtTaskId);
		txtTaskId.setColumns(10);

		// Employee Name
		JLabel lblEmployee = new JLabel("Employee Name");
		lblEmployee.setBounds(20, 95, 120, 20);
		contentPane.add(lblEmployee);

		txtEmployeeName = new JTextField();
		txtEmployeeName.setBounds(130, 95, 120, 22);
		contentPane.add(txtEmployeeName);
		txtEmployeeName.setColumns(10);

		// Task Title
		JLabel lblTaskTitle = new JLabel("Task Title");
		lblTaskTitle.setBounds(20, 130, 100, 20);
		contentPane.add(lblTaskTitle);

		cmbTaskTitle = new JComboBox<>();
		cmbTaskTitle.setBounds(130, 130, 120, 24);
		contentPane.add(cmbTaskTitle);

		cmbTaskTitle.addItem("Task1");
		cmbTaskTitle.addItem("Task2");
		cmbTaskTitle.addItem("Task3");

		// Completed
		JLabel lblCompleted = new JLabel("Completed");
		lblCompleted.setBounds(20, 165, 100, 20);
		contentPane.add(lblCompleted);

		cmbCompleted = new JComboBox<>();
		cmbCompleted.setBounds(130, 165, 120, 24);
		contentPane.add(cmbCompleted);

		cmbCompleted.addItem("True");
		cmbCompleted.addItem("False");

		// Submit Button
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(130, 215, 100, 30);

		btnSubmit.addActionListener(e -> {

		    try {

		        Task task = new Task();

		        task.setTaskId(Integer.parseInt(txtTaskId.getText()));
		        task.setEmployeeName(txtEmployeeName.getText());

		        task.setTaskDescription(
		                cmbTaskTitle.getSelectedItem().toString());

		        task.setCompleted(
		                cmbCompleted.getSelectedItem().toString());
		        
		        System.out.println("Employee Name: " + task.getEmployeeName());
		        System.out.println("Task Description: " + task.getTaskDescription());
		        System.out.println("Completed: " + task.getCompleted());
		        TaskDAO dao = new TaskDAO();

		        if (dao.addTask(task)) {

		            JOptionPane.showMessageDialog(null,
		                    "Task Added Successfully!");

		        } else {

		            JOptionPane.showMessageDialog(null,
		                    "Failed to Add Task!");

		        }

		    } catch (Exception ex) {

		        ex.printStackTrace();

		        JOptionPane.showMessageDialog(null,
		                "Please enter valid data.");

		    }

		});

		contentPane.add(btnSubmit);

	}
}