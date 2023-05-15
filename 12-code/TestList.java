import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

public class TestList {
	private JTextField field;
	private DefaultListModel<String> listModel;
	private JList<String> list;

	class RegButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String tempText = field.getText();
			listModel.addElement(tempText);
		}
	}

	class DelButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int index = list.getSelectedIndex();
			/* �����I�΂�Ă��Ȃ��Ƃ��͂��̂��Ƃ��_�C�A���O�Ƃ��ē`���� */
			if (index != -1) {
				listModel.remove(index);
			} else {
				JOptionPane.showMessageDialog(list, "None selected!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	class QuitButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}


	public Component createComponents() {
		field = new JTextField("initial text");

		/* ���X�g�̖{���̒��g */
		listModel = new DefaultListModel<String>();

		list = new JList<String>(listModel);
		list.setVisibleRowCount(10);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.createVerticalScrollBar();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		/* �o�^�p�̃{�^�� */
		JButton regButton = new JButton("Register");
		RegButtonAction regButtonListener = new RegButtonAction();
		regButton.addActionListener( regButtonListener );
		// �{�^�����������^���ɕ\�������悤�ɂ��邽��
		regButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		/* �폜�p�̃{�^�� */
		JButton delButton = new JButton("Delete");
		DelButtonAction delButtonListener = new DelButtonAction();
		delButton.addActionListener( delButtonListener );

		/* �I���p�̃{�^�� */
		JButton quitButton = new JButton("Quit");
		QuitButtonAction quitButtonListener = new QuitButtonAction();
		quitButton.addActionListener( quitButtonListener );

		/* �폜�ƏI���{�^���̂��� */
		JPanel subPane1 = new JPanel();
		subPane1.setLayout(new GridLayout(1, 0));
		subPane1.add(delButton);
		subPane1.add(Box.createRigidArea(new Dimension(30, 10)));
		subPane1.add(quitButton);

		/* �ŏ�� */
		/* GridLayout���g���ƁA�e�R���|�[�l���g�̑傫�������낦�悤�Ƃ��� */
		JPanel mainPane = new JPanel();
		mainPane.setBorder(BorderFactory.createEmptyBorder( 30, 30, 30, 30 ));
		//	mainPane.setLayout(new GridLayout(0, 1));
		mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
		mainPane.add(field);

		mainPane.add(Box.createRigidArea(new Dimension(10, 20)));
		mainPane.add(regButton);
		mainPane.add(Box.createRigidArea(new Dimension(10, 30)));
		mainPane.add(scrollPane);
		mainPane.add(Box.createRigidArea(new Dimension(10, 20)));
		mainPane.add(subPane1);

		return mainPane;
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("TestList");
		TestList app = new TestList();
		Component contents = app.createComponents();
		frame.getContentPane().add(contents, BorderLayout.CENTER);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
