package org.joywins.domain;
//...272p.
import org.joywins.domain.Criteria;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/*
 * ...268p. ��� �ϴ� �������������� ������.
 * ...��) IF ���� �������� 13p THEN, ���������� : 11p, �������� : 20p�� �Ǿ�� ��.
 * ...13/10(�����������ڿ� ������ ��������) = 1.3 �� �ݿø� �� 2 : ������ �����ڿ��� �ι�° ��ġ.
 * ...2*10(�����������ڿ� ������ ��������) = 20(������ �������� 10��°, ������ ��������ȣ).
 * ...20 - 10 + 1 = 11 : ���� ������ ��ȣ.
 * ...������������ ��ȣ = ������ ������ ��ȣ - �����������ڿ� ������ �������� + 1.
 * 
 * ...��� �ϴ� ������ ������ ����� ���������� ��� �����͸� �������� �����ؾ� �ϴµ�
 * ...�Ϲ������� 10�� �������� ��.
 * ...������ �����ڿ� ������ ���������� �Ϲ������� 10���� ������.
 * ...������ ��������ȣ�� ���� ���ϰ�, ���� �������� ���ϴ� ����� �����.
 * ...������ ��������ȣ�� ���� ������ ������ ������ �־, �ٽ� ����ؼ� Ȯ���Ѵ�.
 * 
 * ...Prev = ���������� == 1 ? false : true;
 * 
 * ...Next = ������ ��������ȣ * ������ �����ڿ� ������ �������� >= DB��ü�����ͼ� ? false : true;
 * 
 */
public class PageMaker {

	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean blPrev;	
	private boolean blNext;

	//...ȭ�鿡 �������� ������ ��ȣ�� ����.
	private int displayPageNum = 10;

	private Criteria cri;

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;

		calcData();
	}

	private void calcData() {

		endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);

		startPage = (endPage - displayPageNum) + 1;

		int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));

		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}

		blPrev = startPage == 1 ? false : true;

		blNext = endPage * cri.getPerPageNum() >= totalCount ? false : true;

	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isPrev() {
		return blPrev;
	}

	public boolean isNext() {
		return blNext;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public Criteria getCri() {
		return cri;
	}
	
	//...286p.��� ������ Criteria�� ����.
	//...readPage �����.
	public String makeQuery(int page) {

	    UriComponents uriComponents 
	    	= UriComponentsBuilder.newInstance()
	    						  .queryParam("page", page)
	    						  .queryParam("perPageNum", cri.getPerPageNum())
	    						  .build();
	    String strTemp = uriComponents.toUriString();
	    return uriComponents.toUriString();
	}
  	
	//...312p.searchType, keyWord ��ũó��.
	public String makeSearch(int page){
		    
	    UriComponents uriComponents =
	              UriComponentsBuilder.newInstance()
	              .queryParam("page", page)
	              .queryParam("perPageNum", cri.getPerPageNum())
	              .queryParam("searchType", ((SearchCriteria)cri).getSearchType())
	              .queryParam("keyword", ((SearchCriteria)cri).getKeyword())
	              .build();             
	    
	    return uriComponents.toUriString();
	} 	

}
