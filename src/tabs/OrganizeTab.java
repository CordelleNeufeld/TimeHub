/*
 * Provide the user with a screen to add or remove
 * (1) project names and (2) task names
 * for classification of hours
 *
 * @author Cordelle Neufeld
 * Creation date: 2019-11-06
 */

package tabs;

import javafx.scene.control.Tab;

public class OrganizeTab extends Tab {

    private static OrganizeTab instance = null;

    private OrganizeTab() {

        setText("Organize");
        setClosable(false);
    }

    public static OrganizeTab getInstance() {
        if (instance == null) {
            instance = new OrganizeTab();
        }

        return instance;
    }
}
