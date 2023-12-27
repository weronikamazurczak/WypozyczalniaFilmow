package Client;

import javafx.stage.Stage;
import javafx.scene.Scene;

public enum PrimaryStageSingleton {
    INSTANCE;
    private static final Stage primaryStage = LoginForm.getPrimaryStage();
    private PrimaryStageSingleton(){
    }
    public void setTitle(String title){
        primaryStage.setTitle(title);
    }
    public void setScene(Scene scene){
        primaryStage.setScene(scene);
    }
    public void show(){
        primaryStage.show();
    }
}
