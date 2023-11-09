package app;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Insets;
import javax.swing.UIManager;
import views.entidad.EntidadesFrame;

public class Main {

    public static void main(String[] args) throws Exception {
        FlatMacLightLaf.setup();

        UIManager.put("ScrollBar.thumbArc", 999);
        UIManager.put("ScrollBar.thumbInsets", new Insets(2, 2, 2, 2));
        UIManager.put("Button.arc", 15);
        UIManager.put("Component.arc", 20);
        UIManager.put("TextComponent.arc", 20);
        UIManager.put("OptionPane.yesButtonText", "Sí");
        UIManager.put("OptionPane.okButtonText", "Aceptar");
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        UIManager.put("OptionPane.titleText", "Mensaje");
        UIManager.put("OptionPane.messageDialogTitle", "Mensaje");

        java.awt.EventQueue.invokeLater(() -> {
            new EntidadesFrame().setVisible(true);
        });
    }
}
