import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Sprite extends Component {
	private Image sprite;
	
	public Sprite(String path) throws SlickException {
		this.setSprite(new Image(path));
	}

	public Image getSprite() {
		return sprite;
	}

	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}
	
	public void setSprite(String path) throws SlickException {
		sprite = new Image(path);
	}
}
