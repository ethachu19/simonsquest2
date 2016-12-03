/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simons.squest2.world;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Javier
 */
public class World {
    List<Enemy> entities = new ArrayList<>();
    
    Tile[][] map = new Tile[100][100];
    
    public World(){
        double[][] rmap = generateMap();
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                map[i][j] = new Tile(rmap[i][j]);
            }
        }
        
        for(Tile[] x : map){
            for(Tile y : x){
                System.out.print(y.type + " ");
            }
            System.out.println("");
        }
        
        System.out.println("Generator finished");
    }
    double[][] generateMap(){
        RandomGen simplexNoise=new RandomGen(100,0.1,5000);

        double xStart=0;
        double XEnd=map.length;
        double yStart=0;
        double yEnd=map[0].length;

        int xResolution=200;
        int yResolution=200;

        double[][] result=new double[xResolution][yResolution];

        for(int i=0;i<xResolution;i++){
            for(int j=0;j<yResolution;j++){
                int x=(int)(xStart+i*((XEnd-xStart)/xResolution));
                int y=(int)(yStart+j*((yEnd-yStart)/yResolution));
                result[i][j]=simplexNoise.getNoise(x,y);
            }
        }
        return result;
   }

}