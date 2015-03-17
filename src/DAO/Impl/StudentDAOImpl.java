package DAO.Impl;

import DAO.StudentDAO;
import logic.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
	
	public void addStudent(Student stud) throws SQLException {
		    Session session = null;
		    try {
		    	session = HibernateUtil.getSessionFactory().openSession();
		    	session.beginTransaction();
		    	session.save(stud);
		    	session.getTransaction().commit();
		    } catch (Exception e) {
		    	JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'addStudent' I/O", JOptionPane.OK_OPTION);
		    } finally {
		    	if (session != null && session.isOpen()) {
		    		session.close();
		    	}
		    }
	  }

	  public void updateStudent(Student stud) throws SQLException {
		    Session session = null;
		    try {
		    	session = HibernateUtil.getSessionFactory().openSession();
		    	session.beginTransaction();
		    	session.update(stud);
		    	session.getTransaction().commit();
		    } catch (Exception e) {
		    	JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'updateStudent' I/O", JOptionPane.OK_OPTION);
		    } finally {
		    	if (session != null && session.isOpen()) {
		    		session.close();
		    	}
		    }
	  }

	  public Student getStudentById(Long id) throws SQLException {
		    Session session = null;
		    Student stud = null;
		    try {
		    	session = HibernateUtil.getSessionFactory().openSession();
		    	stud = (Student) session.load(Student.class, id);
                stud.getName();
		    } catch (Exception e) {
		    	JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getStudentById' I/O", JOptionPane.OK_OPTION);
		    } finally {
		    	if (session != null && session.isOpen()) {
		    		session.close();
		    	}
		    }
		    return stud;
	  }

//	  public List<Student> getAllStudents() throws SQLException {
    @Override
      public List getAllStudents() throws SQLException {
		    Session session = null;
		    List<Student> students = new ArrayList<Student>();
		    try {
		    	session = HibernateUtil.getSessionFactory().openSession();
                students = session.createCriteria(Student.class).list();
		    } catch (Exception e) {
		    	JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAllStudents' I/O", JOptionPane.OK_OPTION);
		    } finally {
		    	if (session != null && session.isOpen()) {
		    		session.close();
		    	}
		    }
		    return students;
	  }

	  public void deleteStudent(Student stud) throws SQLException {
		    Session session = null;
		    try {
		    	session = HibernateUtil.getSessionFactory().openSession();
		    	session.beginTransaction();
		    	session.delete(stud);
		    	session.getTransaction().commit();
		    } catch (Exception e) {
		    	JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'deleteStudent' I/O", JOptionPane.OK_OPTION);
		    } finally {
		    	if (session != null && session.isOpen()) {
		    		session.close();
		    	}
		    }
	  }  
	  
	  public List<Student> testFunc(){
		  Session session = null;
		    List<Student> studs = new ArrayList<Student>();
		    try {
		    	session = HibernateUtil.getSessionFactory().openSession();
		    	Criteria crit = session.createCriteria(Student.class);
		    	crit.setMaxResults(3);
		    	studs = crit.list();
		    } catch (Exception e) {
		    	JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'testFunc' I/O", JOptionPane.OK_OPTION);
		    } finally {
		    	if (session != null && session.isOpen()) {
		    		session.close();
		    	}
		    }
		    return studs;		  
	  }
}
