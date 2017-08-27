/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buddhibrowser2_1;

//import static buddhibrowser2_1.BuddhiBrowser2.grid;
//import static buddhibrowser2_1.BuddhiBrowser2.tab2;
import static buddhibrowser2_1.BuddhiBrowser2.check;
import static buddhibrowser2_1.BuddhiBrowser2.tabs;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.web.PopupFeatures;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.swing.JOptionPane;

/**
 *
 * @author Buddhi Kavindra
 */
public class tabBrowser extends GridPane {

//    public static Tab tab2;
//    static GridPane grid;
//    static int i;
    public static WebView view2;
    
    public static Tab createBrowser() {

        final Tab tab2 = new Tab();
        final GridPane grid = new GridPane();

        final WebView view = new WebView();
        view.setMinSize(500, 400);
        view.setPrefSize(500, 400);
        final WebEngine eng = view.getEngine();
//        view.setContextMenuEnabled(false);
        view2 = new WebView();
        eng.setCreatePopupHandler(
                new Callback<PopupFeatures, WebEngine>() {
                    @Override
                    public WebEngine call(PopupFeatures config) {
                        tabBrowser tbb = new tabBrowser();
                        tabs.getTabs().add(tbb.createBrowser());
                        return view2.getEngine();
                    }
                }
        );
        
        
//        eng.load("https://www.facebook.com");
//        final Label warningLabel = new Label("New Tab");
        final TextField locationField = new TextField();
        locationField.setMaxHeight(30);
        locationField.focusedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue ov, Boolean t, Boolean t1) {

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    if (locationField.isFocused() && !locationField.getText().isEmpty()) {
                        locationField.selectAll();
                    }
                }
            });
        }
    });

        if (check == true) {
            locationField.setText("https://www.google.com/");
            eng.load("https://www.google.com/");
            check = false;
        } else if (!view2.equals(null)) {
//            eng.load(BuddhiBrowser2.urls);
            view2.getEngine().locationProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                eng.load(newValue);
                
            }
        });
//            view2 = null;
        }

        Button goButton = new Button();
        goButton.setGraphic(new ImageView(new javafx.scene.image.Image("/buddhibrowser2_1/go-btn.png", 25, 25, true, true)));
        goButton.setTooltip(new Tooltip("Load Website"));
        
        final Button backButton = new Button();
        backButton.setGraphic(new ImageView(new javafx.scene.image.Image("/buddhibrowser2_1/back.png", 25, 25, true, true)));
        backButton.setTooltip(new Tooltip("Go Back"));
        
        final Button frontButton = new Button();
        frontButton.setGraphic(new ImageView(new javafx.scene.image.Image("/buddhibrowser2_1/forward.png", 25, 25, true, true)));
        frontButton.setTooltip(new Tooltip("Go Forward"));
        
        Button oraclebtn = new Button();
        oraclebtn.setGraphic(new ImageView(new javafx.scene.image.Image("/buddhibrowser2_1/new-tab.png", 25, 25, true, true)));
        oraclebtn.setTooltip(new Tooltip("Add New Tab"));
        
        final ProgressIndicator progress = new ProgressIndicator();
        progress.setPrefHeight(40);

        Button googlebtn = new Button("Google");
        Button buddhibtn = new Button("Buddhilive");
        

        googlebtn.setGraphic(new ImageView(new javafx.scene.image.Image("/buddhibrowser2_1/google.png", 25, 25, true, true)));
        buddhibtn.setGraphic(new ImageView(new javafx.scene.image.Image("/buddhibrowser2_1/buddhilive.png", 25, 25, true, true)));
        

//        final SplitMenuButton smb = new SplitMenuButton();
//        smb.getItems().addAll(new MenuItem(null, wiki5btn),new MenuItem(null, wiki6btn),new MenuItem(null, wiki7btn),new MenuItem(null, wiki8btn),
//                new MenuItem(null, wiki9btn));
//        smb.setText("More Wiki");
//        smb.getSelectionModel().selectFirst();
        
        ToolBar tolb = new ToolBar(backButton, frontButton, googlebtn, buddhibtn);

//        goButton.setStyle("-fx-base: #199900;");
//        goButton.setGraphic(new ImageView(new javafx.scene.image.Image("/buddhibrowser2_1/play.png" , 20, 20, true, true)));
//        backButton.setStyle("-fx-font: bold 13 arial; -fx-base: #1B58B8;");
//        backButton.setGraphic(new ImageView(new javafx.scene.image.Image("/buddhibrowser2_1/back.png" , 15, 15, true, true)));
//        frontButton.setStyle("-fx-font: bold 13 arial; -fx-base: #1B58B8;");
//        frontButton.setGraphic(new ImageView(new javafx.scene.image.Image("/buddhibrowser2_1/next.png" , 15, 15, true, true)));
//        jnet.setStyle("-fx-base: #E66D1A;");

