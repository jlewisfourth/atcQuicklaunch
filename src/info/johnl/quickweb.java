package info.johnl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

public class quickweb {
    private JButton vrc;
    private JPanel mainPanel;
    private JButton vERAMButton;
    private JButton settingsButton;
    private JButton vStarsButton;
    private JButton vAtisButton;
    private JButton airnavButton;
    private JTextField prefferredAirportText;

    // Sets all default install locations

    String userprofile = System.getenv("USERPROFILE");
    String vrcPath = "C:\\Program Files (x86)\\VRC\\VRC.exe";
    String vStarsPath = "C:\\Program Files (x86)\\vSTARS\\vSTARS.exe";
    String vEramPath = userprofile + "\\AppData\\Local\\vERAM\\vERAM.exe";
    String vAtisPath = userprofile + "\\AppData\\Local\\vATIS\\vATIS.exe";


    public quickweb() {

        //Action events when VRC Option pressed
        vrc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openExe(vrcPath);
                //TODO Pull from the file selector path
            }
        });

        //Action events when vStars Option pressed
        vStarsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openExe(vStarsPath);
                //TODO Pull from the file selector path
            }
        });

        //Action events when vERAM Option pressed
        vERAMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openExe(vEramPath);
                //TODO Pull from the file selector path
            }
        });

        //Action events when vATIS Option pressed
        vAtisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openExe(vAtisPath);
                //TODO Pull from the file selector path
            }
        });

        //Action events when Airnav Option pressed
        airnavButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Grabs 4 letter ICAO string from text box
                String airportSelection = prefferredAirportText.getText();
                openWebsite("http://www.airnav.com/airport/" + airportSelection);

            }
        });

        //Action events when Settings Option pressed
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.openSettings();
            }
        });

    }

    // Defines openEXE
    static void openExe(String url){
        try {
            Runtime runTime = Runtime.getRuntime();
            Process process = runTime.exec(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Defines openWebsite
    static void openWebsite(String url) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (Exception e){

            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new quickweb().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
