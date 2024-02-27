package frames;

import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;

/**
 *
 */
public class IconManager
{

    private final Map<String, ImageIcon> map;

    public IconManager()
    {
        this.map = new HashMap<>();

        this.map.put("croissant", new ImageIcon(getClass().getResource("src/lib/img/croissant.png")));
        this.map.put("ice-cream", new ImageIcon(getClass().getResource("src/lib/img/ice-cream.png")));
        this.map.put("panettone", new ImageIcon(getClass().getResource("src/lib/img/panettone.png")));
    }

    public ImageIcon getIcon(String string)
    {
        return this.map.get(string);
    }
}