//        oraclebtn.setStyle("-fx-font: bold 13 arial; -fx-base: #AF1D00;");
//        oraclebtn.setGraphic(new ImageView(new javafx.scene.image.Image("/buddhibrowser2_1/add.png" , 15, 15, true, true)));
        locationField.setStyle("-fx-font: 20 arial; -fx-text-fill: #B4B4B4;");

//            
//        final WebHistory history = eng.getHistory();
//        history.getEntries().addListener(new ListChangeListener<WebHistory.Entry>() {
//            @Override
//            public void onChanged(Change<? extends Entry> c) {
//                c.next();
//                for (Entry e : c.getRemoved()) {
//                    smb.getItems().remove(e.getUrl());
//                }
//                for (Entry e : c.getAddedSubList()) {
//                    smb.getItems().add(e.getUrl());
//                }
//            }
//        });
//        smb.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent ev) {
//                if (smb.getSelectionModel().getSelectedIndex() == 0) {
//                    locationField.setText("https://www.wikipedia.org/");
//                } else {
//                    locationField.setText(smb.getSelectionModel().getSelectedItem() + "");
//                }
////                int offset
////                        = smb.getSelectionModel().getSelectedIndex()
////                        - history.getCurrentIndex();
////                history.go(offset);
//            }
//        });
        EventHandler<ActionEvent> goAction = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (locationField.getText().startsWith("https://") || locationField.getText().startsWith("http://")) {
                    eng.load(locationField.getText());
                } else {
                    eng.load("http://" + locationField.getText());
                }

//                eng.load(locationField.getText().startsWith("http://") ? locationField.getText()
//                        : "http://" + locationField.getText());
//                eng.load(locationField.getText());
            }
        };
        final WebHistory history = eng.getHistory();
        EventHandler<ActionEvent> backAction = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
//                    final WebHistory history = eng.getHistory();
                    ObservableList<WebHistory.Entry> entryList = history.getEntries();
                    int currentIndex = history.getCurrentIndex();

                    Platform.runLater(new Runnable() {
                        public void run() {
                            history.go(-1);
                        }
                    });
                    eng.load(entryList.get(currentIndex > 0 ? currentIndex - 1 : currentIndex).getUrl());
                } catch (Exception e) {
//                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "No history to show!", "Error", JOptionPane.WARNING_MESSAGE);
                }

//                    eng.load(eng.executeScript("history.back()").toString());
            }
        };

        EventHandler<ActionEvent> forwardAction = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
//                    final WebHistory history = eng.getHistory();
                    ObservableList<WebHistory.Entry> entryList = history.getEntries();
                    int currentIndex = history.getCurrentIndex();

                    Platform.runLater(new Runnable() {
                        public void run() {
                            history.go(1);
                        }
                    });
                    eng.load(entryList.get(currentIndex < entryList.size() - 1 ? currentIndex + 1 : currentIndex).getUrl());
                } catch (Exception e) {
//                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "No history to show!", "Error", JOptionPane.WARNING_MESSAGE);
                }
