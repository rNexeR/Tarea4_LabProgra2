package nx.works;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Sonic extends Actor{
	ArrayList<Image> images;
	int dibujoActual;
	
	float tiempoAct = 0;
	
	public Sonic(){
		super();
		images = new ArrayList<Image>();
		//Creando los images y configurandoles el ancho y alto
		for (int i = 1; i < 7; i++){
			images.add(new Image(new Texture("Sonic/"+i+".png")));
			images.get(i-1).setWidth(100);
			images.get(i-1).setHeight(100);
			
			setWidth(100);
			setHeight(100);
			
			images.get(i-1).setX(0);
			images.get(i-1).setY(100);
			setY(100);
		}
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

		if (images.get(0).getX()>=620){
			for (int i = 0; i < 6; i++){
				images.get(i).setX(-20);
			}
		}
		
		changeX(2);
	}
	
	void changeX(int x){
		for (int i = 0; i < 6; i++){
			images.get(i).setX(images.get(i).getX()+x);
			setX(images.get(i).getX());
		}
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha){
		super.draw(batch, parentAlpha);
		images.get(dibujoActual).draw(batch, parentAlpha);
	}
}
