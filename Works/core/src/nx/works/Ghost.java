package nx.works;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Ghost extends Actor{
	ArrayList<Image> images;
	int dibujoActual;
	float tiempoAct = 0;
	
	public Ghost(){
		super();
		images = new ArrayList<Image>();
		//Creando los images 
		images.add(new Image(new Texture("Ghost/volador01.png")));
		images.add(new Image(new Texture("Ghost/volador02.png")));
		images.add(new Image(new Texture("Ghost/volador03.png")));
		images.get(0).setX(0);
		images.get(0).setY(400);
		images.get(0).setWidth(70);
		images.get(0).setHeight(70);
		
		images.get(1).setX(0);
		images.get(1).setY(400);
		images.get(1).setWidth(70);
		images.get(1).setHeight(70);
		
		images.get(2).setX(0);
		images.get(2).setY(400);
		images.get(2).setWidth(70);
		images.get(2).setHeight(70);
		
		dibujoActual = 0;
	}
	
	public void act(float delta){
		super.act(delta);
		
		tiempoAct += delta;
		
		if (tiempoAct >  0.1f){
			dibujoActual++;
			tiempoAct = 0;			
		}
		

		if(dibujoActual >= images.size())
			dibujoActual = 0;
		
		//System.out.println(tiempoAct);
		//++llamadasAct;
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha){
		super.draw(batch, parentAlpha);
		images.get(dibujoActual).draw(batch, parentAlpha);
	}
}
