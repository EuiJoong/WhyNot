package login.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import member.model.MemberDBBean;

public class LoginMybatis {
	//SqlMapConfig.xml에 등록된 것들을 java코드로 사용할 수 있도록 해주는 곳
		private static SqlSessionFactory sqlMapper;
		static {
			try {
				// Reader = 위치 지정 
				Reader reader = Resources.getResourceAsReader("sqlmapconfig/SqlMapConfig.xml");
				// 들어오는 값을 지정 시켜줌
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				// 마이바티스로 바뀌면서 세션타입으로 처리를 해주게 됌
				reader.close();
			} catch (IOException e) {
				// Fail fast.
				throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
			}
		}
		public static MemberDBBean chkLogin(MemberDBBean dto) {
			System.out.println("LoginMybatis_ chkLogin()실행");
			SqlSession session = sqlMapper.openSession();
			MemberDBBean resDTO = session.selectOne("loginChk", dto);
			session.close();
			return resDTO;
		}

	}

