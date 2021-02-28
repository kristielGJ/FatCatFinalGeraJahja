package game;

import city.cs.engine.SoundClip;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AudioControl {
    private JPanel pnlControls;
    private JLabel lblVolume;
    private JSlider sldVolume;
    private JButton btnMute;

    public AudioControl(){
        btnMute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FatCat.getMusic().setVolume(0.0001f);//mute volume of background music
                sldVolume.setValue(1);//changes position of volume slider
            }
        });

        sldVolume.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                float volume=scale((float)sldVolume.getValue(),
                        1.0f,10.0f,0.0001f,2.0f);
                FatCat.getMusic().setVolume(volume);
            }
        });

    }
/**
 *the scale method ensures that the volume does not exceed
 * over 2 or go under 0. it calculates a volume level depending
 * on the position of the slider GUI
 */

    private float scale( float value,float minInput,
                         float maxInput,float minRange,
                         float maxRange) {
        return ((maxRange-minRange)*(value-minInput)/(maxInput-minInput))+minRange;//to ensure 1 wont map to 0 (volume is a log value in city engine)
    }

    public JPanel getPnlControls(){
        return pnlControls;
    }
}
