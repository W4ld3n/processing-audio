package w4ld3n.audiotools.io;

import ddf.minim.*;

public class LineOut {
  /**
   *
  **/
  private Minim minim;
  private AudioOutput out;

  public LineOut() {
    minim = new Minim( this );
    out = minim.getLineOut( Minim.MONO );
  }

  public AudioOutput init(){
    return out;
  }

}
