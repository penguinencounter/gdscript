package gdscript;

import com.intellij.openapi.util.IconLoader;

import javax.swing.*;
import java.util.HashMap;

public class GdIcon {

    public static final Icon FILE = IconLoader.getIcon("icons/file.png", GdIcon.class);

    // Godot editor icons
    public static final Icon OBJECT = IconLoader.getIcon("icons/godot_editor/Object.svg", GdIcon.class);

    public static HashMap<String, Icon> editorIcons = new HashMap<>();

    public static Icon getEditorIcon(String className) {
        Icon icon = editorIcons.get(className);
        if (icon == null) {
            try {
                Icon loaded = IconLoader.getIcon(String.format("icons/godot_editor/%s.svg", className), GdIcon.class);
                editorIcons.put(className, loaded);
            } catch (Exception e) {
                editorIcons.put(className, OBJECT);
            }
        }

        return editorIcons.get(className);
    }

}
