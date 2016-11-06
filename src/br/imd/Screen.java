package br.imd;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Screen extends JInternalFrame{
	//Tree test = new Tree();
	// Variáveis do FormAddElements
	JLabel lnome = new JLabel("Nome.: ");
	JLabel lmatricula = new JLabel("Matrícula.:");
	final JTextField tnome  = new JTextField();
	final JTextField tmatricula = new JTextField();
	JButton b1 = new JButton("Submeter");
	JButton b2 = new JButton("Limpar");
	Container form_container;
	// FIM
	
	boolean isRoot2;
	private MyCanvas canvas = new MyCanvas();
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	JMenuBar setJMenu = new JMenuBar();
	JMenu options = new JMenu("Opções");
	JMenu ordenar = new JMenu("Imprimir Árvore");
	JMenuItem addElemento = new JMenuItem("Adicionar Elemento");
	JMenuItem updtTree = new JMenuItem("Atualizar Árvore");
	JMenuItem preOrder = new JMenuItem("Pre-Ordem");
	JMenuItem porOrder = new JMenuItem("Pós-Ordem");
	JMenuItem inOrder = new JMenuItem("In-Ordem");
	JPanel toText;
	JTextArea text = new JTextArea();
	
	public void FormAddElement(){
		form_container = this.getContentPane();
		form_container.setLayout(null);
		lnome.setBounds(10,10,100,30);
		tnome.setBounds(55,10,280,25);
		lmatricula.setBounds(10,40,100,30);
		tmatricula.setBounds(75,40,100,25);
		
		b1.setBounds(10 ,140,100,30);
		b1.setMnemonic('S');
		b2.setBounds(120,140,100,30);
		b2.setMnemonic('L');
		form_container.add(lnome);
		form_container.add(tnome);
		form_container.add(lmatricula);
		form_container.add(tmatricula);
		form_container.add(b1);
		form_container.add(b2);
		setSize(350,230);
		setTitle("Adicionar Elemento");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public Screen(boolean test) {
		super("OI");
		// OPA
		
		// FIM
		setJMenu.add(options);
		options.add(addElemento);
		options.add(updtTree);
		setJMenu.add(ordenar);
		ordenar.add(preOrder);
		ordenar.add(porOrder);
		ordenar.add(inOrder);
		
		add(setJMenu);
		
		setJMenuBar(setJMenu);
		isRoot2 = test;
		setTitle("Vamo lá");
		setSize(screenSize.width, screenSize.height);
		setLayout(new BorderLayout());

		add("Center", canvas);
		//JFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setLocationRelativeTo(null);
		setVisible(true);
		
		addElemento.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				FormAddElement();
			}
		});
		updtTree.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("oi puta");
			}
		});
	}
	
	public class MyCanvas extends Canvas {
		
		@Override
		public void paint(Graphics g) {
			if (isRoot2){
				g.fillOval(screenSize.width/2, 10, 30, 30);
			}else{
				System.out.println("Não é raiz!");
			}	
		}
	}
	
}
