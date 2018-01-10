/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nik.rsvpreader;

/**
 *
 * @author Nikhil Gupta <nikhilgupta@programmer.net>
 */
public class textRender {
    private String[] text;
    private int CurrentWord;
    private int TotalWords;
    
    /**
     * textRender(String, String) Function
     *  Reads the input and set it so that it can be used for reading purpose.
     * And cut it using the char used for splitting Default is ' '(Space).
     * @param read contains the string to be used for reading.
     * @param spliter Contains the place from where the string is to be split.
     * @throws NullPointerException If nothing provided to Read it Throws error.
     */
    textRender(String read,String spliter){
        //If Splitter is Empty the Do Nothing
        setText(read, spliter);
    }
    
    /**
     * textRender() Function
     * Reads the input and set it so that it can be used for reading purpose.
     * And cut it using the char used for splitting Default is ' '(Space).
     * It does nothing But use it carefully, We need to initialize everything First.
     */
    textRender(){};
    
    /**
     * SetText(String, String) Function
     *  Reads the input and set it so that it can be used for reading purpose.
     * And cut it using the char used for splitting Default is ' '(Space).
     * @param read contains the string to be used for reading.
     * @param spliter Contains the place from where the string is to be split.
     */
     void  setText(String read,String spliter) {
        if(spliter.isEmpty())spliter=" ";
        if(read.isEmpty())throw new NullPointerException("Nothing To Read please insert Text to Read");
        CurrentWord=0;
        text=read.split(spliter);
        TotalWords=text.length;
    }
     
     /**Gets the current position of the reading block
      * @return CurrentWord integer
      */
    int getCurrentPosition(){return CurrentWord;}
    
    /**Gets the total numbers of words in the string given to read.
     * @return TotalWords integer
     */
    int getTotal(){return TotalWords;}
    
    /**Gets the next word in the context
     * @return NextWord String
     */
    String getNext(){
        if(CurrentWord == TotalWords)throw new IndexOutOfBoundsException("Nothing Left To Return");
        return text[CurrentWord++];
    }
    
    /** Finds if the iteration Reached end*/
    boolean isEnd(){if(CurrentWord==TotalWords)return true;else    return false;}
    
    /** Restart the count for reading the string*/
    void reset(){CurrentWord=0;}
    
    /**To Reach at a Specific Position In a given String*/
    void reachAt(int curr){CurrentWord=curr;}
}
/*
    1   Need setText to be Non-Overidable

*/