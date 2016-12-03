/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simons.squest2.states;

import java.io.File;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import simons.squest2.GameVariables;
import simons.squest2.world.World;

/**
 *
 * @author Warren
 */
public class GameState extends State {

    World w;
    final Image playersprite = new Image(new File("C:/res/battlebackground.jpg").toURI().toString());
    final int tilesize = 16;
    final int camerawidth = 1300, cameraheight = 950;

    public GameState(String name) {
        super(name);
        w = new World();
    }

    @Override
    public void render(GraphicsContext gc) {
        int startCol = GameVariables.x / tilesize;
        int endCol = startCol + (camerawidth / tilesize);
        int startRow = GameVariables.x / tilesize;
        int endRow = startRow + (cameraheight / tilesize);

        int offsetX = -GameVariables.x + startCol * tilesize;
        int offsetY = -GameVariables.y + startRow * tilesize;

        for (int c = startCol; c <= endCol; c++) {
            for (int r = startRow; r <= endRow; r++) {
                int tile = w.map[c][r].type;
                int x = (c - startCol) * tilesize + offsetX;
                int y = (r - startRow) * tilesize + offsetY;
                switch (tile) {
                    case 0: //water
                        gc.setFill(Color.BLUE);
                        break;
                    case 1: //Sand
                        gc.setFill(Color.BLANCHEDALMOND);
                        break;
                    case 2: //Grass
                        gc.setFill(Color.YELLOWGREEN);
                        break;
                    case 3: //Forest
                        gc.setFill(Color.GREEN);
                        break;
                    case 4: //water
                        gc.setFill(Color.BROWN);
                        break;
                    default:
                        gc.setFill(Color.CRIMSON);
                        break;
                }
                gc.fillRect(x, y, tilesize, tilesize);

            }
        }
    }

    @Override
    public void update() {

    }

}
