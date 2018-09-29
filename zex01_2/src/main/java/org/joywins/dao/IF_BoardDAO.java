package org.joywins.dao;

import java.util.List;

import org.joywins.domain.BoardVO;
import org.joywins.domain.Criteria;
import org.joywins.domain.SearchCriteria;

/***
 * DAO = Persistence ��Ű��.
 * ...177p.
 * @author Administrator
 *
 */
public interface IF_BoardDAO {

	public void insert(BoardVO vo) throws Exception;

	public BoardVO read(Integer bno) throws Exception;

	public void update(BoardVO vo) throws Exception;

	public void delete(Integer bno) throws Exception;

	public List<BoardVO> listAll() throws Exception;

	public List<BoardVO> listPage(int page) throws Exception;

	//...256p. Criteria��ü�� �Ķ���ͷ� ���޹ް�, 
	//...�ʿ��� getPageStart()�� getPerPageNum()�� ȣ���� ����� �����.
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;

	//...279p.
	public int countBno(Criteria cri) throws Exception;
	
	//...323p.
	//...S.use for dynamic sql	  
	public List<BoardVO> listSearch(SearchCriteria cri)throws Exception;
	  
	public int listSearchCount(SearchCriteria cri)throws Exception;
	//...E.use for dynamic sql	

}
