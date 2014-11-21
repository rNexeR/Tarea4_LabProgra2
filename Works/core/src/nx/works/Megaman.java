package nx.works;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Megaman extends Actor{
	ArrayList<Image> images;
	int dibujoActual;
	float tiempoAct = 0;
	
	public Megaman(){
		super();
		images = new ArrayList<Image>();
		//Creando los images y configurandoles el ancho y alto
		for (int i = 1; i < 7; i++){
			images.add(new Image(new Texture("Megaman/"+i+".png")));
			images.get(i-1).setWidth(100);
			images.get(i-1).setHeight(100);
			setWidth(100);
			setHeight(100);
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
		
		//System.out.println(tiempoAct);
		//++llamadasAct;
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha){
		super.draw(batch, parentAlpha);
		images.get(dibujoActual).draw(batch, parentAlpha);
		moverTeclado();
	}
	
	void changeX(int x){
		for (int i = 0; i < 6; i++){
			images.get(i).setX(images.get(i).getX()+x);
			setX(images.get(i).getX());
		}
	}
	
	void changeY(int x){
		for (int i = 0; i < 6; i++){
			images.get(i).setY(images.get(i).getY()+x);
			setY(images.get(i).getY());
		}
	}
	
	public void moverTeclado(){
		if (Gdx.input.isKeyPressed(Input.Keys.UP)){
			changeY(1);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
			changeY(-1);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			changeX(-1);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			changeX(1);
		}
	}
}
