package todoapp.desktop;

import view.MainScreen;

public class TodoappDesktop {

    public static void main(String[] args) {
	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }
    
}
