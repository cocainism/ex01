package org.joywins.service;

import java.util.List;

import org.joywins.domain.BoardVO;
import org.joywins.domain.Criteria;
import org.joywins.domain.SearchCriteria;

//...185p.����Ͻ�����(����)�� ��Ʈ�ѷ��� DAO������ ������ ����.
//...1. ������ �ٸ� �κ��� ó���� �� �ִ� ���濪���� ��.
//...2. �� ȸ�縶�� �ٸ� �����̳� ��Ģ�� DB�� �����ϰ� ó���� �� �ִ� ���� ����.
//...3. ��Ʈ�ѷ��� ���� �ܺ� ȣ���� DAO�� �������� ��Ȳ�� ������.
//...   ���� ��Ʈ�ѷ��� DAO�� DB�� �̿��ϰ� �Ǹ� Ʈ����� ó���� ���� ó���� ��� ������
//...	��Ʈ�ѷ��� ����ؾ� ��.
//...	����Ͻ�����(����)�� �����ѷ��� ���� ���� ���� �о��ϰ� ��.
public interface IF_BoardService {

	  public void insert(BoardVO board) throws Exception;

	  public BoardVO read(Integer bno) throws Exception;

	  public void update(BoardVO board) throws Exception;

	  public void delete(Integer bno) throws Exception;

	  public List<BoardVO> listAll() throws Exception;
	
	  public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	  
	  //...280p. int listCountCriteria(Criteria cri)	  
	  public int countBno(Criteria cri) throws Exception;

	  //...331p.
	  public List<BoardVO> listSearchCriteria(SearchCriteria cri) 
	      throws Exception;

	  public int listSearchCount(SearchCriteria cri) throws Exception;
	  
	  
}
