package w4ld3n.audiotools.synth;

import ddf.minim.*;
import ddf.minim.ugens.*;

class NoiseInstrument implements Instrument
{
  // create all variables that must be used throughout the class
  Noise myNoise;
  AudioOutput out;

  // constructors for the intsrument
  NoiseInstrument( float amplitude, Noise.Tint noiseTint , AudioOutput out)
  {
    // create new instances of any UGen objects as necessary
    // white noise is used for this instrument
    myNoise = new Noise( amplitude, noiseTint );
    this.out = out;
  }

  // every instrument must have a noteOn( float ) method
  public void noteOn( float dur )
  {
    myNoise.patch( out );
  }

  // every instrument must have a noteOff() method
  public void noteOff()
  {
    // unpatch the output
    // this causes the entire instrument to stop calculating sampleframes
    // which is good when the instrument is no longer generating sound.
    myNoise.unpatch( out );
  }
}
