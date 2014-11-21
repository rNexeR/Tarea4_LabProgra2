package nx.works;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Snake extends Actor{
	ArrayList<Image> images;
	int dibujoActual;
	float tiempoAct = 0;
	
	public Snake(){
		super();
		images = new ArrayList<Image>();
		//Creando los images y configurandoles el ancho y alto
		for (int i = 1; i < 7; i++){
			images.add(new Image(new Texture("Snake/"+i+".png")));
			images.get(i-1).setWidth(100);
			images.get(i-1).setHeight(100);
			
			setWidth(100);
			setHeight(100);
			
			images.get(i-1).setX(520);
			images.get(i-1).setY(0);
			setX(520);
		}
		dibujoActual = 0;
	}
	
	public void act(float delta){
		super.act(delta);
		
		tiempoAct += delta;
		
		if (tiempoAct >  0.25f){
			dibujoActual++;
			tiempoAct = 0;			
		}
		

		if(dibujoActual >= images.size())
			dibujoActual = 0;

		if (images.get(0).getY()>=450){
			for (int i = 0; i < 6; i++){
				images.get(i).setY(-50);
			}
		}
		
		changeY(1);
	}
	
	void changeY(int x){
		for (int i = 0; i < 6; i++){
			images.get(i).setY(images.get(i).getY()+x);
			setY(images.get(i).getY());
		}
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha){
		super.draw(batch, parentAlpha);
		images.get(dibujoActual).draw(batch, parentAlpha);
	}
	
	public int[] getCoordenadas(){
		int x [] = {((int)(getX())), ((int)getY()), ((int)getWidth()), ((int)getHeight())};
		return x;
	}
}
