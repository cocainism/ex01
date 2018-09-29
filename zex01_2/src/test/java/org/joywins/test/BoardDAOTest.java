package org.joywins.test;

//...182p.
import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.joywins.dao.IF_BoardDAO;
import org.joywins.domain.BoardVO;
import org.joywins.domain.Criteria;
import org.joywins.domain.SearchCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class BoardDAOTest {

	@Inject
	private IF_BoardDAO dao;

	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);

	//@Test
	public void testCreate() throws Exception {
		BoardVO board = new BoardVO();
		board.setTitle("���ο� ���� �ֽ��ϴ�. ");
		board.setContent("���ο� ���� �ֽ��ϴ�. ");
		board.setWriter("zuser00");
		dao.insert(board);
	}

	//@Test
	public void testRead() throws Exception {
		logger.info(dao.read(1605665).toString());
	}

	//@Test
	public void testUpdate() throws Exception {
		BoardVO board = new BoardVO();
		board.setBno(1);
		board.setTitle("������ ���Դϴ�.");
		board.setContent("���� �׽�Ʈ ");
		dao.update(board);
	}

	//@Test
	public void testDelete() throws Exception {
		dao.delete(1);
	}

	//@Test
	public void test() {
		// fail("Not yet implemented");
	}

	//@Test
	public void testListPage() throws Exception {

		int page = 3;

		List<BoardVO> list = dao.listPage(page);

		for (BoardVO boardVO : list) {
			logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
		}
	}

	//...258p.
	//@Test
	public void testListCriteria() throws Exception {

		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPageNum(20);
		// ...limit (����������) (���������� �������� ����)
		// ...limit 20 20 : 20���� 2�������� ���.
		/*
		 * select bno, title, content, writer, regdate, view_count from
		 * ztbl_board where bno > 0 order by bno desc, regdate desc limit
		 * #{pageStart}, #{perPageNum}
		 */
		List<BoardVO> list = dao.listCriteria(cri);

		for (BoardVO boardVO : list) {
			logger.info("testListCriteria : " + boardVO.getBno() + ":" + boardVO.getTitle());
		}
		
	}

	// ...284p.UriComponents, UriComponentsBuilder�� path �Ǵ� query�� �ش��ϴ� ���ڿ�����
	// ...�߰��ؼ� ���ϴ� URI�� ������ �� �����.
	// ...���ϴ� �����͸� ��� �߰��ؼ� ó���� �� ����.
	// ...queryParam()�� ��� GET����� '?' �ڿ� �ٴ� �����Ͱ� ��.
	//@Test
	public void testURI() throws Exception {

		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				// .path("/zboard/read")
				.queryParam("bno", 12).queryParam("perPageNum", 20).build();

		logger.info("testURI : /zboard/read?bno=12&perPageNum=20");
		logger.info("testURI : " + uriComponents.toString());

	}

	// ...285p.�̸� ��θ� �����صΰ� '{module]'�� ���� ��θ� 'board'��
	// ...'{page}'�� 'read'�� ������ �� �ִ�.
	//@Test
	public void testURI2() throws Exception {

		UriComponents uriComponents = UriComponentsBuilder.newInstance().path("/{module}/{page}").queryParam("bno", 12)
				.queryParam("perPageNum", 20).build().expand("zboard", "read").encode();

		logger.info("testURI2 : /zboard/read?bno=12&perPageNum=20");
		logger.info("testURI2 : " + uriComponents.toString());
	}


	//...326p.log4jdbc-log4j2����(139p, 160p)�� �������̸� ����Ǵ� SQL������ ��µ�.
	//...��) INFO : jdbc.sqltiming - select count(bno) from ztbl_board where bno > 0 
	@Test
	public void testDynamic1() throws Exception {

		logger.info("...S.testDynamic1");
	    SearchCriteria cri = new SearchCriteria();
	    cri.setPage(1);
	    cri.setKeyword("��");
	    cri.setSearchType("t");

	    logger.info("=====================================");

	    List<BoardVO> list = dao.listSearch(cri);

	    for (BoardVO boardVO : list) {
	      logger.info("testDynamic1 : " + boardVO.getBno() + ": " + boardVO.getTitle());
	    }

	    logger.info("=====================================");

	    logger.info("COUNT: " + dao.listSearchCount(cri));
	    
	    logger.info("...E.testDynamic1");
	}
	
	
}
