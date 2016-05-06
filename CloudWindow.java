
/**
 * Description: Creates a resizable, scrollable window, in
 * which WordLabel objects can be placed.
 *
 * @author M. Allen
 * @author Erik Porzio
 * 
 */
import java.awt.*;
import java.util.*;
import javax.swing.*;

@SuppressWarnings( "serial" )
public class CloudWindow extends JFrame
{
    
    private final int WIDTH = 600;
    private final int HEIGHT = 450;
    
    /*
     * Produces window with scrollable content, displaying
     * WordLabels corresponding to contents of input list.
     *
     * @param counts List of (word, count) pairs.
     */
    public void makeWindow( LinkedList<WordCounter> counts, String title )
    {
        // create the window with scroll-bars, etc.
        setTitle( title );
        
        JPanel panel = new JPanel();
        panel.setPreferredSize( new Dimension( WIDTH, HEIGHT * 5 ) );
        panel.setBackground( Color.white );
        
        JScrollPane scroll = new JScrollPane( panel );
        scroll.setPreferredSize( new Dimension( WIDTH + 20, HEIGHT ) );
        
        setLayout( new BorderLayout() );
        getContentPane().add( scroll, BorderLayout.CENTER );
        
        WordCounter[] countArray = counts.toArray( new WordCounter[counts.size() ]);
        Arrays.sort( countArray );
        
        for( int i = 0; i < countArray.length; i++ )
        {
	        String word = countArray[i].getWord();
	        int num = countArray[i].getCount();
	        WordLabel wl = new WordLabel( word, num );
	        panel.add( wl );
        }
        
        // finish setting up window
        pack();
        setMinimumSize( new Dimension( WIDTH + 20, HEIGHT - 100 ) );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setVisible( true );
        repaint();
    }
    
    private static class WordLabel extends JLabel
    {
        private static final Color[] colors = { Color.blue, Color.red, Color.green, Color.black };
        
        /*
         * post: creates Label with randomly selected font color,
         * font size set relative to size input,
         * and getText() == s
         * and getBackground() == Color.white
         *
         * @param s Word to be displayed.
         *
         * @param size Parameter to ensure more common words appear larger.
         */
        private WordLabel( String s, Integer size )
        {
            super( s );
            setBackground( Color.white );
            setForeground( getRandomColor() );
            int fontSize = 14 + ( 12 * ( size - 1 ) );
            Font font = new Font( "Monospace", Font.PLAIN, fontSize );
            setFont( font );
        }
        
        /* post: returns 1 of 5 Color choices at random */
        private Color getRandomColor()
        {
            int cidx = (int) ( Math.random() * colors.length );
            return colors[cidx];
        }
    }
}