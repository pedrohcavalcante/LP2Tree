package br.imd;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	private Tree arvore = new Tree();
	int noSize = 50;
	
	private MyCanvas canvas = new MyCanvas();
	
	JMenuBar setJMenu = new JMenuBar();
	JMenu options = new JMenu("Opções");
	JMenu ordenar = new JMenu("Imprimir Árvore");
	JMenuItem addElemento = new JMenuItem("Adicionar Elemento");
	JMenuItem updtTree = new JMenuItem("Atualizar Árvore");
	JMenuItem preOrder = new JMenuItem("Pre-Ordem");
	JMenuItem porOrder = new JMenuItem("Pós-Ordem");
	JMenuItem inOrder = new JMenuItem("In-Ordem");
	
	public TelaPrincipal() {
		
		arvore.insereAluno(200, "Tristram"); 
		// Nivel 2
		arvore.insereAluno(100, "Blanche"); 
		arvore.insereAluno(300, "Poe");
		// Nivel 3
		arvore.insereAluno(50, "Wilson");
		arvore.insereAluno(150, "Jannet");
		arvore.insereAluno(250, "Brad");
		arvore.insereAluno(350, "Smith");
		//arvore.insereAluno(450, "Pedro");
		
		
		setJMenu.add(options);
		options.add(addElemento);
		options.add(updtTree);
		setJMenu.add(ordenar);
		ordenar.add(preOrder);
		ordenar.add(porOrder);
		ordenar.add(inOrder);
		
		add(setJMenu);
		
		setJMenuBar(setJMenu);
		setTitle("Janela 2");
		setSize(screenSize.width, screenSize.height);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setLayout(new BorderLayout());
		add("Center", canvas);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		updtTree.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Graphics g = canvas.getGraphics();
				
				desenharArvore(arvore, 0, screenSize.width, 0, g);
			}
		});
		
		addElemento.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nome = JOptionPane.showInputDialog(null, "Insira nome");
				
				// TODO: tratar erro de quando o input for textual e nao numerico
				int matricula = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira matricula"));
				
				
				arvore.insereAluno(matricula, nome);
			}
		});
		
		preOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print("Pre ordem: ");
				arvore.percorrerPreOrdem();
				System.out.println("");
			}
		});
		
		porOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print("Pos ordem: ");
				arvore.percorrerPosOrdem();
				System.out.println("");
			}
		});
		
		inOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print("In ordem: ");
				arvore.percorrerInOrdem();
				System.out.println("");
			}
		});
		
	}
	
	public void desenharArvore(Tree arvore, int screenBegin, int screenEnd, int height, Graphics g) {
		System.out.println("TELA>>> BEGIN: " + screenBegin + " END: " + screenEnd + 
				"\nArvore.getNO(): " + arvore.getRoot().getAluno().getMatricula());
			int location = screenBegin + (screenEnd - screenBegin)/ 2;
			System.out.println("meio " + location);
			
			
			
			
			g.fillOval(location, height + 10, noSize, noSize);
			g.drawString(Integer.toString(arvore.getRoot().getAluno().getMatricula()), location, height + 10);
		
		
		if (arvore.getLeftTree() != null) {
			g.setColor(Color.black);
			desenharArvore(arvore.getLeftTree(), screenBegin, screenEnd / 2, height + noSize + 10, g);
		}
		if (arvore.getRightTree() != null) {
			g.setColor(Color.blue);
			desenharArvore(arvore.getRightTree(), screenEnd / 2, screenEnd, height + noSize + 10, g);
		}
	}
	
	public class MyCanvas extends Canvas {
			
		@Override
		public void paint(Graphics g) {

		}
	}
}
