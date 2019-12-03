# TimeHub
Timekeeping for personal and collaborative projects.

The focus for this app is tracking one-time, singular occurrences of completed tasks in order to calculate statistics for cumulative hours of tasks within different user-defined projects.

## Getting Started

### Prerequisites

It is necessary for the user to have access to a database with an SQL relational database management system like MariaDB.

The user is required to enter data into the following fields in order to login:

* Database Host (e.g., php.scweb.ca)
* Database Codename
* Database User
* Database Password

![Image of TimeHub Login](README-TimeHubLogin.png)
*Figure 1. TimeHub Login*

This information can be reset from the File menu item: Change Database.

## Running the TimeHub app

### Creation of the Database

When a user logs in, a database connection is created and tables are created on this database.

![Image of TimeHub SQL Tables](README-TimeHubTables.png)
*Figure 2. SQL Table Structure*

### Home

The Home screen provides easy access to stats, user-defined categories and projects, and user entry of completed tasks with associated task hours.

![Image of TimeHub Home Tab](README-TimeHubHome.png)
*Figure 3. TimeHub Home*

### Categories

The user has the option to create a list of categories. It is optional to classify projects under the broader classification of a category.

![Image of TimeHub Tab for Categories](README-TimeHubCategories.png)
*Figure 4. TimeHub Categories Tab*

### Projects

The user has the option to create a list of projects. It is optional to record completed tasks under the classification of a project.

![Image of TimeHub Tab for Projects](README-TimeHubProjects.png)
*Figure 5. TimeHub Projects Tab*

### Tasks

The user defines a task with hours. The user may also provide this task with an optional description. A task may be assigned by the user to a project predefined by the user in the Projects tab. It is optional to assign a project to a task. However, statistics are only provided for **projects** with assigned tasks.

![Image of TimeHub Tab for Tasks](README-TimeHubTasks.png)
*Figure 6. TimeHub Tasks Tab*

## Statistics

A pie chart is provided to the user that displays proportional data of cumulative task hours according to the corresponding slice of pie for each **project**.

![Image of TimeHub Tab for Stats](README-TimeHubStats.png)
*Figure 7. TimeHub Stats Tab*

## Built With

* Eclipse IDE for Java Developers - Version: 24.12.0
* IntelliJ IDEA Community Edition - Version: 11.0.4
* Adobe Illustrator - Version 23.0.4
* Adobe Photoshop CC 2019 - Version 20.0.5
* GitHub

## Authors: HAC Programming

* **H**asan Muslemani
* **A**bel Anderson
* **C**ordelle Neufeld

## Acknowledgments

This app was built as a final project for Java 3 in the [Mobile Applications Development Program](http://www.stclaircollege.ca/programs/postsec/mobile_app_dev/) at St. Clair College in Windsor, Ontario, Canada. We are appreciative of the support and guidance of Câi Filiault, Professor.

Vector images sourced and modified from [Vecteezy.com](https://www.vecteezy.com)
