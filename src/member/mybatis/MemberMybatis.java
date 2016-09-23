package member.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import member.model.MemberDBBean;

//SqlMapConfig.xml�� ��ϵ� �͵��� java�ڵ�� ����� �� �ֵ��� ���ִ� ��
public class MemberMybatis  {

	private static SqlSessionFactory sqlMapper;
	static {
		try {
			// Reader = ��ġ ���� 
			Reader reader = Resources.getResourceAsReader("sqlmapconfig/SqlMapConfig.xml");
			//1.SqlMapConfig.xml 
			// ������ ���� ���� ������
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			// ���̹�Ƽ���� �ٲ�鼭 ����Ÿ������ ó���� ���ְ� ��
			reader.close();
		} catch (IOException e) {
			// Fail fast.
			throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
		}
	}
	public static void insertMember(MemberDBBean dto) {
		System.out.println("MemberMybatis_insertBoard() ����");
		SqlSession session = sqlMapper.openSession();
		session.insert("insertMember", dto);
		session.commit(); // insert�� �ݵ�� commit()�� ����� �����Ͱ� ������
		session.close();
	}
	
	public static MemberDBBean getMember(int mnum) {
		System.out.println("MemberMybatis_getMember() ����");
		SqlSession session = sqlMapper.openSession();
		MemberDBBean dto = session.selectOne("getMember", mnum);
		//session.close();
		return dto;
	}
	public static void deleteMember(String id) {
		// TODO Auto-generated method stub
		
	}
	public static void updateMember(MemberDBBean dto, String id) {
		// TODO Auto-generated method stub
		
	}
	//���̵� �ߺ� Ȯ��
		public static boolean idChk(String id) {
			// TODO Auto-generated method stub
			System.out.println("MemberMybatis_idChk() ����");
			SqlSession session = sqlMapper.openSession();
			boolean res = session.selectOne("idChk", id);
			session.close();
			
			return false;
		}
	
	// �̸��� ����
		public static boolean authCHK(HashMap authMap)
		{
			System.out.println("MemberMybatis_authCHK() ����");
			Iterator it = authMap.entrySet().iterator();
			
			while(it.hasNext())
			{
				Map.Entry en = (Map.Entry)it.next();
				System.out.println(en.getKey()+"    "+en.getValue());
				System.out.println("!!!");
			}
			SqlSession session = sqlMapper.openSession();
			int res = session.update("authCHK", authMap);
			boolean chk = true; 
			session.commit();
			System.out.println(res);
			if(res < 0){
				System.out.println("������Ʈ ���н� false�� �ٲ�");
				chk = false;
			}
			session.close();
			return chk;
		}
	
	// ������
	public static boolean reAuth(HashMap reAuthMap)
	{
		SqlSession session = sqlMapper.openSession();
		int res = session.update("reAuth", reAuthMap);
		boolean chk = true; 
		session.commit();
		System.out.println(res);
		if(res < 0){
			System.out.println("������Ʈ ���н� false�� �ٲ�");
			chk = false;
		}
		session.close();
		return chk;
	}
	
	public static List<MemberDBBean> listMember() {
		// TODO Auto-generated method stub
		System.out.println("MemberMybatis_listMember() ����");
		SqlSession session = sqlMapper.openSession();
		List<MemberDBBean> list = session.selectList("listMember");
		return list;
	}
	public static void sanctionsMember(MemberDBBean dto, int mnum) {//����
		// TODO Auto-generated method stub
		
	}
	
	public void findPassword(String id) {//��й�ȣ ã��
		// TODO Auto-generated method stub
		
	}

	public static void chargeMileage(MemberDBBean dto) {//���ϸ��� ����
		// TODO Auto-generated method stub
		System.out.println("MemberMybaris_chargeMileage() ����");
		SqlSession session = sqlMapper.openSession();
		session.update("chargeMileage", dto);
		session.commit();
		session.close();
	}

	public void updateAuth(String id, String auth) {//���� 
		// TODO Auto-generated method stub
		
	}
	
	

}
