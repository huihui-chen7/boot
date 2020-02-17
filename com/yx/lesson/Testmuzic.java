package src.com.yx.lesson;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;//添加鼠标事件必备引用
import java.awt.event.ActionListener;//添加鼠标事件必备引用

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Testmuzic extends JFrame implements Runnable {
	// extends JPanel implements ActionListener

	/**
	 * 
	 */

	private static final long serialVersionUID = -5913616585432258549L;

	static JPanel p = new JPanel();
	static JFileChooser chooser;
	String choosertitle;
	Container con = this.getContentPane();
	boolean b = true;
	Thread t;
	String song_name;
	JLabel label1 = new JLabel("");
	static JTextField text = new JTextField(15);
	JTextArea area = new JTextArea(10, 20);
	JButton button = new JButton("下载");
	JButton stop = new JButton("暂停");
	JButton jb = new JButton("选择文件夹");

	public Testmuzic(String song_name) throws HeadlessException {
		super();
		this.song_name = song_name;
	}

	public Testmuzic() {
		super();
	}

	public static void main(String s[]) {
		System.out.println("");
		new Testmuzic().Test1();
		new Testmuzic();

	}

	public String Test1() {
		boolean b = true;

		this.setTitle("test");
		con.setLayout(new FlowLayout());
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result;
				chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle(choosertitle);
				System.out.println("---" + choosertitle);
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);
				if (chooser.showOpenDialog(p) == JFileChooser.APPROVE_OPTION) {
					System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
					System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
				} else {
					System.out.println("No Selection ");
				}
			}
		});

		p.add(jb);
		this.add(p, "Center");
		control c = new control();
		this.add(c);
		this.setSize(320, 240);
		this.setVisible(true);
		con.add(BorderLayout.CENTER, label1);
		con.add(text);
		con.add(stop);
		con.add(button);
		con.add(area);

		text.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				text.setText(text.getText());
			}
		});
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				text.setText(text.getText());
				text.requestFocus();

				area.setText(song_name);
				repaint();
				Demo_3.muzicAll(text.getText(), chooser.getSelectedFile(), b);
				area.setText(text.getText());

			}

		});

		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setSize(300, 450);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // 设置关闭方式，可以选择多种关闭玄子选项
		return choosertitle;

	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}

			stop.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

				}

			});
		}
	}
}
