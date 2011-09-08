
import example.MainPanel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

public class StartFrame extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new StartFrame();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(StartFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(StartFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(StartFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(StartFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public StartFrame() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        final JLabel label = new JLabel("Hello Encoding");
        add(label);
        pack();
        setLocationByPlatform(true);
        setVisible(true);

        /*
         * System LAF
         */
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        final JFrame frame1 = new JFrame("System LAF");
        frame1.add(new MainPanel());
        frame1.pack();
        frame1.setLocationByPlatform(true);
        frame1.setVisible(true);

        /*
         * Nimbus LAF
         */
        for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
        final JFrame frame2 = new JFrame("Nimbus LAF");
        frame2.add(new MainPanel());
        frame2.pack();
        frame2.setLocationByPlatform(true);
        frame2.setVisible(true);
    }
}
