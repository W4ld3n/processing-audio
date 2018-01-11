package w4ld3n.audiotools.visual;

import processing.core.*;
import ddf.minim.*;


public class OutVisualizer{
  PApplet parent;
  AudioOutput out;

  public OutVisualizer(PApplet parent, AudioOutput out){
    this.parent = parent;
    this.out = out;
  }

  public void render(){
    // erase the window to black
 parent.background( 0 );
 // draw using a white stroke
 parent.stroke( 255 );
 // draw the waveforms
 for( int i = 0; i < out.bufferSize() - 1; i++ )
 {
   // find the x position of each buffer value
   float x1  =  parent.map( i, 0, out.bufferSize(), 0, parent.width );
   float x2  =  parent.map( i+1, 0, out.bufferSize(), 0, parent.width );
   // draw a line from one buffer position to the next for both channels
   parent.line( x1, 50 + out.left.get(i)*50, x2, 50 + out.left.get(i+1)*50);
   parent.line( x1, 150 + out.right.get(i)*50, x2, 150 + out.right.get(i+1)*50);
 }
  }
}
