package com.mes.utility;

public class Pager {
	
	private int pageNum;      //현재 출력될 페이지 번호
	private int totalArticle; //전체 갯수
	private int pageSize;     //페이지당 출력될 갯수
	private int blockSize;    //블럭당 출력될 페이지 갯수
	
	private int totalPage;    //전체 페이지 갯수
	private int startRow;     //현재 페이지에 출력될 시작 번호
	private int endRow;       //현재 페이지에 출력될 종료 번호

	private int startPage;    //현재 블럭에 출력될 시작 페이지 번호
	private int endPage;      //현재 블럭에 출력될 마지막 페이지 번호
	private int prevPage;     //이전 블럭의 시작 페이지 번호
	private int nextPage;     //다음 블럭의 시작 페이지 번호
	
	public Pager(int pageNum, int totalArticle, int pageSize, int blockSize) {
		this.pageNum=pageNum;
		this.totalArticle=totalArticle;
		this.pageSize=pageSize;
		this.blockSize=blockSize;
		
		calcPager();
	}
	
	public void calcPager() {
		totalPage=(int)Math.ceil(totalArticle*1.0/pageSize);
		if(pageNum<=0 || pageNum>totalPage) {
			pageNum=1;
		}
		
		startRow=(pageNum-1)*pageSize+1;
		endRow=pageNum*pageSize;
		if(endRow>totalArticle) {
			endRow=totalArticle;
		}
		
		startPage=(pageNum-1)/blockSize*blockSize+1;
		endPage=startPage+blockSize-1;
		if(endPage>totalPage) {
			endPage=totalPage;
		}
		
		prevPage=startPage-blockSize;
		nextPage=startPage+blockSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotalArticle() {
		return totalArticle;
	}

	public void setTotalArticle(int totalArticle) {
		this.totalArticle = totalArticle;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
}
