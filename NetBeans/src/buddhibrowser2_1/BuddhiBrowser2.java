/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buddhibrowser2_1;

import com.sun.javafx.robot.impl.FXRobotHelper;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Buddhi Kavindra
 */
public class BuddhiBrowser2 extends JApplet {

    private static final int JFXPANEL_WIDTH_INT = 700;
    private static final int JFXPANEL_HEIGHT_INT = 500;
    private static JFXPanel fxContainer;
    public static boolean check=true;
//    public static GridPane grid;
    public static TabPane tabs;
//    public static WebView view2;
//    public static String urls;
//    public static Tab tab2;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (Exception e) {
                }

                JFrame frame = new JFrame("Buddhilive Browser 2.1 (Beta)");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JApplet applet = new BuddhiBrowser2();
                applet.init();

                frame.setContentPane(applet.getContentPane());
                frame.pack();
                frame.setIconImage(new ImageIcon(getClass().getResource("/buddhibrowser2_1/B.png")).getImage());
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                applet.start();
            }
        });
    }

    @Override
    public void init() {
        fxContainer = new JFXPanel();
        fxContainer.setPreferredSize(new Dimension(JFXPANEL_WIDTH_INT, JFXPANEL_HEIGHT_INT));
        add(fxContainer, BorderLayout.CENTER);
        // create JavaFX scene
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                tabScene();
            }
        });
    }

    private void tabScene() {
        tabs = new TabPane();
        tabBrowser tbb = new tabBrowser();
//        tbb.tab2 = new Tab("Home");
//        tbb.tab2.setContent(tbb.createBrowser());
        tabs.getTabs().add(tbb.createBrowser());

        StackPane root = new StackPane();
        root.getChildren().add(tabs);
        fxContainer.setScene(new Scene(root));
    }

//    public void createC() {
//    URI uri = URI.create("http://mysite.com");
//Map<String, List<String>> headers = new LinkedHashMap<String, List<String>>();
//headers.put("Set-Cookie", Arrays.asList("name=value"));
//java.net.CookieHandler.getDefault().put(uri, headers);
//    }

}
