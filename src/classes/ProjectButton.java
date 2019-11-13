package classes;

import javabeans.Project;
import javafx.scene.control.Button;

public class ProjectButton extends Button {

    private Project project;

    public ProjectButton(String text, Project project) {
        super(text);

        this.project = project;
    }

    public Project getProject() {
        return project;
    }
}
