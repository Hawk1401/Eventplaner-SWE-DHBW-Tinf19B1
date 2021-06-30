import javax.swing.*;

public class GUIController {

    private static final GUIController guiController = new GUIController();

    private GUIController(){

        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JButton("Ask Dr. Bob"));
        frame.pack();

        frame.setVisible(true);
        // constructor is private -> no access from outside, no new object -> singleton
    }

    public static GUIController getGuiController(){
        return guiController;
    }


}
