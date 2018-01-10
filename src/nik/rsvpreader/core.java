//<editor-fold desc="All Declaration and imports">
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nik.rsvpreader;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JSlider;
/**
 *
 * @author Nikhil Gupta <nikhilgupta@programmer.net>
 */

/**
 *Class that handles all the main function of the program's.
*/
public final class core {
    private final  JLabel label;
    private final Timer display;
    private ActionListener listener;
    private int wordsPerMinute;
    private int chunkSize;
    private Font selectedFont;
    private JSlider slider;
    private textRender myReader;
    public enum State{Stopped,Running,Paused,Exception}
    private State setState;
    //</editor-fold>
    /**
     * Initialize a JLabel as a Timer Label for speed reading.
     * @param getLabel gets the label to which we have to display the Value.
     */
    core(JLabel getLabel,JSlider sld){
        label=getLabel;
        slider=sld;
        initListener();
        display=new Timer(200, listener);
        setChunkSize(1);setWordsPerMinute(300);setFont(getLabel.getFont());
        myReader = new textRender();
    }
    void setWordsPerMinute(int word){wordsPerMinute=word;display.setDelay(1000/(wordsPerMinute/60));}
    void setChunkSize(int size){chunkSize=size;}
    void setFont(Font fnt){selectedFont=fnt;label.setFont(fnt);}
    void setString(String s){myReader.setText(s, " ");slider.setMaximum(s.split(" ").length);}
    int getWordsPerMinute(){return wordsPerMinute;}
    String getWordat(int place){myReader.reachAt(place);return myReader.getNext();}
    int getChunkSize(){return chunkSize;}
    Font getFont(){return selectedFont;}
    private void initListener(){listener = (ActionEvent e) -> {
            if(myReader.isEnd())setState=State.Stopped;
            if(setState==State.Stopped){stop();}
            if(setState==State.Running)label.setText("");
            for(int i=0;i<chunkSize;i++){
                if(setState==State.Stopped || myReader.isEnd()){setState=State.Stopped;stop();break;}
                if(setState==State.Running)label.setText(label.getText()+" "+myReader.getNext());
                slider.setMaximum(myReader.getTotal());
            }
            slider.setValue(myReader.getCurrentPosition());
        };}
    void stop(){display.stop();myReader.reset();setState=State.Stopped;slider.setValue(0);}
    void restart(){if(display.isRunning())display.stop();myReader.reset();display.start();setState=State.Running;}
    void start(){setState=State.Running;display.start();}
    void pause(){setState=State.Paused;display.stop();}
    State getState(){return setState;}
}