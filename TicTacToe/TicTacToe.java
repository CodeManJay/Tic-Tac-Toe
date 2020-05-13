
//DONE BY- AM.EN.U4CSE17328
//SREENIVAS JAYANTH YADHATI
//S3 CSE-D
//(2018) ALL TRADEMARKS AND COPYRIGHTS RESERVED :P


import java.util.*;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 
import java.awt.Graphics;
import java.awt.Graphics2D;

public class TicTacToe extends JPanel implements ActionListener{

	  //use 2d arrays for x and o
	  int[][]xoarray = new int[3][3];
	  int x,y;
	  
	  
	  //player names
	  String p1="Player 1", p2="Player 2";	                                         
  boolean player1, player2; 
        //win counter
  int winner = -1 , player1win=0,  player2win=0; 
  
  //number 1 used for x
  //number 2 used for o
	JButton ok=new JButton("Done");
	JPanel j2=new JPanel();
	
	
	//sets textfields for name changing
	JTextField t1=new JTextField(50);
	JTextField t2=new JTextField(50);


  
  JLabel turn = new JLabel();
 
  JMenu menu;  
  
  JMenuItem i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,ia,ib,ic,id,ie,iff,ig,resetButton;
  
  
  //set the color using the RGB components
  Color back=new Color(255,255,255);
  Color fore=new Color(0,0,0);
  Color temp=new Color(0,0,0);
  
  //using constructor
  

  public TicTacToe(JFrame f){
    setBackground(back);
     player1 = true;
    player1win = 0;
    player2win = 0;
    
   
   add(turn);
  
   
 
     //adding menu bar
   JMenuBar mb=new JMenuBar(); 
   
   menu=new JMenu("Settings");  
      
   //create main menu
   menu.addActionListener(this);
  
   i1=new JMenu("Foreground color");  
   i1.setToolTipText("Change the theme of the Letters and the 3x3 grid");
   
   
   i2=new JMenu("Background color");
   i2.setToolTipText("Change the theme of the background");
   
   
   i3=new JMenuItem("Change names");
   i3.setToolTipText("Change The player names");
   resetButton=new JMenuItem("RESET");
   i4=new JMenuItem("Black");  
   i5=new JMenuItem("White");  
   i6=new JMenuItem("Black");
   i7=new JMenuItem("White");
   i8=new JMenuItem("Red");
   i9=new JMenuItem("Red");
   i10=new JMenuItem("Light blue");
   ia=new JMenuItem("Light blue");
   ib=new JMenuItem("green");
   ic=new JMenuItem("green");
   id=new JMenuItem("yellow");
   ie=new JMenuItem("yellow");
   iff=new JMenuItem("grey");
   ig=new JMenuItem("grey");
   
   menu.add(i1);
   menu.add(i2); 
   menu.add(i3);  
   menu.add(resetButton);
  
  
   mb.add(menu);  
  f.setJMenuBar(mb);
  
  
 i1.add(i4);
 i1.add(i5); 
 i1.add(i8);
 i1.add(i10);
 i1.add(ib);
 i1.add(id);
 i1.add(iff);
 
 i2.add(i6);
 i2.add(i7);
 i2.add(i9);
 i2.add(ia);
 i2.add(ic);
 i2.add(ie);
 i2.add(ig);
 
 resetButton.addActionListener(this);
 i3.addActionListener(this);
  i4.addActionListener(this);
  i5.addActionListener(this);
  i7.addActionListener(this);
  i6.addActionListener(this);
  i8.addActionListener(this);
  i9.addActionListener(this);
  i10.addActionListener(this);
  
  ia.addActionListener(this);
  ib.addActionListener(this);
  ic.addActionListener(this);
  id.addActionListener(this);
  ie.addActionListener(this);
iff.addActionListener(this);
 ig.addActionListener(this);
	
 
 
 
    //MouseListener implements the click
   //invokes XOClick class
   XOClick xo= new XOClick();
    addMouseListener(xo); 
 
    
    
  }

  
   
