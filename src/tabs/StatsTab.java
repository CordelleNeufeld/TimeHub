/*
 * Provide the user with statistics
 *
 * @author Cordelle Neufeld
 * Creation date: 2019-11-06
 */

package tabs;

import javafx.scene.control.Tab;

public class StatsTab extends Tab {

    private static StatsTab instance = null;

    private StatsTab() {
        setText("Stats");
        setClosable(false);
    }

    public static StatsTab getInstance() {
        if (instance == null) {
            instance = new StatsTab();
        }

        return instance;
    }
}