public class GUIController {

    private static final GUIController guiController = new GUIController();

    private GUIController(){
        // constructor is private -> no access from outside, no new object -> singleton
    }

    public static GUIController getGuiController(){
        return guiController;
    }
}
