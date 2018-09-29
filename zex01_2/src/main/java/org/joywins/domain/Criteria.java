package org.joywins.domain;
//...253p.

/*
 * ...251p. ���� �� ���������� �������� �����Ͱ� 10���� �ƴ϶�� sql limit ������ ��������
 * ...���Ǵ� 10�̶�� ���� ���� ����Ǿ� �ϰ�, �Ź� ���ϴ� �������� ó���� �� ���� �����
 * ...�ϴ� �������� �ذ��ϱ� ���� ���.
 * ...1. �ΰ��� �Ķ���͸� �޴� ���(��.��������ȣ + ���������).
 * ...	 �˻����� ����� �߰��ɼ��� ���޵Ǵ� �Ķ���� �絵 �þ�� ������ �����ؼ� ���2 ��õ.
 * ...2. �Ϲ������� �Խù��� ���ݿ� ���� 10�� Ȥ�� 20���� �����ǳ� �� ���� �Ķ���͸�
 * ...	 �ϳ��� ��� Ȱ���ϴ� ���·� �ϳ��� Ŭ���� ��ü�� ó��.
 * 
 * ...252p. MyBatis SQL Mapper ��Ģ.
 * ...	#{page}�� ���� �Ķ���͸� ����� �� ���������� page �Ӽ��� getter()�� ȣ����.
 * ...	select * from ztbl_board
 * ...	where bno > 0
 * ...	order by bno desc
 * ...	limit #{pageStart}, #{perPageNum}
 * ...	�Ķ���Ͱ� ���� ���� �þ�� �����ϱ� �����Ƿ� �ƿ� Ŭ������ ����� ��ü�� ó����.
 */
public class Criteria {

	private int page;
	private int perPageNum;
	private int pageStart;

	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
	}

	public int getPage() {
		return page;
	}	
	public void setPage(int page) {

		if (page <= 0) {
			this.page = 1;
			return;
		}

		this.page = page;
	}

	
	/*
	 * 	<select id="listCriteria" resultType="BoardVO">
	 <![CDATA[
	 select 
	   bno, title, content, writer, regdate, view_count 
	 from 
	   ztbl_board 
	 where bno > 0 
	 order by bno desc, regdate desc
	 limit #{pageStart}, #{perPageNum}
	 ]]>
	</select>
	 */
	// method for MyBatis SQL Mapper -
	// ...252p. MyBatis SQL Mapper ��Ģ.
	//...#{perPageNum}�� ���� �Ķ���͸� ����� �� ���������� page �Ӽ��� getter()�� ȣ����.
	//...255p. limit �������� ���� ��ġ�� ������ �� �����.
	//...limit ���۵����͹�ȣ 10.
	//...��) 10���� ����ϴ� ��� 3�������� �����ʹ� limt 20, 10�� ���� ����.
	public int getPageStart() {
		//...���۵����͹�ȣ = (��������ȣ - 1)*�������� �������� ����.
		pageStart = (this.page - 1) * perPageNum;
		return pageStart;
	}
	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}	
	// method for MyBatis SQL Mapper
	// ...252p. MyBatis SQL Mapper ��Ģ.	
	//...#{perPageNum}�� ���� �Ķ���͸� ����� �� ���������� page �Ӽ��� getter()�� ȣ����.
	//...255p. limit 20 ���������� �������� ����.
	public int getPerPageNum() {
		return this.perPageNum;
	}	
	public void setPerPageNum(int perPageNum) {

		if (perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}

		this.perPageNum = perPageNum;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", pageStart=" + pageStart + "]";
	}

}
