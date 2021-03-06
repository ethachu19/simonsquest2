/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simons.squest2.world;

/**
 *
 * @author Javier
 */
public class Tile {
    double altitude;
    public int type;
    public Feature f;
    
    public static final int 
            WATER = 0,            
            SAND = 1,
            GRASS = 2,
            FOREST = 3,
            MOUNTAIN = 4,
            PEAK = 5;
    
    public void setFeature(Feature f){
        this.f = f;
    }
    
    public Feature getFeature(){
        return f;
    }
    
    public Tile(double alt){
        altitude = alt;
        altitude += 1;
        altitude /= 2;
        if(altitude < 0.2){
            type = 0;
        }else if(altitude >= 0.1&& altitude < 0.25){
            type = 1;
        }else if(altitude >= 0.25 && altitude < 0.5){
            type = 2;
        }else if(altitude >= 0.5 && altitude < 0.8){
            type = 3;
        }else if(altitude >= 0.8 && altitude < 0.93){
            type = 4;
        }else{
            type = 5;
        }
    }
    
    @Override
    public String toString(){
        if(f == null)
            return String.valueOf(type);
        
        if(f instanceof Town)
            return "T";
        return "E";
    }
}
