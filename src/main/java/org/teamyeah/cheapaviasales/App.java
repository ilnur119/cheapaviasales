package org.teamyeah.cheapaviasales;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class App extends Application {

    // application stage is stored so that it can be shown and hidden based on system tray icon operations.
    private Stage tripListWindow;

    // a timer allowing the tray icon to provide a periodic notification event.
    private Timer notificationTimer = new Timer();

    // format used to display the current time in a tray icon notification.
    private DateFormat timeFormat = SimpleDateFormat.getTimeInstance();

    public static void main(String[] args) {
        launch(args);
    }

    // sets up the javafx application.
    // a tray icon is setup for the icon, but the main tripListWindow remains invisible until the user
    // interacts with the tray icon.
    @Override
    public void start(Stage stage) {

        Platform.setImplicitExit(false);
        javax.swing.SwingUtilities.invokeLater(this::setTrayIcon);

        setupTripListWindow(stage);
    }

    private void setupTripListWindow(Stage stage) {

        this.tripListWindow = stage;

        TripListModel model = new TripListModel();
        model.setTripModels(FXCollections.observableArrayList(
                new TripModel("Ульяновск", "Москва", LocalDate.now(), LocalDate.now().plusDays(1), 5678),
                new TripModel("Москва", "Берлин", LocalDate.now(), LocalDate.now().plusDays(2), 16723),
                new TripModel("Москва", "Берлин", LocalDate.now(), LocalDate.now().plusDays(2), 12723)
        ));

        TripList root = new TripList();
        root.setTrips(model.getTripModels());

        Scene scene = new Scene(root, 550, 500);

        stage.setTitle("Рейсы");
        stage.getIcons().addAll(new Image("/images/icon128.png"), new Image("/images/icon16.png"));
        stage.setScene(scene);
        stage.setOnCloseRequest(event -> stage.hide());

        stage.setScene(scene);
        stage.show();
    }

    /**
     * Sets up a system tray icon for the application.
     */
    private void setTrayIcon() {
        try {
            // ensure awt toolkit is initialized.
            java.awt.Toolkit.getDefaultToolkit();

            // app requires system tray support, just exit if there is no support.
            if (!java.awt.SystemTray.isSupported()) {
                System.out.println("No system tray support, application exiting.");
                Platform.exit();
            }

            // set up a system tray icon.
            java.awt.SystemTray tray = java.awt.SystemTray.getSystemTray();
            java.awt.Image image = ImageIO.read(getClass().getResourceAsStream("/images/icon16.png"));
            java.awt.TrayIcon trayIcon = new java.awt.TrayIcon(image);

            ActionListener showAction = event -> Platform.runLater(() -> {
                if (tripListWindow != null) {
                    tripListWindow.show();
                    tripListWindow.toFront();
                }
            });

            // if the user double-clicks on the tray icon, show the main app stage.
            trayIcon.addActionListener(showAction);

            // if the user selects the default menu item (which includes the app name),
            // show the main app tripListWindow.
            java.awt.MenuItem openItem = new java.awt.MenuItem("Show");
            openItem.addActionListener(showAction);

            java.awt.Font defaultFont = java.awt.Font.decode(null);
            java.awt.Font boldFont = defaultFont.deriveFont(java.awt.Font.BOLD);
            openItem.setFont(boldFont);

            java.awt.MenuItem exitItem = new java.awt.MenuItem("Exit");
            exitItem.addActionListener(event -> {
                notificationTimer.cancel();
                Platform.exit();
                tray.remove(trayIcon);
            });

            // setup the popup menu for the application.
            final java.awt.PopupMenu popup = new java.awt.PopupMenu();
            popup.add(openItem);
            popup.addSeparator();
            popup.add(exitItem);
            trayIcon.setPopupMenu(popup);

            // create a timer which periodically displays a notification message.
            notificationTimer.schedule(
                    new TimerTask() {
                        @Override
                        public void run() {
                            javax.swing.SwingUtilities.invokeLater(() ->
                                            trayIcon.displayMessage(
                                                    "Notification Test",
                                                    "The time is now " + timeFormat.format(new Date()),
                                                    java.awt.TrayIcon.MessageType.INFO
                                            )
                            );
                        }
                    },
                    5_000,
                    60_000
            );

            // add the application tray icon to the system tray.
            tray.add(trayIcon);

        } catch (java.awt.AWTException | IOException e) {
            System.out.println("Unable to init system tray");
            e.printStackTrace();
        }
    }
}