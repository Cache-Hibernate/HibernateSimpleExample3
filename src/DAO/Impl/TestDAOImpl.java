package DAO.Impl;

import DAO.TestDAO;
import logic.Test;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDAOImpl implements TestDAO {
		public void addTest(Test test) throws SQLException {
		    Session session = null;
		    try {
		    	session = HibernateUtil.getSessionFactory().openSession();
		    	session.beginTransaction();
		    	session.save(test);
		    	session.getTransaction().commit();
		    } catch (Exception e) {
		    	JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
		    } finally {
		    	if (session != null && session.isOpen()) {
		    		session.close();
		    	}
		    }
	  }
	
	  public void updateTest(Test test) throws SQLException {
		    Session session = null;
		    try {
		    	session = HibernateUtil.getSessionFactory().openSession();
		    	session.beginTransaction();
		    	session.update(test);
		    	session.getTransaction().commit();
		    } catch (Exception e) {
		    	JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
		    } finally {
		    	if (session != null && session.isOpen()) {
		    		session.close();
		    	}
		    }
	  }
	
	  public Test getTestById(Long id) throws SQLException {
		    Session session = null;
		    Test test = null;
		    try {
		    	session = HibernateUtil.getSessionFactory().openSession();
		    	test = (Test) session.load(Test.class, id);
                test.getTName();
		    } catch (Exception e) {
		    	JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
		    } finally {
		    	if (session != null && session.isOpen()) {
		    		session.close();
		    	}
		    }
		    return test;
	  }
	
	  public List<Test> getAllTests() throws SQLException {
		    Session session = null;
		    List<Test> tests = new ArrayList<Test>();
		    try {
		    	session = HibernateUtil.getSessionFactory().openSession();
		    	tests = session.createCriteria(Test.class).list();
		    } catch (Exception e) {
		    	JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
		    } finally {
		    	if (session != null && session.isOpen()) {
		    		session.close();
		    	}
		    }
		    return tests;
	  }
	
	  public void deleteTest(Test test) throws SQLException {
		    Session session = null;
		    try {
		    	session = HibernateUtil.getSessionFactory().openSession();
		    	session.beginTransaction();
		    	session.delete(test);
		    	session.getTransaction().commit();
		    } catch (Exception e) {
		    	JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
		    } finally {
		    	if (session != null && session.isOpen()) {
		    		session.close();
		    	}
		    }
	  }  
}
