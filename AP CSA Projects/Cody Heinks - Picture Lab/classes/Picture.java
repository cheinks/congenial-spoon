    import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void keepOnlyBlue(){
      Pixel[][] pixels = this.getPixels2D();
      for(Pixel[] rowArray : pixels){
          for(Pixel pixelObj : rowArray){
              pixelObj.setRed(0);
              pixelObj.setGreen(0);
            }
        }
  }
  
  public void negate(){
      Pixel[][] pixels = this.getPixels2D();
      for(Pixel[] rowArray : pixels){
          for(Pixel pixelObj : rowArray){
              pixelObj.setRed(255 - pixelObj.getRed());
              pixelObj.setBlue(255 - pixelObj.getBlue());
              pixelObj.setGreen(255 - pixelObj.getGreen());
            }
        }
  }
  
  public void grayscale(){
      Pixel[][] pixels = this.getPixels2D();
      for(Pixel[] rowArray : pixels){
          for(Pixel pixelObj : rowArray){
              int average = pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue();
              average /= 3;
              pixelObj.setRed(average);
              pixelObj.setGreen(average);
              pixelObj.setBlue(average);
            }
        }
  }
  
  //Challenge
  public void fixUnderwater(){
      Pixel[][] pixels = this.getPixels2D();
      for(Pixel[] rowArray : pixels){
          for(Pixel pixelObj : rowArray){
              pixelObj.setRed(pixelObj.getRed()*3);
            }
        }
    }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  public void mirrorVerticalRightToLeft(){
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
    } 
  }
  
  public void mirrorHorizontal(){
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int height = pixels.length;
    for(int row = 0; row < height / 2; row++){
        for(int col = 0; col < pixels[0].length; col++){
            topPixel = pixels[row][col];
            bottomPixel = pixels[height - 1 - row][col];
            bottomPixel.setColor(topPixel.getColor());
        }
    }
  }
  
  public void mirrorHorizontalBotToTop(){
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int height = pixels.length;
    for(int row = 0; row < height / 2; row++){
        for(int col = 0; col < pixels[0].length; col++){
            topPixel = pixels[row][col];
            bottomPixel = pixels[height - 1 - row][col];
            topPixel.setColor(bottomPixel.getColor());
        }
    }
  }
  
  //Challenge
  public void mirrorDiagonal(){
      Pixel[][] pixels = this.getPixels2D();
      Pixel bottomLeft = null;
      Pixel topRight = null;
      int width = pixels.length;
      int height = pixels[0].length;
      int diag = width;
      if(diag > height){
          diag = height;
      }
      for(int row = 0; row < diag; row++){
          for(int col = 0; col < diag; col++){
              bottomLeft = pixels[row][col];
              topRight = pixels[col][row];
              bottomLeft.setColor(topRight.getColor());
            }
        }
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.println(count);
  }
  
  public void mirrorArms(){
    int rightArm = 191;
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    
    for (int row = 156; row < rightArm; row++)
    {
      for (int col = 103; col < 170; col++)
      {
        
        topPixel = pixels[row][col];      
        bottomPixel = pixels[row + 2*(rightArm - row)][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    }
    
    int leftArm = 191;
    topPixel = null;
    bottomPixel = null;
    
    for (int row = 168; row < leftArm; row++)
    {
      for (int col = 239; col < 296; col++)
      {
        
        topPixel = pixels[row][col];      
        bottomPixel = pixels[row + 2*(leftArm - row)][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    }
  }
  
  public void mirrorGull(){
    int mirrorPoint = 344;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    
    for (int row = 235; row < 320; row++)
    {
      for (int col = 238; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row + 10][mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  
  public void copyPart(Picture fromPic, int startRow, int startCol, int fromStR, int fromEnR, int fromStC, int fromEnC)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = fromStR, toRow = startRow;
    toRow < toPixels.length && fromRow < fromEnR && fromRow < fromPixels.length;
    fromRow++, toRow++)
    {
      for (int fromCol = fromStC, toCol = startCol;
      toCol < toPixels[0].length && fromCol < fromEnC && fromCol < fromPixels[0].length;
      fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  public void myCollage(){
    Picture moonSurface = new Picture("moon-surface.jpg");
    Picture whiteFlower = new Picture("whiteFlower.jpg");
    this.copy(moonSurface,0,0);
    
    Picture robot = new Picture("robot.jpg");
    this.copy(robot,0,0);
    
    Picture negateFlower = new Picture("whiteFlower.jpg");
    negateFlower.negate();
    this.copyPart(negateFlower,75,0,90,270,265,460);
    
    whiteFlower.zeroBlue();
    this.copyPart(whiteFlower,250,0,90,270,265,460);
    
    robot.keepOnlyBlue();
    this.copy(robot,430,0);
    
    this.mirrorVertical();
    this.mirrorDiagonal();
    this.write("myCollage.jpg");
  }
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel currentPixel = null;
    Pixel rightPixel = null;
    Color rightColor = null;
    Pixel bottomPixel = null;
    Color bottomColor = null;
    for (int row = 0; row < pixels.length-1; row++)
    {
      for (int col = 0; col < pixels[0].length-1; col++)
      {
        currentPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        bottomPixel = pixels[row+1][col];
        bottomColor = rightPixel.getColor();
        if(currentPixel.colorDistance(rightColor) > edgeDist){
            currentPixel.setColor(Color.BLACK);
        }else if(currentPixel.colorDistance(bottomColor) > edgeDist){
            currentPixel.setColor(Color.BLACK);
        }else{
            currentPixel.setColor(Color.WHITE);
        }
      }
    }
  }
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args){}
} // this } is the end of class Picture, put all new methods before this
