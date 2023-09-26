module fr.melaine.gerard.enchere {
    requires javafx.controls;
    requires javafx.fxml;


    exports fr.melaine.gerard.enchere;
    opens fr.melaine.gerard.enchere to javafx.fxml;
}