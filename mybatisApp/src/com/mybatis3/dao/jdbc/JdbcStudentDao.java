package com.mybatis3.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mybatis3.domain.Student;

public class JdbcStudentDao {
	
	private DataSource dataSource;

	public JdbcStudentDao() {
		dataSource = new DataSource();
	}
	public List<Student> findStudentList() {
		List<Student> studentList = new ArrayList<Student>();
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(StudentSQL.SELECT_STUDENT_LIST);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setStudId(rs.getInt("stud_id"));
				student.setName(rs.getString("name"));
				student.setEmail(rs.getString("email"));
				student.setDob(rs.getDate("dob"));
				studentList.add(student);
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return studentList;
	}
	public Student findStudentById(int studId) {
		Student student = null;
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(StudentSQL.SELECT_STUDENT_BY_STUD_ID);
			pstmt.setInt(1, studId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				student = new Student();
				student.setStudId(rs.getInt("stud_id"));
				student.setName(rs.getString("name"));
				student.setEmail(rs.getString("email"));
				student.setDob(rs.getDate("dob"));
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return student;
	}

	public int createStudent(Student student) {
		int rowCount=0;
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(StudentSQL.INSERT_STUDENT);
			// pstmt.setInt(1, student.getStudId());
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getEmail());
			pstmt.setDate(3, new java.sql.Date(student.getDob().getTime()));
			rowCount=pstmt.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return rowCount;
	}

	public int updateStudent(Student student) {
		Connection conn = null;
		int rowCount=0;
		try {
			conn = dataSource.getConnection();
			
			PreparedStatement pstmt = conn.prepareStatement(StudentSQL.UPDATE_STUDENT);
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getEmail());
			pstmt.setDate(3, new java.sql.Date(student.getDob().getTime()));
			pstmt.setInt(4, student.getStudId());
			pstmt.executeUpdate();
			rowCount=pstmt.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e.getCause());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return rowCount;
	}
	
}
