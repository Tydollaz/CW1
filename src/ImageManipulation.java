/**
 * 
 * Time-stamp: <2019-01-10 16:31:16 rlc3>
 * 
 * ImageManipulation.java 
 *
 * Class allows the manipulation of an image by 
 * three alternative methods.
 *
 * @author Roy Crole
 * 
 */

import java.awt.image.*;
import java.awt.*;
import java.util.*; 

public class ImageManipulation {

/* ----- template code commented out BEGIN     

    // linear transformation to compute prei from i
    // O D and P are points on a line with i between D and P 
    static double linTrans (double O, double D, double i, double P) {
	double prei = // ?? 
	    // ?? 
    }

----- template code commented out END */

/* ----- template code commented out BEGIN         
    
   // take a cartesian coordinate (I,J) assumed to be in the positive octant OGV
   // and compute (preI, PreJ) returned as elements pre[0] pre[1] of pre 
    static int[] octlinTrans (int O, int D, int I, int J, int size) { 
   	  		   
	            // we will compute preI and preJ and return them in pre 
		    int [] pre = ?? 

		    // compute d from I and J 
		    double d = ?? 
		    
		    // calculate P (from theta, itself from I and J) 
		    ?? 

		    // compute pred from O, D, d, p
		    double pred = linTrans(??);

		    // now compute pre ....
		    // ?? 

		    return pre;

	  } // end octlinTrans

----- template code commented out END */

// ---- BEGIN linearBox 

    static public void linearBox(BufferedImage image, int n, int x, int y, int size) {
					 
       BufferedImage temp = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
       (temp.getGraphics()).drawImage(image, 0, 0, image.getWidth(), image.getHeight(),null);

       int I,J,X,Y;

// ----- template code commented out BEGIN     

// check if A(x,y) lies within image
if (x >= 0 && x < image.getWidth()) {
	if(y >= 0 && y < image.getHeight()) {
// loop visiting each pixel p at coordinate (i,j) in A(x,y) 
		
   for (int i=x-size;i<x+size;i++) {
	   for(int j=y-size;j<y+size;j++) {  // <---- start a for loop for j here 
       // now apply IMGTRANS as per instructions 
                  
//	       I=i;
//	       J=-j;
//	       X=x;
//	       Y=-y;
//	       
//	       x=I-X;
//	       y=J-X;
		   
		 // set values for O, D, P
		 int O = x - size;
		 int D = x + n;
		 int P = x + size;
		 
		 
		 // ensure that D lies between O and P (as n varies)
		 if(D <= P && D >= O) {
			 
		 }
		// if n too large restrict D to P
		 else if (D>P){
			 D=P;
		 }

		 // spinner box allows n < 0; if so, reset n to 0
		 if(n<0) n=0;

		 // check IF i is between D and P
		 // if so compute prei
		 int prei;
		 if( i >= D && i <= P) {
			prei = i - size;
		
			int prep = temp.getRGB(prei, j);
			image.setRGB(i,j, prep);
			 System.out.println("hmm");
		 }
		 else {
			 image.setRGB(i,j , 0xaaaaaa);
			
		 }
		
		
		 // and hence get the prep pixel RGB and set the p pixel RGB
		 
		 // IF not make pixel (i,j) grey with 0xaaaaaa

		 
          // <--- end forLoop j here 
   	} // end forLoop i
    } // end check that A(x,y) is in image 


	}
}
}// end method linearBox

// ---- END linearBox

// ---- BEGIN linearOct

    static public void linearOct(BufferedImage image, int n, int x, int y, int size) {
					 
	BufferedImage temp=new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        (temp.getGraphics()).drawImage(image, 0, 0, image.getWidth(), image.getHeight(),null);

/* ----- template code commented out BEGIN     

// check if A(x,y) lies within image
if (??) {
// loop visiting each pixel in A(x,y) at image coordinate (i,j) 
   for (??) {
   for (??) {
       // Apply IMGTRANS to each line ODP specified by an (i,j): 
		     
		    // a list to store preI and preJ as element 0 and 1 
		    // pre is calculated below using octlinTrans
		    int [] pre = new int[2];
		    int preI; 
		    int preJ;

		    // convert image coordinates (i,j) to cartesian coordinates 
		    //  .... for example mouse position (x,y) is converted to (x,-y)
       	    	    // then move the mouse position to the origin (0,0) and 
		    // ... translate all other positions relatively ...
		    // so that you now work with A(0,0) in cartesian coordinates 
		    // I and J below are relative cartesian coordinates 
		    // note: Cart Coord -j moves up (ie - ) by an amount -y  
                    int I = ??
		    int J = ??

	            // set d = distance of origin to (I,J)
        	    ??

		    // if (I,J) is outside the circle of radius size/3
		    // then we compute (preI, preJ) from (I,J) using octlinTrans
		    int radius = ??
		    if (??) { // radius test 
		     // perform linear transformation in octant OGV 
		     // 0 < J < I
         	     if (??) {
                       pre = ?? // use octlinTrans
		       preI = ??; preJ = ??;}
		     // perform linear transformation in octant OVH 
		     // 0 < -J < I 
		     else if (??) {??}
		     // perform linear transformation in octant OKU 
		     ?? 
		     // perform linear transformation in octant OUF
		     ?? 
		     // identity transformation elsewhere (outside the circle) 
		     else { 
			 preI = I; ?? } // end nested if statements

       	    	    // transform relative cartesian coordinate (preI,preJ) 
		    // back to image coordinate (prei,prej) 
		    ??

		    // set RGB of pixel at (i,j) to RGB from (prei,prej)
		    ??

		    } // matches radius test 
		    else { 
	      	       // what if we are inside the circle? 
		       ?? } // end if  

	} // end forLoop j
       	} // end forLoop i
    } // end check that A(x,y) is in image 

----- template code commented out END */

 } // end method linearOct 

// ---- END linearOct

// ---- BEGIN phaseShift 

    static public void phaseShift(BufferedImage image, int n, int x, int y, int size) {

	// creates a copy of the image called temp
        BufferedImage temp=new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        (temp.getGraphics()).drawImage(image,0,0,image.getWidth(), image.getHeight(),null );

/* ----- template code commented out BEGIN 

	// loop through each pixel (i,j) in "A(x,y) intersect (image - boundary)"
	for (int i = ??; i<= Math.min(image.getWidth()-1-2*n, ??); ++i) {

  // *****************************************************************************
  // ?? the rest of your code goes here: a loop for j, plus remainder of your code
  // *****************************************************************************

	} // end loop i 

   ----- template code commented out END */

 } // end method phaseShift 

// ---- END phaseShift 

} // ImageManipulation