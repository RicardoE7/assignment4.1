package assignment4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class Assignment4_1Application {

	public static void main(String[] args) throws IOException {
		StudentService studentService = new StudentService();
		String[] studentInfo = null;
		String line = "";
		StudentFileRegEx studentFileRegEx = new StudentFileRegEx();
		BufferedReader reader0 = null;
		BufferedReader reader1 = null;
		BufferedReader reader2 = null;
		BufferedReader reader3 = null;
		BufferedWriter writer1 = null;
		BufferedWriter writer2 = null;
		BufferedWriter writer3 = null;
		
		Student[] compStudents = null;
		Student[] apmthStudents = null;
		Student[] statStudents = null;
		int compArraySize = 0;
		int apmthArraySize = 0;
		int statArraySize = 0;
		int compIndex = 0;
		int apmthIndex = 0;
		int statIndex = 0;
		
		
		try {
			reader0 = new BufferedReader(new FileReader("student-master-list.csv"));
			while ((line = reader0.readLine()) != null) {
				studentInfo = studentService.parseText(line);

				if (studentFileRegEx.compSciMatch(studentInfo[2])) {
					compArraySize = compArraySize + 1;
					System.out.println(compArraySize);
				}
				if (studentFileRegEx.apmthMatch(studentInfo[2])) {
					apmthArraySize = apmthArraySize + 1;
					System.out.println(apmthArraySize);
				}
				if (studentFileRegEx.statMatch(studentInfo[2])) {
					statArraySize = statArraySize + 1;
					System.out.println(statArraySize);
				}
				
			}
		}
		finally {
			if(reader0 != null)
				reader0.close();
		}
		
		compStudents = new Student[compArraySize];
		apmthStudents = new Student[apmthArraySize];
		statStudents = new Student [statArraySize];
		
		try {
			reader1 = new BufferedReader(new FileReader("student-master-list.csv"));
			writer1 = new BufferedWriter(new FileWriter("course1.csv"));
			writer1.write("Student ID, Student Name, Course, Grade\n");
			

			while ((line = reader1.readLine()) != null) {
				studentInfo = studentService.parseText(line);

				if (studentFileRegEx.compSciMatch(studentInfo[2])) {
					compStudents[compIndex] = studentService.createStudent(studentInfo);
					compIndex++;
				}
				
			}
			
			Arrays.sort(compStudents);

			//System.out.println(compLineCount);
			//compStudents = new Student[compLineCount];
			

			for (Student compStudent : compStudents) {

				writer1.write(compStudent.getId() + ", " + compStudent.getName() + ", " + compStudent.getCourse() + ", "
						+ compStudent.getGrade() + "\n");
			}

		} finally {
			if (reader1 != null)
				reader1.close();
			if (writer1 != null)
				writer1.close();
		}
		
		try {
			reader2 = new BufferedReader(new FileReader("student-master-list.csv"));
			writer2 = new BufferedWriter(new FileWriter("course2.csv"));
			writer2.write("Student ID, Student Name, Course, Grade\n");
			

			while ((line = reader2.readLine()) != null) {
				studentInfo = studentService.parseText(line);

				if (studentFileRegEx.apmthMatch(studentInfo[2])) {
					apmthStudents[apmthIndex] = studentService.createStudent(studentInfo);
					apmthIndex++;
				}
				
			}
			
			Arrays.sort(apmthStudents);

			//System.out.println(compLineCount);
			//compStudents = new Student[compLineCount];
			

			for (Student apmthStudent : apmthStudents) {

				writer2.write(apmthStudent.getId() + ", " + apmthStudent.getName() + ", " + apmthStudent.getCourse() + ", "
						+ apmthStudent.getGrade() + "\n");
			}

		} finally {
			if (reader2 != null)
				reader2.close();
			if (writer2 != null)
				writer2.close();
		}
		
		try {
			reader3 = new BufferedReader(new FileReader("student-master-list.csv"));
			writer3 = new BufferedWriter(new FileWriter("course3.csv"));
			writer3.write("Student ID, Student Name, Course, Grade\n");
			

			while ((line = reader3.readLine()) != null) {
				studentInfo = studentService.parseText(line);

				if (studentFileRegEx.statMatch(studentInfo[2])) {
					statStudents[statIndex] = studentService.createStudent(studentInfo);
					statIndex++;
				}
				
			}
			
			Arrays.sort(statStudents);

			//System.out.println(compLineCount);
			//compStudents = new Student[compLineCount];
			

			for (Student statStudent : statStudents) {

				writer3.write(statStudent.getId() + ", " + statStudent.getName() + ", " + statStudent.getCourse() + ", "
						+ statStudent.getGrade() + "\n");
			}

		} finally {
			if (reader3 != null)
				reader3.close();
			if (writer3 != null)
				writer3.close();
		}
	}

}