//                    eng.load(eng.executeScript("history.back()").toString());
            }
        };

        
        tab2.setOnClosed(new EventHandler<Event>() {

            @Override
            public void handle(Event t) {
                tab2.setOnClosed(null);
                tab2.setUserData(null);
                view2 = null;
//                System.out.println(view2);
                tab2.setContent(null);
            }
        });

        goButton.setOnAction(goAction);
        backButton.setOnAction(backAction);
        frontButton.setOnAction(forwardAction);
        

        locationField.setOnAction(goAction);
        
        

        eng.locationProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.startsWith("https://upload.wikimedia.org")) {
                    Application a = new Application() {

                        @Override
                        public void start(Stage stage) throws Exception {
                            //To change body of generated methods, choose Tools | Templates.
                        }
                    };
                    a.getHostServices().showDocument(locationField.getText());
                } else {
                    locationField.setText(newValue);
                }

            }
        });

        tabs.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
                if (tabs.getSelectionModel().getSelectedIndex() == 0) {
                    tabs.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

                } else {
                    tabs.setTabClosingPolicy(TabPane.TabClosingPolicy.SELECTED_TAB);
                }
            }
        });

        progress.progressProperty().bind(eng.getLoadWorker().progressProperty());

        eng.getLoadWorker().stateProperty().addListener(
                new ChangeListener<Worker.State>() {
                    @Override
                    public void changed(ObservableValue ov, Worker.State oldState, Worker.State newState) {
                        if (newState == Worker.State.SUCCEEDED) {
                            tab2.setText(eng.getTitle());
//                            if(eng.getTitle().length()>15){
//                                tab2.setText(eng.getTitle().substring(0, 14));
//                                Tooltip toltab = new Tooltip(eng.getTitle());
//                                tab2.setTooltip(toltab);
//                            }else{
//                                tab2.setText(eng.getTitle());
//                            }
                            if (eng.getTitle().equals("Loading Fail!")) {
                                tab2.setGraphic(new ImageView(new javafx.scene.image.Image("/buddhibrowser2_1/warning.png", 15, 15, true, true)));
                            } else {
                                String imgURL = "https://plus.google.com/_/favicon?domain=" + eng.executeScript("window.location.hostname;");
                                tab2.setGraphic(new ImageView(new javafx.scene.image.Image(imgURL, 16, 16, true, true)));
                            }
                        } else if (newState == Worker.State.FAILED) {
                            String erM = "" + eng.getLoadWorker().getException().toString();
                            eng.loadContent("<title>Loading Fail!</title>"
                                    + "<h1><font color='blue'>Unable to load!</font></h1>"
                                    + "<p>Please check your internet internet connection.<br>"
                                    + "Error type: <font color='red'>" + erM + "</font>"
                                    + "</p>");

                        } else if (newState == Worker.State.RUNNING) {
                            tab2.setText("Loading...");
                            tab2.setGraphic(new ImageView(new javafx.scene.image.Image("/buddhibrowser2_1/11.gif", 15, 15, true, true)));

                        } else if (newState == Worker.State.READY) {
//                            try {
//                                if (eng.executeScript("window.location.hostname;").equals("www.youtube.com")
//                                || locationField.getText().equals("https://upload.wikimedia.org")) {
//                                    
//                                    eng.loadContent("<video controls='controls'>"
//                                            + "<source src='" + locationField.getText() + "'/>"
//                                            + "<p>Your browser does not support the video tag.<p>"
//                                            + "</video>");
//                                    System.out.println("got");
//                                }
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                                System.out.println("error");
//                            }
                        }

                    }
                });

        progress.setMaxWidth(Double.MAX_VALUE);

        EventHandler<ActionEvent> oracleAction = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

//                    eng.load("http://www.budkavin.blogspot.com");
//                Tab tab2 = new Tab("New Tab");
                tabBrowser tbb = new tabBrowser();
                tabs.getTabs().add(tbb.createBrowser());
            }
        };

        oraclebtn.setOnAction(oracleAction);

        EventHandler<ActionEvent> googleAction = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                eng.load("https://www.google.com/");
            }
        };

        EventHandler<ActionEvent> buddhiAction = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                eng.load("http://www.buddhilive.com/");
            }
        };


        buddhibtn.setOnAction(buddhiAction);
        googlebtn.setOnAction(googleAction);
        

//            GridPane grid = new GridPane();
//        grid = new GridPane();
        grid.setVgap(3);
        grid.setHgap(3);
        
        GridPane.setConstraints(progress, 0, 0);
        GridPane.setConstraints(locationField, 1, 0);
        GridPane.setConstraints(goButton, 2, 0);
        GridPane.setConstraints(oraclebtn, 3, 0);
//        GridPane.setConstraints(jnet, 2, 0);
        
        GridPane.setConstraints(view, 0, 2, 4, 1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS);
        GridPane.setConstraints(tolb, 0, 1, 4, 1, HPos.CENTER, VPos.CENTER, Priority.NEVER, Priority.NEVER);
//            GridPane.setConstraints(warningLabel, 0, 2, 7, 1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.SOMETIMES);
        grid.getColumnConstraints().addAll(
                new ColumnConstraints(40, 40, 40, Priority.NEVER, HPos.RIGHT, true),
                new ColumnConstraints(100, 100, Double.MAX_VALUE, Priority.ALWAYS, HPos.CENTER, true),
                new ColumnConstraints(40, 40, 40, Priority.NEVER, HPos.CENTER, true),
                new ColumnConstraints(40, 40, 40, Priority.NEVER, HPos.CENTER, true)
        );
        grid.getChildren().addAll(progress, locationField, goButton, oraclebtn, tolb, view);

        tab2.setText("New Tab");
//        locationField.setText("about: Blank");
        tab2.setGraphic(new ImageView(new javafx.scene.image.Image("/buddhibrowser2_1/B.png", 15, 15, true, true)));
        tab2.setContent(grid);

        return tab2;
    }

//    public static void createTab() {
//        Tab tab2 = new Tab("New Tab");
//        tabBrowser tb = new tabBrowser();
//
//        tab2.setContent(tb.createBrowser());
//        tabs.getTabs().add(tab2);
//    }
}
