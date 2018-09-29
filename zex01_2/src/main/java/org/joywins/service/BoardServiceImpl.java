package org.joywins.service;

import java.util.List;

import javax.inject.Inject;

import org.joywins.dao.IF_BoardDAO;
import org.joywins.domain.BoardVO;
import org.joywins.domain.Criteria;
import org.joywins.domain.SearchCriteria;
import org.springframework.stereotype.Service;

//...185p. ����Ͻ�����(���񽺰���) : ��Ʈ�ѷ��� DAO ������ ������ ����.
//...188p.@Service�� �������� ������ �ν��ϰ� ��. root-context.xml::Beans Graph Ȯ���� ��.
@Service
public class BoardServiceImpl implements IF_BoardService {

	@Inject
	private IF_BoardDAO dao;

	@Override
	public void insert(BoardVO board) throws Exception {
		dao.insert(board);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return dao.read(bno);
	}

	@Override
	public void update(BoardVO board) throws Exception {
		dao.update(board);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		dao.delete(bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return dao.listAll();
	}

	/*
	 * ...261p. ������MVC�� �Ķ���͸� �����ϴ� ����� �����ؼ� ���� ������ �ʿ��� �����͸�
	 * ...�ϳ��� Ŭ������ �����ص� �۾� ���� ���� ���� �ʰ�, �ۼ��� �Ķ���Ϳ� Ŭ���� ����
	 * ...�ʿ��� ��� Ȯ���ؼ� ����� �� �ִ�.
	 * @see org.joywins.service.IF_BoardService#listCriteria(org.joywins.domain.Criteria)
	 */
	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	//...280p.
	@Override
	public int countBno(Criteria cri) throws Exception {
		return dao.countBno(cri);
	}

	//...331p.
	@Override
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}


}
