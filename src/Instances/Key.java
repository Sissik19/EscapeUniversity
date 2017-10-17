package Instances;

import Commands.Command;

import java.io.Serializable;

public class Key implements Serializable{

    private String couleur;
    public Key(String couleur){
        this.couleur = couleur;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getKeyName(){
        if(Command.isNumeric(couleur)){
            return "code "+couleur;
        }
        else{
            return "key "+couleur;
        }
    }

}
