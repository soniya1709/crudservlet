package com.prowings.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.prowings.entities.StudentEntity;

public class StudentDaoImpl implements StudentDao {
	SessionFactory factory = HibernateUtil.getSessionFactory();

	@Override
	public boolean createStudent(StudentEntity std) {
		try {

			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(std);
			tx.commit();
			session.close();
			System.out.println("Student record save to DB successfully");
			return true;
		} catch (Exception e) {
			System.out.println("unable to Save record on DB");
			e.printStackTrace();
			return false;
		} finally {
			HibernateUtil.close();
		}
	}

	@Override
	public StudentEntity getStudentByRoll(int roll) {
		StudentEntity entity;
		try {
			Session session1 = factory.openSession();
			Transaction tx = session1.beginTransaction();
			Query query = session1.createQuery("From StudentEntity where roll=:roll");
			query.setParameter("roll", roll);
			entity = (StudentEntity) query.uniqueResult();
			tx.commit();
			session1.close();
			return entity;
		} catch (Exception e) {
			System.out.println("unable to load the record");
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.close();
		}
	}

	@Override
	public boolean updateStudent(int roll, StudentEntity std) {
	
		try {
			Session session1 = factory.openSession();
			Transaction tx = session1.beginTransaction();
			Query query = session1.createQuery("update StudentEntity set name=:name,address=:address where roll=:roll");
			query.setParameter("roll", roll);
			query.setParameter("name", std.getName());
			query.setParameter("address", std.getAddress());
			query.executeUpdate();
			tx.commit();
			session1.close();
			return true;
		} catch (Exception e) {
			System.out.println("unable to update the record");
			e.printStackTrace();
			return false;
		} finally {
			HibernateUtil.close();
		}
	}

	@Override
	public boolean deleteStudent(int roll) {
		Session session2=null;
		try {
			session2 = factory.openSession();
			Transaction tx = session2.beginTransaction();
			Query query = session2.createQuery("delete from StudentEntity where roll=:roll");
			query.setParameter("roll", roll);
			query.executeUpdate();
			tx.commit();
			
			return true;
		} catch (Exception e) {
			System.out.println("unable to delete the record");
			e.printStackTrace();
			return false;
		} finally {
			session2.close();
			HibernateUtil.close();
		}
	}

}
