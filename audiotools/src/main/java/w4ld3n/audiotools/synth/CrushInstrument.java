package w4ld3n.audiotools.synth;

import ddf.minim.*;
import ddf.minim.ugens.*;

// this CrushInstrument will play a sine wave bit crushed
// to a certain bit resolution. this results in the audio sounding
// "crunchier".
public class CrushInstrument implements Instrument
{
  Oscil sineOsc;
  BitCrush bitCrush;
  Minim minim;
  AudioOutput out;

  public CrushInstrument(float frequency, float amplitude, float bitRes, AudioOutput out)
  {
    sineOsc = new Oscil(frequency, amplitude, Waves.SINE);
    this.out = out;
    // BitCrush takes the bit resolution for an argument
    bitCrush = new BitCrush(bitRes, out.sampleRate());

    sineOsc.patch(bitCrush);
  }

  // every instrument must have a noteOn( float ) method
  public void noteOn(float dur)
  {
    bitCrush.patch(out);
  }

  // every instrument must have a noteOff() method
  public void noteOff()
  {
    bitCrush.unpatch(out);
  }
}
