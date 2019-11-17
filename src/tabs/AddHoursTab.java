/*
 * Provide the user with a screen to add daily hours
 *
 * @author Cordelle Neufeld
 * Creation date: 2019-11-06
 */

package tabs;

import javafx.scene.control.Tab;

public class AddHoursTab extends Tab {

    public AddHoursTab() {
        super();

        // set title
        this.setText("Add Hours");
        this.setClosable(true);
    }
}