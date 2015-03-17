package main;

import DAO.Factory;
import logic.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 28/01/2015
 * {@link http://javaxblog.ru/article/java-hibernate-3/}
 * *****************************************************
 * *****************************************************
 */
public class Main {
	
	public static void main(String[] args) throws SQLException {
        // Выведем всех студентов из базы данных
        System.out.println("\nВыведем всех студентов из базы данных");
        List<Student> students = Factory.getInstance().getStudentDAO().getAllStudents();
        System.out.println("+--------+---------+-------------------+");
        System.out.println("|   ID   |   AGE   |        NAME       |");
        System.out.println("+--------+---------+-------------------+");
        for(int i = 0; i < students.size(); ++i) {
            String strOut = "|   " + students.get(i).getId() + "          ";
            strOut = strOut.substring(0,9);
            strOut += strOut = "|   " + students.get(i).getAge() + "          ";
            strOut = strOut.substring(0,19);
            strOut += strOut = "|   " + students.get(i).getName() + "          ";
            strOut = strOut.substring(0,36) + "   |";
            System.out.println( strOut );
            System.out.println("+--------+---------+-------------------+");
        }
	}
}