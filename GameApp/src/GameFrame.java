import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame {
	private GamePanel gamePanel = new GamePanel();
	private	ScorePanel scorePanel = new ScorePanel();
	private EditPanel editPanel = new EditPanel();
	
	public GameFrame() {
		super("타이핑 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setResizable(false);
		Container c= this.getContentPane();
		c.add(makeToolBar(),BorderLayout.NORTH);
		this.setJMenuBar(makeMenu());
		splitPane();
		setVisible(true);
	}
	private void splitPane() {
		JSplitPane hPane = new JSplitPane();
		getContentPane().add(hPane, BorderLayout.CENTER);
		
		hPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);		
		hPane.setDividerLocation(500);
		hPane.setEnabled(false); // split bar를 움직일 수 없도록 하기 위해
		hPane.setLeftComponent(gamePanel);
		
		JSplitPane pPane = new JSplitPane();
		hPane.setRightComponent(pPane);
		pPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		pPane.setDividerLocation(200);
		pPane.setTopComponent(scorePanel);
		pPane.setBottomComponent(editPanel);
	}
	
	public JToolBar makeToolBar() {
		JToolBar tb = new JToolBar();
		tb.add(new JButton("열기"));
		tb.add(new JButton("닫기"));
		tb.add(new JTextField("입력"));
		return tb;
	}
	public JMenuBar makeMenu() {
		JMenuBar mb = new JMenuBar();  //메뉴바: 공간, 메뉴: 메뉴칸들, 메뉴아이템: 메뉴칸누르면 밑으로 오는애들
		JMenu optionMenu = new JMenu("Option");
		mb.setBackground(new Color(255,238,137));
		
		optionMenu.add(new JMenuItem("New Game"));
		optionMenu.addSeparator();
		optionMenu.add(new JMenuItem("Exit"));
		optionMenu.setForeground(new Color(255,124,25));
		
		JMenu settingMenu = new JMenu("Setting");
		settingMenu.add(new JMenuItem("Level Control"));
		settingMenu.add(new JMenuItem("Mode Change"));
		settingMenu.setForeground(new Color(255,124,25));
		
		
		mb.add(optionMenu);
		mb.add(settingMenu);
		
		return mb;
	}
}
