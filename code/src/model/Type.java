package model;
import javafx.scene.image.Image;
import model.EnumType;

public class Type {
    public EnumType type;
    public Image texture;
    private int cellSize;
    public Type(EnumType type){
        this.type = type;
        this.cellSize = 40;
        setTextureSwitch(type);
    }
    public Type(EnumType type, int cellSize) {
        this.type = type;
        this.cellSize = cellSize;
        setTextureSwitch(type);
    }

    private void setTextureSwitch(EnumType type){
        switch (type){
            case Roche:
                this.texture = new Image("/images/Stone_(texture).png", cellSize, cellSize, false, false);
                break;
            case Terre:
                this.texture = new Image("/images/Dirt_(texture).jpg", cellSize, cellSize, false, false);
                break;
            case Herbe:
                this.texture = new Image("/images/Grass_(texture).jpg", cellSize, cellSize, false, false);
                break;
            case Bedrock:
                this.texture = new Image("/images/Bedrock_(texture).png", cellSize, cellSize, false, false);
                break;
            default:
                break;
        }
    }

    EnumType getType(){
        return type;
    }

    public String toString(){
        return type.toString();
    }
}
