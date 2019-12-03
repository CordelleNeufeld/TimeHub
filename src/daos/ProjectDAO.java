/*
 * Database Access Object
 * @author Cordelle Neufeld
 * Creation Date: 2019-11-13
 */

package daos;

import java.util.ArrayList;

import javabeans.Project;

public interface ProjectDAO {
	
	public ArrayList<Project> getAllProjects();
	public Project getProject(int projectID);
	public void updateProject(Project project);
	public void deleteProject(Project project);
	public int createProject(Project project);
	
}