    public void actionPerformed(ActionEvent e) {
    	
    	if(e.getSource()==resetButton) {
    		
        reset(); //resets 
        //the repaint method applies the changes made on the panel
       repaint();
     }   

    	if(e.getSource()==i3) {
    		
    		  
    		  //this constructor creates a frame with textfields for changing the names
    	
    		  
    		  JFrame f2=new JFrame("Change Names");
    			
    			f2.setSize(400,250);
    		  

    			
    			t1=new JTextField(100);
    			t2=new JTextField(100);
    			t1.setBounds(100,0,200,50);
    			t2.setBounds(100,50,200,50);
    			ok.setBounds(135,100,140,110);
    			j2.setVisible(true);
    			j2.setLayout(null);
    			j2.add(t1);
    			t1.setText(p1);
    			
    			t2.setText(p2);
    			j2.add(t2);
    			j2.add(ok);
    			ok.addActionListener(this);
    			
    			f2.add(j2);
    			f2.setVisible(true);

    		
    	} 
    	
    	
    	
    	
    	//based on the menu item clicked the foreground/background color will be changed
    	
    	//only applies changes if foreground and background are of different color... otherwise no change
    	if(e.getSource()==i4) {
    		
    		temp=new Color(0,0,0);
    		if(!temp.equals(back)) {
    			fore=temp;
    	    	 repaint();
    		}
    	}
    	
    	
    	if(e.getSource()==i5) {
    		
    		temp=new Color(255,255,255);
    		if(!temp.equals(back)) {
    			fore=temp;
    	    	 repaint();
    		}
    	}
    	
    	
    	if(e.getSource()==i6) { 
    		temp=new Color(0,0,0);
    		if(!temp.equals(fore)) {
    			back=temp;
    	    	 repaint();
    		}
    		
    	
    	}
    	
    	
    	if(e.getSource()==i7) {
    	temp=new Color(255,255,255);
    	if(!temp.equals(fore)) {
			back=temp;
	    	 repaint();
		}
		
    	}
    	
    	if(e.getSource()==i8) {
    		
    		temp=new Color(255,0,0);
    		if(!temp.equals(back)) {
    			fore=temp;
    	    	 repaint();
    		}
    		
    		
    	}
    	
    	
    	if(e.getSource()==i9) {
    		
    		temp=new Color(255,0,0);
    		if(!temp.equals(fore)) {
    			back=temp;
    	    	 repaint();
    		}
    		
    	}
    	
    	
    	if(e.getSource()==i10) {
    		
    		temp=new Color(51,153,255);
    		if(!temp.equals(back)) {
    			fore=temp;
    	    	 repaint();
    		}
    		
    		
    	}
    	
    	
    	if(e.getSource()==ia) {
    		
    		temp=new Color(51,153,255);
    		if(!temp.equals(fore)) {
    			back=temp;
    	    	 repaint();
    		}
    	
    	}
    	
    	
    	if(e.getSource()==ib) {
    		
    		temp=new Color(0,255,0);
    		if(!temp.equals(back)) {
    			fore=temp;
    	    	 repaint();
    		}
    	
    	}
    	
    	
    	if(e.getSource()==ic) {
    		
    		
    		temp=new Color(0,255,0);
    		if(!temp.equals(fore)) {
    			back=temp;
    	    	 repaint();
    		}
    		
    	}
    	
    	
    	if(e.getSource()==id) {
    		
    		temp=new Color(255,255,0);
    		if(!temp.equals(back)) {
    			fore=temp;
    	    	 repaint();
    		}
    	
    	
    	}
    	
    	
    	if(e.getSource()==ie) {
    		
    		temp=new Color(255,255,0);
    		if(!temp.equals(fore)) {
    			back=temp;
    	    	 repaint();
    		}
    		
    	}
    	
    	
    	if(e.getSource()==iff) { 
    		
    		temp=new Color(153,153,153);
    		if(!temp.equals(back)) {
    			fore=temp;
    	    	 repaint();
    		}
    	}
    	
    	
    	
    	if(e.getSource()==ig) {
    		
    		temp=new Color(153,153,153);
    		if(!temp.equals(fore)) {
    			back=temp;
    	    	 repaint();
    		}
  
    }   
    	
    	if(e.getSource()==ok) {
    	p1=t1.getText();
    	p2=t2.getText();
    	repaint();
    }
    	
    	
   }
  
  
   

