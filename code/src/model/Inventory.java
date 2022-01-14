package model;

import javafx.scene.canvas.Canvas;

/**
 *  Inventaire du Joueur, récupére et affiche les blocs que le Joueur casse.
 */
public class Inventory {

    public Type[] slots;

    /**
     * Instancie un inventaire en mettant le nombre de slots à 9
     */
    public Inventory(){
        slots = new Type[9];
    }

    /**
     * Dessine l'inventaire vide.
     * @param canvas
     */
    public void drawInventory(Canvas canvas){
        //largeur inv 540px hauteur 60px
        int largeurCase = 0;
        for (int i =0;i<9;i++){
            canvas.getGraphicsContext2D().strokeRect(canvas.getWidth()/2-270 + largeurCase, canvas.getHeight()- 100, 60,60);
            largeurCase= largeurCase + 60;
        }
    }

    /**
     * Remplit l'inventaire de bloc d'air.
     */
    public void fillSlots(){
        for(int i = 0; i<9;i++){
            slots[i] = new Type(EnumType.Air);
        }
    }

    /**
     * Permet de mettre un bloc dans un slot vide
     * @param type type de bloc à mettre dans un slot.
     */
    public void setSlot(Type type){

        for (int i = 0; i<9 ; i++){
            //éviter de mettre un type de bloc dans une case qui est déjà utilisée
            if(slots[i].type.equals(EnumType.Air) || slots[i].type.equals(type.type)) {
                slots[i] = type;
                break;
            }
        }
    }

    /**
     * Dessine les blocs dans les slots qui correspondent
     * @param canvas
     */
    public void drawItems(Canvas canvas){
        int largeurCase = 0;
        for(int i = 0; i<9; i++){
                canvas.getGraphicsContext2D().drawImage(slots[i].texture, canvas.getWidth()/2-265 + largeurCase, canvas.getHeight()- 95, 50, 50);
                largeurCase= largeurCase + 60;
        }
    }

    /**
     * **DEBUG**
     * Retourne le contenu de l'inventaire sous forme de texte
     * @return contenu de slots
     */
    public String ToString(){

        String s = "";
        for(int i =0;i<9;i++){
            s = s + slots[i].type.toString();
        }
        return s;
    }

}
