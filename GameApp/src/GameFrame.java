import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame {
	private GamePanel gamePanel = new GamePanel();
	private	ScorePanel scorePanel = new ScorePanel();
	private EditPanel editPanel = new EditPanel();
	
	public GameFrame() {
		super("Ÿ���� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		
		JLabel text = new JLabel("Ÿ�̸�: ");
		
		Container c = this.getContentPane();
		//c.setBackground(Color.orange);
		//c.add(new MyPanel(), BorderLayout.CENTER);
		c.add(makeToolBar(), BorderLayout.NORTH);
		this.setJMenuBar(makeMenu());
		
		setResizable(false);
		splitPane();
		setVisible(true);
	}
	
	public JToolBar makeToolBar() {
		JToolBar tb = new JToolBar();
		tb.add(new JButton("����"));
		tb.add(new JButton("�ݱ�"));
		//tb.add(new JTextField("�Է�....."));
		return tb;
	}
	
	public JMenuBar makeMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		
		
		fileMenu.add(new JMenuItem("New Game"));
		fileMenu.addSeparator();
		fileMenu.add("Exit");
		
		JMenu editMenu = new JMenu("Setting");
		editMenu.add(new JMenuItem("Level Control"));
		editMenu.add(new JMenuItem("Mode Change"));
		JMenu viewMenu = new JMenu("View");
		JMenu optionMenu = new JMenu("Option");
		mb.add(fileMenu);
		mb.add(optionMenu);
		mb.add(editMenu);
		mb.add(viewMenu);
		
		return mb;
	}
	
	private void splitPane() {
		JSplitPane hPane = new JSplitPane();
		getContentPane().add(hPane, BorderLayout.CENTER);
		
		hPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);		
		hPane.setDividerLocation(500);
		hPane.setEnabled(false); // split bar�� ������ �� ������ �ϱ� ����
		hPane.setLeftComponent(gamePanel);
		
		JSplitPane pPane = new JSplitPane();
		hPane.setRightComponent(pPane);
		pPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		pPane.setDividerLocation(200);
		pPane.setTopComponent(scorePanel);
		pPane.setBottomComponent(editPanel);
	}
}
