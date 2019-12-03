import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JApplet;

public class EX16 extends JApplet {
	private Image img;
	public void init(){
		img = getImage(getCodeBase(),"plane.jpeg");
	}
	public void paint(Graphics g){
		g.drawImage(img,10,10,this);
	}
}
