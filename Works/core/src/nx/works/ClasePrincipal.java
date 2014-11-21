package nx.works;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class ClasePrincipal extends ApplicationAdapter {
	Stage stage;
	Rectangle megaman, sonic, snake;
	Actor mega, son, sna, ghost;
	
	@Override
	public void create () {
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		mega = new Megaman();
		stage.addActor(mega);
		son = new Sonic();
		stage.addActor(son);
		sna = new Snake();
		stage.addActor(sna);
		ghost = new Ghost();
		stage.addActor(ghost);
		
		megaman = new Rectangle(mega.getX(), mega.getY(), mega.getWidth(), mega.getHeight());
		sonic = new Rectangle(son.getX(), son.getY(), son.getWidth(), son.getHeight());
		snake = new Rectangle(sna.getX(), sna.getY(), sna.getWidth(), sna.getHeight());
	}
	
	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 150, 255, 100);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
		
		megaman = new Rectangle(mega.getX(), mega.getY(), mega.getWidth(), mega.getHeight());
		sonic = new Rectangle(son.getX(), son.getY(), son.getWidth(), son.getHeight());
		snake = new Rectangle(sna.getX(), sna.getY(), sna.getWidth(), sna.getHeight());
		
		validarColision();
	}
	
	public void validarColision(){
		if (megaman.overlaps(sonic) || megaman.overlaps(snake)){
			System.out.println("GameOver");
		}
	}
	
}
