CREATE DATABASE `week3_task`;
USE `week3_task`;

CREATE TABLE `students`(
`student_id` INT PRIMARY KEY AUTO_INCREMENT,
`student_name` VARCHAR(45)
);

CREATE TABLE `courses`(
`course_id` INT PRIMARY KEY AUTO_INCREMENT,
`course_name` VARCHAR(45),
`student_id` INT,
CONSTRAINT fk_student_id
FOREIGN KEY (`student_id`)
REFERENCES `students`(`student_id`)
);

INSERT INTO `students`
VALUES
(1, "Roberto"),
(2, "Tom"),
(3, "Yana");

INSERT INTO `courses`(`course_name`, `student_id`)
VALUES
("Java", 1),
("C#", 1),
("Python", 2),
("C++", 2),
("Java script", 3);

SELECT c.`course_name`, s.`student_name` FROM `courses` AS c
JOIN `students` AS s
ON s.`student_id` = c.`student_id`
WHERE c.`course_name` = 'Java';

SELECT s.`student_name`, c.`course_name` FROM `students` AS s
JOIN `courses` AS c
ON s.`student_id` = c.`student_id`
WHERE s.`student_name` = 'Roberto';



SELECT * FROM `courses`;
SELECT * FROM `students`;

