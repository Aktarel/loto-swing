package fr.esiea.gl.ihm;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fr.esiea.gl.charts.GraphiquePerformances;
import fr.esiea.gl.thread.ThreadRuntime;

/**
 * 
 * Ce panneau affiche les options pour configurer l'application
 * @author Akta
 *
 */
public class PanelOption extends JPanel implements MouseListener{

	private static final long serialVersionUID = 1L;
	private JPanel panelGauche,panelDroite,panelGaucheBas,panelGaucheHaut;
	private JLabel helpIcon,labelMemoireUtilise,memoireUtilise;
	private ThreadRuntime t;
	private GraphiquePerformances graphiquePerformance;
	private static PanelOption instance;
	
	public static PanelOption getInstance(){
		
		if(instance==null)
			return new PanelOption();
		else
			return instance;
		
	}
	
	private PanelOption() {
		
		labelMemoireUtilise = new JLabel("Memoire utilisée : ");
		memoireUtilise = new JLabel();
		
		
		setLayout(new BorderLayout());
		helpIcon = new JLabel(new ImageIcon(getClass().getResource("/help.png")));
		panelGauche = new JPanel(new BorderLayout());
		panelDroite = new JPanel();
		panelGaucheHaut = new JPanel();
		panelGaucheBas = new JPanel();
		graphiquePerformance = new GraphiquePerformances();
		
		panelGauche.add(panelGaucheHaut,BorderLayout.NORTH);
		panelGauche.add(panelGaucheBas,BorderLayout.SOUTH);
		
		panelGaucheBas.add(labelMemoireUtilise);
		panelGaucheBas.add(memoireUtilise);
		panelGaucheBas.add(new JButton(new ButtonNettoyer("Nettoyer")));
		
		panelGaucheHaut.add(new JLabel("Template"));
		panelGaucheHaut.add(new ComboLookNFeel());
		panelGaucheHaut.add(helpIcon);
		
		panelDroite.add(graphiquePerformance);
		
		add(panelDroite, BorderLayout.EAST);
		//add(new JSeparator(SwingConstants.VERTICAL),BorderLayout.CENTER);
		add(panelGauche, BorderLayout.WEST);
		addMouseListener(this);
		setName("Option");
		setVisible(true);
		
		t = new ThreadRuntime(graphiquePerformance,memoireUtilise);
		
		
	}

	public JLabel getMemoireUtilise() {
		return memoireUtilise;
	}

	public void setMemoireUtilise(JLabel memoireUtilise) {
		this.memoireUtilise = memoireUtilise;
	}


	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getPoint()+" "+(int)helpIcon.getLocation().getX()+" "+(int)helpIcon.getLocation().getY());
		if(estDansMaHitBox(e.getPoint(), helpIcon.getLocation())){
			System.out.println("click");
			JOptionPane.showMessageDialog(this,
					"Pour changer d'habillage de fenetre",
					"Aide",
					JOptionPane.INFORMATION_MESSAGE);
		  }
		
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
	}

	private boolean estDansMaHitBox(Point ptOnScreen, Point img){
		Rectangle hitBoxImg = new Rectangle((int)img.getX(),(int)img.getY(),22,22);
		return hitBoxImg.contains(ptOnScreen);
	}
	

}
