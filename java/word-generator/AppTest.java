
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
/**
 * THIS CLASS CONTAINS THE MAIN METHOD TO EXECUTE 
 * OUR WORD GENERATOR  PROGRAM
 * @author Hassan Mugabo - @codeparl on github
 */
public class AppTest {

    public static void main(String[] args) {

        String lookAndFeel = "Windows";
        setLookAndFeel(lookAndFeel);
        SwingUtilities.invokeLater(()->{
            initWindow();
        });

    }//end main method 


 private static  void setLookAndFeel(String lookAndFeel){
  //get installed look-and-feel
  LookAndFeelInfo[]  lookAndFeelInfo = 
  UIManager.getInstalledLookAndFeels();
  try {
      for (LookAndFeelInfo info : lookAndFeelInfo) {
          if(lookAndFeel.equalsIgnoreCase(info.getName())){
              UIManager.setLookAndFeel(info.getClassName());
              break;
          }
      }
  } catch (Exception e) {
      e.printStackTrace();
  }
    }

    private static void initWindow() {
        String title = "Word Generator -  CodeParl";
        JFrame appFrame = new JFrame(title);

        // make sure our app is closable by clicking the
        // close button
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // use our AppGuI class as the content pane
        // of this window
        appFrame.setContentPane(new AppGuI());

        // set the size and location on screen
       // appFrame.setSize(550, 320);
       appFrame.pack();
       appFrame.setResizable(false);
        // center the window on screen
        appFrame.setLocationRelativeTo(null);

         

        // show the app on screen
        appFrame.setVisible(true);

    }

}
