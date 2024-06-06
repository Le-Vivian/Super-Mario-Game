package View;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import View.Tile;
import controller.Controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * main class to handle the mechanism behind how each tile si diplayed which is put into a 2d array
 * @author 
 *
 */
public class TileManager {
    GamePanel gp;
    protected Tile[] tile;
    protected int mapTileNum[][];
    int mapNum =1;
    
    
  
    public Tile[] getTile() {
		return tile;
	}

	public void setTile(Tile[] tile) {
		this.tile = tile;
	}

	public int[][] getMapTileNum() {
		return mapTileNum;
	}

	public void setMapTileNum(int[][] mapTileNum) {
		this.mapTileNum = mapTileNum;
	}

	/**
     * constructor which initializes the variables
     * @param gp
     */
    public TileManager(GamePanel gp , int mapNum){
    	
       this.mapNum = mapNum;
    	this.gp = gp;
        tile = new Tile[27];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap();
    }

    /**
     * getter to set up the array that hoilds the different tiles to be rendered
     */
    public void getTileImage() {
        try {
       	File ground1 = new File("bin/images/map/ground.png");
           File hill1 = new File("bin/images/map/hill1.png");
           File hill2 = new File("bin/images/map/hill2.png");
           File hill3 = new File("bin/images/map/hill3.png");
           File hill4 = new File("bin/images/map/hill4.png");
           File hill5 = new File("bin/images/map/hill5.png");
           File hill6 = new File("bin/images/map/hill6.png");
           File sky1 = new File("bin/images/map/sky.png");
            
        	// File ground1 = new File("C:/eclipse workspace/JavaGame/bin/images/map/ground.png");
            // File hill1 = new File("C:/eclipse workspace/JavaGame/bin/images/map/hill1.png");
            // File hill2 = new File("C:/eclipse workspace/JavaGame/bin/images/map/hill2.png");
            // File hill3 = new File("C:/eclipse workspace/JavaGame/bin/images/map/hill3.png");
            // File hill4 = new File("C:/eclipse workspace/JavaGame/bin/images/map/hill4.png");
            // File hill5 = new File("C:/eclipse workspace/JavaGame/bin/images/map/hill5.png");
            // File hill6 = new File("C:/eclipse workspace/JavaGame/bin/images/map/hill6.png");
            // File sky1 = new File("C:/eclipse workspace/JavaGame/bin/images/map/sky.png");
            
           // new tiles
            //brown bloc 1 and 2 , 4 pipes ,6 clouds , 3 bush , 2 flag
            
            File brownBloc1 = new File("src/images/map/brownBloc.png");
            File brownBloc2 = new File("src/images/map/brownBlock2.png");
            File pipeBotLeft = new File("src/images/map/pipeBotLeft.png");
            File pipeBotRight = new File("src/images/map/pipeBotRight.png");
            File pipeTopRight = new File("src/images/map/pipeTopRight.png");
            File pipeTopLeft = new File("src/images/map/pipeTopRight.png");
            File cloudTopLeft = new File("src/images/map/cloudTopLeft.png");
            File cloudTopMiddle = new File("src/images/map/cloudTopMiddle.png");
            File cloudTopRight = new File("src/images/map/cloudTopRight.png");
            File cloudBotLeft = new File("src/images/map/cloudBotLeft.png");
            File cloudBotMiddle = new File("src/images/map/cloudBotMiddle.png");
            File cloudBotRight = new File("src/images/map/cloudBotRight.png");
            File bushLeft = new File("src/images/map/bushLeft.png");
            File bushMiddle = new File("src/images/map/bushMiddle.png");
            File bushRight = new File("src/images/map/bushRight.png");
            File flagPole = new File("src/images/map/flagPole.png");
            File flagTip = new File("src/images/map/flagPoleTip.png");
            
            

             BufferedImage ground_1 = ImageIO.read(ground1);
            BufferedImage hill_1 = ImageIO.read(hill1);
             BufferedImage hill_2 = ImageIO.read(hill2);
             BufferedImage hill_3= ImageIO.read(hill3);
             BufferedImage hill_4= ImageIO.read(hill4);
            BufferedImage hill_5= ImageIO.read(hill5);
            BufferedImage hill_6= ImageIO.read(hill6);
             BufferedImage sky_1= ImageIO.read(sky1);
             
             
             BufferedImage brownBloc_1 = ImageIO.read(brownBloc1);
             BufferedImage brownBlock_2 = ImageIO.read(brownBloc2);
             BufferedImage pipeBotLeft_ = ImageIO.read(pipeBotLeft);
             BufferedImage pipeBotRight_ = ImageIO.read(pipeBotRight);
             BufferedImage pipeTopRight_ = ImageIO.read(pipeTopRight);
             BufferedImage pipeTopLeft_ = ImageIO.read(pipeTopLeft);
             BufferedImage cloudTopLeft_ = ImageIO.read(cloudTopLeft);
             BufferedImage cloudTopMiddle_ = ImageIO.read(cloudTopMiddle);
             BufferedImage cloudTopRight_ = ImageIO.read(cloudTopRight);
             BufferedImage cloudBotLeft_ = ImageIO.read(cloudBotLeft);
             BufferedImage cloudBotMiddle_ = ImageIO.read(cloudBotMiddle);
             BufferedImage cloudBotRight_ = ImageIO.read(cloudBotRight);
             BufferedImage bushLeft_ = ImageIO.read(bushLeft);
             BufferedImage bushMiddle_ = ImageIO.read(bushMiddle);
             BufferedImage bushRight_ = ImageIO.read(bushRight);
             BufferedImage flagPole_ = ImageIO.read(flagPole);
             BufferedImage flagTip_ = ImageIO.read(flagTip);
             

            tile[0] = new Tile();
            tile[0].image = ground_1;
            tile[0].collision = true;

            tile[1] = new Tile();
            tile[1].image =sky_1;

            tile[2] = new Tile();
            tile[2].image =hill_1;
            tile[3] = new Tile();
            tile[3].image =hill_2;
            tile[4] = new Tile();
            tile[4].image = hill_3;
            tile[5] =new Tile();
            tile[5].image = hill_4;
            tile[6] = new Tile();
            tile[6].image =hill_5;
            tile[7] = new Tile();
            tile[7].image = hill_6;
            
            // new 
            tile[8] = new Tile();
            tile[8].image = brownBloc_1;
            tile[8].collision = true;
            
            tile[9] = new Tile();
            tile[9].image = brownBlock_2;
            tile[9].collision = true;
            
            tile[10] = new Tile();
            tile[10].image =  pipeBotLeft_;
            tile[10].collision = true;
            
            tile[11] = new Tile();
            tile[11].image = pipeBotRight_;
            tile[11].collision = true;
            
            tile[12] = new Tile();
            tile[12].image = pipeTopRight_;
            tile[12].collision = true;
            
            tile[13] = new Tile();
            tile[13].image = pipeTopLeft_;
            tile[13].collision = true;
            
            tile[14] = new Tile();
            tile[14].image = cloudTopLeft_;
            
            tile[15] = new Tile();
            tile[15].image = cloudTopMiddle_;
            
            tile[16] = new Tile();
            tile[16].image = cloudTopRight_;
            
            tile[17] = new Tile();
            tile[17].image = cloudBotLeft_ ;
            
            tile[18] = new Tile();
            tile[18].image = cloudBotMiddle_;
            
            tile[19] = new Tile();
            tile[19].image = cloudBotRight_ ;
            
            tile[20] = new Tile();
            tile[20].image = bushLeft_ ;
            
            tile[21] = new Tile();
            tile[21].image = bushMiddle_;
            
            tile[22] = new Tile();
            tile[22].image = bushRight_;
            
            tile[23] = new Tile();
            tile[23].image = flagPole_;
            
            tile[24] = new Tile();
            tile[24].image = flagTip_;

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * this is the main method that renders the entire screen loops through an array and sets tiles based on the determined layout
     */
    public void loadMap(){
        try {
        	InputStream is = null;
        	//File map = new File("src/images/map/maps/map01.txt");
        	File map = new File("bin/images/map/maps/map01.txt");
        	File map2 = new File("bin/images/map/maps/map02.txt");
        	
           // InputStream is = getClass().getResourceAsStream("../player/maps/map01.txt");
        	
        	if(mapNum == 1) {
        	 is = new FileInputStream(map);
        	}
        	else if(mapNum == 2) {
        	 is = new FileInputStream(map2);
        	}
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col=0;
            int row=0;
            while(col < gp.maxWorldCol && row < gp.maxWorldRow){
                String line = br.readLine();
                while(col < gp.maxWorldCol){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * method for drawing the tiles using the graphics class
     * @param g2
     */
    public void draw(Graphics2D g2){
        

        int worldCol = 0;
        int worldRow = 0;
        // int x = 0;
        // int y = 0;

        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){

            int tileNum = mapTileNum[worldCol][worldRow];
            int worldX = worldCol * gp.TILESIZE;
            int worldY = worldRow * gp.TILESIZE;
            int screenX = worldX - gp.player.getWorldX() + gp.player.screenX;
            int screenY = worldY - gp.player.getWorldY() + gp.player.screenY;

            if(worldX + gp.TILESIZE > gp.player.getWorldX() - gp.player.screenX && 
            worldX + gp.TILESIZE < gp.player.getWorldX() + gp.player.screenX &&
            worldY + gp.TILESIZE > gp.player.getWorldY() - gp.player.screenY &&
            worldY + gp.TILESIZE < gp.player.getWorldY() + gp.player.screenY){
                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.TILESIZE, gp.TILESIZE, null);

            }
            
            g2.drawImage(tile[tileNum].image, screenX, screenY, gp.TILESIZE, gp.TILESIZE, null);
            worldCol++;
            // x += gp.TILESIZE;

            if (worldCol == gp.maxWorldCol){
                worldCol = 0;
                // x = 0;
                worldRow++;
                // y += gp.TILESIZE;
            }
        }

    }
    
    public int getMapNum() {
    	return mapNum;
    }
    public void setMapNum(int i) {
    	this.mapNum = i;
    }
    
}
