package com.hk.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hk.member.dto.Member;

public class MemberDao {
	Connection connection;

	public void setDsConnection(Connection connection) {
		// TODO Auto-generated method stub
		this.connection = connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	//회원 목록 조회
	public List<Member> selectList()  {
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Member> members = null;
		try {
			stmt = connection.createStatement();

			rs = stmt.executeQuery(
					"SELECT MNO,MNAME,EMAIL,PWD,CRE_DATE,MOD_DATE" + 
							" FROM MEMBERS" +
					" ORDER BY MNO ASC");
			members = new ArrayList<Member>();
			while(rs.next()){
				Member member = new Member();
				member.setNo(rs.getInt("mno"));
				member.setEmail(rs.getString("email"));
				member.setName(rs.getString("mname"));
				member.setPassword(rs.getString("pwd"));
				member.setCreatedDate(rs.getDate("cre_date"));
				member.setModifiedDate(rs.getDate("mod_date"));
				members.add(member);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return members;
	}


	//회원등록
	public int insert(Member member) {

		PreparedStatement stmt = null;
		int ret=0;
		try {
			stmt = connection.prepareStatement("INSERT INTO MEMBERS (MNO,EMAIL,pwd,MNAME,CRE_DATE,MOD_DATE) VALUES (MEMBER_SEQ.nextval,?,?,?,sysdate,sysdate)");
			stmt.setString(1,member.getEmail());  //email(사용자가 입력한 email - request
			stmt.setString(2,member.getPassword());    //pwd
			stmt.setString(3,member.getName());  //mname

			ret = stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
		return ret;
	}
	//회원삭제
	public String delete(int no)  {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String name = "";
		int ret=0;
		try {
			stmt = connection.prepareStatement("Select * from members where Mno=?");
			stmt.setInt(1, no);
			rs = stmt.executeQuery();
			rs.next();
			name = rs.getString("mname");
			stmt.close();

			stmt = connection.prepareStatement("DELETE FROM MEMBERS WHERE MNO=?");

			stmt.setInt(1, no);
			ret = stmt.executeUpdate();
			if(ret > 0) {return name;}
			else {
				return null;				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(rs!=null) {try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		}
		return null;
	}

	//회원 상세정보 조회
	public Member selectOne(int no) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Member member = new Member();

		try {
			stmt = connection.prepareStatement("SELECT MNO,MNAME,EMAIL,PWD, CRE_DATE, MOD_DATE FROM MEMBERS WHERE MNO=?");

			stmt.setInt(1, no);

			rs = stmt.executeQuery();
			rs.next();

			member.setNo(rs.getInt("mno"));
			member.setEmail(rs.getString("email"));
			member.setName(rs.getString("mname"));
			member.setPassword(rs.getString("pwd"));
			member.setCreatedDate(rs.getDate("cre_date"));
			member.setModifiedDate(rs.getDate("mod_date"));
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return member;
	}

	//회원 정보 변경
	public int update(Member member) {
		PreparedStatement stmt = null;
		int ret=0;

		try {
			stmt = connection.prepareStatement("UPDATE MEMBERS set EMAIL=?,MNAME=?,PWD=?, mod_date=sysdate where MNO=?");
			stmt.setString(1, member.getEmail());
			stmt.setString(2, member.getName());
			stmt.setString(3, member.getPassword());
			stmt.setInt(4, member.getNo());

			ret = stmt.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return ret;
	}

	//회원 존재 여부
	public Member exist(String email, String password)  {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Member member = new Member();
		try {
			stmt = connection.prepareStatement("select mname, email from members where email=? and pwd=?");
			stmt.setString(1, email);
			stmt.setString(2, password);
			rs = stmt.executeQuery();

			if (rs.next()) {
				
				member.setEmail(rs.getString("email"));
				member.setName(rs.getString("mname"));
				
			} else {
				return null;
			}

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			
		}
		return member;




	}
	
}
