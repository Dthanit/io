import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.Graphics2D;
class Animation1 extends JPanel implements Runnable
{
 boolean bite = false;
 public void run(){
 double lastTime = System.currentTimeMillis();
 double currentTime, elapsedTime;
 double startTime = System.currentTimeMillis();

 while (true) {
 currentTime = System.currentTimeMillis();
 elapsedTime = currentTime - lastTime;
 
 if (currentTime >= (startTime+1000))
 {bite = true;}
 if (currentTime - startTime >= 2000)
 {
 bite = false;
 startTime = currentTime;
 }

     repaint();
 lastTime = currentTime;

 try{
 Thread.sleep(1000/60);
 }catch(InterruptedException e){
 System.err.println(e);
 }
  }
 }
 public static void main(String[] args) 
 {
 
 Animation1 m = new Animation1();

 JFrame f = new JFrame();
 f.add(m);
 f.setTitle("First Swing");
 f.setSize(600,600);
 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 f.setVisible(true);
 (new Thread(m)).start();

 }
 //for (int i=0;i<10 ;i++ )
 public void paintComponent(Graphics g){
 Graphics2D g2 = (Graphics2D) g;
 int pic [][] = {
	             {0,0,0,5,5,5,5,0,0,0},
                 {0,0,0,5,5,5,5,0,0,0},
                 {0,0,0,5,5,5,5,0,0,0},
                 {0,0,0,0,5,5,0,0,0,0},
                 {0,5,5,5,5,5,5,5,5,0},
                 {0,0,0,0,5,5,0,0,0,0},
                 {0,0,0,0,5,5,0,0,0,0},
                 {0,0,0,5,0,0,5,0,0,0},
                 {0,0,5,0,0,0,0,5,0,0},
                 {0,5,0,0,0,0,0,0,5,0} 
				};
 
int pic2 [][] = {
	             {0,0,0,5,5,5,5,0,0,0},
                 {0,0,0,5,5,5,5,0,0,0},
                 {0,0,0,5,5,5,5,0,0,0},
                 {0,0,0,0,5,5,0,0,0,0},
                 {0,0,0,5,5,5,5,0,0,0},
                 {0,0,5,0,5,5,0,5,0,0},
                 {0,0,5,0,5,5,0,5,0,0},
                 {0,0,0,5,0,0,5,0,0,0},
                 {0,0,0,5,0,0,5,0,0,0},
                 {0,0,0,5,0,0,5,0,0,0},
                };
   
  for (int x = 0;x<=10 ;x++ )
  {
   paint(g,pic);
   if (bite)
   {paint(g,pic2);}
  }
 }

 private void paint(Graphics g , int [][] human){
 Graphics2D g2 = (Graphics2D) g;
 for (int x=0;x<10 ;x++ )
 { for (int y=0;y<10 ;y++ )
    {   if (human[y][x] == 5)
         { g.setColor(Color.RED);
               g2.fillRect((50*x)+1,(50*y)+1,50,50);
         }
 else
     { g.setColor(Color.BLUE);
               g2.fillRect((50*x)+1,(50*y)+1,50,50);
 } 
    }
 }

 
 
 
 

 
 
 }
}