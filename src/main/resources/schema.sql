CREATE DATABASE IF NOT EXISTS projectcalculatorDB;
USE projectcalculatorDB;

CREATE TABLE IF NOT EXISTS user (
                      userID INT PRIMARY KEY AUTO_INCREMENT,
                      firstName VARCHAR(255) NOT NULL,
                      lastName VARCHAR(255) NOT NULL,
                      userName VARCHAR(255) NOT NULL UNIQUE,
                      userPassword VARCHAR(255) NOT NULL,
                      email VARCHAR(255) NOT NULL,
                      birthDate DATE NOT NULL,
                      phoneNumber INT NOT NULL,
                      ROLE ENUM('admin','leader','contributer')
);

CREATE TABLE IF NOT EXISTS project (
                         projectID INT PRIMARY KEY AUTO_INCREMENT,
                         projectName VARCHAR(255) NOT NULL,
                         description TEXT,
                         imageURL VARCHAR(255),
                         estimatedTime INT,
                         startDate DATE NOT NULL,
                         endDate DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS users_projects (
                                userID INT NOT NULL,
                                projectID INT NOT NULL,
                                PRIMARY KEY (userID, projectID),
                                FOREIGN KEY (userid) REFERENCES user(userid),
                                FOREIGN KEY (projectid) REFERENCES project(projectid)
);

CREATE TABLE IF NOT EXISTS subproject (
                            subprojectID INT PRIMARY KEY AUTO_INCREMENT,
                            subprojectName VARCHAR(255) NOT NULL,
                            description TEXT,
                            estimatedTime INT,
                            projectID INT,
                            FOREIGN KEY (projectID) REFERENCES project(projectID)
);

CREATE TABLE IF NOT EXISTS users_subprojects (
                                   userID INT NOT NULL,
                                   subprojectID INT NOT NULL,
                                   PRIMARY KEY (userid, subprojectid),
                                   FOREIGN KEY (userid) REFERENCES user(userid),
                                   FOREIGN KEY (subprojectID) REFERENCES subproject(subprojectID)
);

CREATE TABLE IF NOT EXISTS task (
                      taskID INT PRIMARY KEY AUTO_INCREMENT,
                      taskName VARCHAR(255) NOT NULL,
                      description TEXT,
                      estimatedTime INT,
                      subprojectID INT,
                      FOREIGN KEY (subprojectID) REFERENCES subproject(subprojectID)
);

CREATE TABLE IF NOT EXISTS users_tasks (
                             userID INT NOT NULL,
                             taskID INT NOT NULL,
                             PRIMARY KEY (userID, taskID),
                             FOREIGN KEY (userID) REFERENCES user(userID),
                             FOREIGN KEY (taskID) REFERENCES task(taskID)
);
