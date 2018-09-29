package org.joywins.dao;
//...180p.
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.joywins.domain.BoardVO;
import org.joywins.domain.Criteria;
import org.joywins.domain.SearchCriteria;
import org.springframework.stereotype.Repository;

/*
 * @Repository�� DAO�� �������� �νĽ�Ű�� ���ؼ� �ַ� �����.
 * root-context.xml���� context:component-scan base-package�� �Ӽ����� ��Ȯ�ؾ�
 * root-context.xml�� BeansGraph�� BoardDaoImpl�� ��Ÿ��.
 * http://www.mybatis.org/mybatis-3/ko/java-api.html
 * SqlSessions ����.
    <T> T selectOne(String statement, Object parameter)
	<E> List<E> selectList(String statement, Object parameter)
	<K,V> Map<K,V> selectMap(String statement, Object parameter, String mapKey)
	int insert(String statement, Object parameter)
	int update(String statement, Object parameter)
	int delete(String statement, Object parameter)
 */
@Repository
public class BoardDAOImpl implements IF_BoardDAO {

	//...root-context.xml�� org.mybatis.spring.SqlSessionTemplate�� ���Թ޾� �����.
	@Inject
	private SqlSession session;
	
	//.../zex01/src/main/resources/mappers/boardMapper.xml���� ������ namespace ����.	
	private static String namespace = "org.joywins.mapper.BoardMapper";
	
	
	@Override
	public void insert(BoardVO vo) throws Exception {
		session.insert(namespace + ".insert", vo);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return session.selectOne(namespace + ".read", bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
	    session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer bno) throws Exception {
	    session.delete(namespace + ".delete", bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
	    return session.selectList(namespace + ".listAll");
	}

	/*
	 * ...240p.����¡ ó�� ����.
	 * ...1�ܰ�. ��������ȣ�� �ش��ϴ� �����͸� ���.
	 * ...2�ܰ�. ��� ������ �ϴܿ� ������ ��ȣ�� ������.
	 * ...		 Prev, Next, ������������ȣ, ����������ȣ ���.
	 * ...3�ܰ�. �Խñ� ��ȸ, �����۾� �� �ٽ� ������ ��� �������� �� �� �ְ� ��.
	 * ...		 <a>�±��� href �Ӽ��� �̿��ؼ� ���� �̵��� URI�� ����.
	 * ...		 	<a>�±� �̿�: �˻������� ������ ������.
	 * ...		 <form>�±׸� �̿�, ��ũ�� Ŭ���ϸ� ���� ������ �����ϴ� ���.
	 * ...		 ��ũ���� �ּ����� ������ �̿��ϰ�, ������ ������ �� �ִ� <form>�±� �̿�.
	 * ...		 �ʿ��� ������ Ŭ���� ��� <form>�±� ���� �ʿ��� ������ ��Ƽ� ó����.
	 * 
	 * ...242p.����¡ ó���� ��Ģ.
	 * ...1. �ݵ�� GET����� �̿��ؼ� ó����.
	 * ...2. ����¡ ó���� �Ǹ� ��ȸȭ�鿡�� �ݵ�� '��ϰ���'�� �ʿ���.
	 * ...	 ������������� 3�������� ���ٰ� Ư�� �Խù��� ���Ҵٸ�, �ٽ� '��ϰ���'��ư��
	 * ...	 ������ �ٽ� ��Ͽ��� 3�������� �̵��ϴ� ����� �����Ǿ�� ��.
	 * ...3. �ݵ�� �ʿ��� ������ ��ȣ���� �����Ѵ�.
	 * 
	 * ...243p.����¡ ó�� ���߿� �ʿ��� ����.
	 * ...1. ����¡ ó���� ���� SQL.
	 * ...2. ������ ���� �ľ��� ���� SQL.
	 * ...3. �ڹٽ�ũ��Ʈ Ȥ�� <a>�±׸� ���� �̺�Ʈ ó��.
	 * @see org.joywins.dao.IF_BoardDAO#listPage(int)
	 */
	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		if (page <= 0) {
		    page = 1;
		}
		
		page = (page - 1) * 10;
	      
	    return session.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
	    return session.selectList(namespace + ".listCriteria", cri);
	}

	//...280p.
	@Override
	public int countBno(Criteria cri) throws Exception {
	    return session.selectOne(namespace + ".countBno", cri);
	}

	//...325p.BoardDAO Test�� ��.
	@Override
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception {
		return session.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".listSearchCount", cri);
	}

}