  //matchStatus() method checks for winners
  public int matchStatus(){
	  
    //if whole column is same..then winner is returned
	  
	  
 
    for(int i=0;i<3;i++){
      
      if((xoarray[i][0]== xoarray[i][1]) && (xoarray[i][1] == xoarray[i][2]))
        winner = xoarray[i][0];
       
      
    }
 
     //if whole row is same..then winner is returned
    for(int i=0;i<3;i++){
    	
    	  if((xoarray[0][i]== xoarray[1][i]) && (xoarray[1][i] == xoarray[2][i]))
    	       
    	  winner = xoarray[0][i];
      
    }
    
    
    //check diagonal 1
    
    
      if((xoarray[0][0] == xoarray[1][1]) && (xoarray[1][1] == xoarray[2][2]))
     
    	  
       winner = xoarray[1][1];

  
      
     //check diagonal 2
    
      
       if((xoarray[0][2] == xoarray[1][1]) && (xoarray[1][1] ==xoarray[2][0]))
    	   
         winner = xoarray[2][0]; 
         
       
       return winner;
       
    }
  
  
  //paintComponent method does the drawing and graphics
  public void paintComponent (Graphics gra){
	  
	//important line
    super.paintComponent(gra); 

    setBackground(back);
      turn.setForeground(fore);
      Font font=new Font("Ariel",Font.BOLD,30);
      turn.setFont(font);
    if(player1 == true){
      turn.setText(p1+"'s turn");
    }else{
      turn.setText(p2+"'s turn");
    }
 
    
    //the board is created using drawLine()method
    
    gra.setColor(fore);
    
    //invoking 2D graphics..it cannot be invoked by a regular call
    Graphics2D g2 = (Graphics2D) gra;
    
    //setting the thickness of the line using BasicStroke() method
    g2.setStroke(new BasicStroke(5));
    g2.setColor(fore);
    
    
    //coordinates of the panel to set the bars
    int xcoor=490;
    int ycoor=320;
 
    //horizontal lines at proper coordinates
   g2.drawLine(xcoor,ycoor ,xcoor+300,ycoor);
    g2.drawLine(xcoor,ycoor + 100,xcoor+300,ycoor+100);
    
    
    //vertical lines at proper coordinates
    
    xcoor=590;
    ycoor=220;
    
    g2.drawLine(xcoor,ycoor ,xcoor,ycoor+300);
    g2.drawLine(xcoor+ 100,ycoor ,xcoor+100,ycoor+300);

    //Font sets the font style, size and type
    Font f=new Font("Ariel", Font.BOLD, 60);
    
    //prints X and O
    for(int x=0;x<3;x++){
      for(int y=0;y<3;y++){
        if(xoarray[x][y]==1){   // X is drawn 
        	
          //X is printed based on the areas clicked by modifying the mouse coordinates on line 104
       
          gra.setFont(f);
          gra.drawString("X",515+105*x,300 + 98*y);
          
        }
        else if(xoarray[x][y]==2){  // O is drawn
           
        	
        	  //X is printed based on the areas clicked by modifying the mouse coordinates on line 104
            gra.setFont(f);
            gra.drawString("O",515+102*x,300 + 95*y);
            
          }
        
        }
      
      }
   
    
    //prints the winner
    gra.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 45));
    gra.setColor(fore);
    
    
    if(matchStatus() == 1){
      gra.drawString(p1+"(X) WINS!",450,600);
      
    }
    
    else if(matchStatus() == 2){
       gra.drawString(p2+"(O) WINS!",450,600);
       
    }
    
    else if(matchDraw() == true){
      gra.setFont(new Font("TIMES NEW ROMAN", Font.ITALIC, 45));
      gra.drawString("IT'S A DRAW!",450,600);
  
    }
    
    //display player scores
    gra.setFont(new Font("Helvetica", Font.BOLD, 35));
     gra.setColor(fore);
     
    //player1
    gra.drawString(p1,300,150);
    //shows the string in the given font at the coordinates
    gra.drawString(  player1win + " wins",275,400);
    
    //Player 2
    gra.drawString(p2,900,150);
    gra.drawString( player2win + " wins",875,400);
    
    ///draws figures representing players
    // draws O
     x=0;
     y=0;
     xcoor=920;
     ycoor=105;
     gra.setFont(new Font("Ariel", Font.BOLD, 60));
     gra.drawString("O",xcoor,ycoor);
     
     //draws X
     x=0;
     y=0;
     xcoor=320;
     ycoor=100;
     
     gra.setFont(new Font("Ariel", Font.BOLD, 60));
     gra.drawString("X",xcoor,ycoor);

  }
  
  //reset method
  public void reset(){
    //clears the game xoarray - resets  the array
    //sets everything to 0, player1 to true
    for(int i=0;i<3;i++){
      for(int j=0;j<3;j++){
        xoarray[i][j]=0;
      }
    }
    winner =-1;
    player1 = true;
  }
  
  //matchDraw
  public boolean matchDraw(){
    boolean completed = true;
    for(int i=0;i<3;i++){
      for(int j=0;j<3;j++){
        if(xoarray[i][j] == 0){
          completed = false;
        }
      }
    }
    
      return completed;
  }
   
 
  
  //mouse events
   class XOClick implements MouseListener{
    
    // mouse events are implemented
    public void mousePressed(MouseEvent e){
    	
    	//System.out.println("mouse pressed");
    	
    }
    
    public void mouseReleased(MouseEvent e){
    	
    	//System.out.println("released");
    	
    }
    
    public void mouseEntered(MouseEvent e){
    	
    	//System.out.println("mouse entered");
    	 
    }
    
    public void mouseExited(MouseEvent e){
    	
    	//System.out.println("mouse exited");
    	
    }
     
    
    public void mouseClicked(MouseEvent e){
  
    	//proceeds if match is still continuing
    	  if(matchStatus()<=0){
        
        //get mouse click coordinates
        //if matchStatus()!=1 || !=2 then game is still going on
        int i = e.getX();
        
        int j = e.getY();
   
        //checks if mouse click is out of bounds
        //if mouse click is out of bounds then there will be no change in the panel content
      
        if((i<500) || (j<200) || (i>780) || (j>510))   
          repaint();              
  
        //here based on the coordinates at which mouse is clicked clicked,
        //, the values will be appended to the corresponding array element
        else if(i>500 && i<580)
          x=0;
        else if(i>600 && i<680)
          x=1;
        else if(i>700 && i<780)
          x=2;
        
        if(j>225 && j<310)
          y=0;
        else if(j>325 && j<410)
          y=1;
        else if(j>425 && j<510)
          y=2;
        
        //the xoarray is occupied so click somewhere on the xoarray that has not been clicked yet
        if(xoarray[x][y]== 1 || xoarray[x][y]==2)  
              repaint();
        else{
          if(player1 == true)
            xoarray[x][y]= 1;
          
          if(player1 == false) 
            xoarray[x][y]=2;
          
        }
        }
      //Player 1 won
        if(matchStatus() == 1 ) {
         player1win++;
    
        }
        //Player 2 won
        else if(matchStatus() == 2) {
         player2win++; 
        
        }
        
        //Match draw
        else if(matchDraw() == true) {
        	repaint();
       }
        
          else { 
        	  //alternate turns
          if(player1 == true){ 
            turn.setText(p2 +"'s turn");
            player1=false;
          }
          
          else{
            turn.setText(p2+"'s turn");
            player1=true;
          }
          }
        //applies the changes
        repaint();
                    
        
      }
    
    
    } 
    
   
   
//driver
  public static void main(String[]args){
    
    JFrame frame = new JFrame("TicTacToe");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
   
    frame.setSize(1100,600);
    
     //setExtendedState() maximizes the JFrame automatically
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    TicTacToe p=new TicTacToe(frame);
    
    frame.add(p);
   
    frame.setVisible(true);  
   
  }
  
}
