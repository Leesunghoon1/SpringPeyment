/*
 * package com.easyfestival.www.hendler;
 * 
 * import com.easyfestival.www.domain.PagingVO;
 * 
 * 
 * 
 * 
 * public class PagingHandler {
 * 
 * public class UserPageMaker { private int totalCount; private int startPage;
 * private int endPage; private boolean prev; private boolean next; private int
 * pageBlock = 10; private PagingVO pgvo;
 * 
 * 
 * 
 * public int getStartPage() { return startPage; }
 * 
 * public void setStartPage(int startPage) { this.startPage = startPage; }
 * 
 * public int getEndPage() { return endPage; }
 * 
 * public void setEndPage(int endPage) { this.endPage = endPage; }
 * 
 * public boolean isPrev() { return prev; }
 * 
 * public void setPrev(boolean prev) { this.prev = prev; }
 * 
 * public boolean isNext() { return next; }
 * 
 * public void setNext(boolean next) { this.next = next; }
 * 
 * public int getPageBlock() { return pageBlock; }
 * 
 * public void setPageBlock(int pageBlock) { this.pageBlock = pageBlock; }
 * 
 * public int getTotalCount() { return totalCount; }
 * 
 * public PagingVO getCri() { return pgvo; }
 * 
 * 
 * 
 * public void setCri(PagingVO pgvo) { this.pgvo = pgvo; }
 * 
 * public void setTotalCount(int totalCount) { this.totalCount = totalCount;
 * calcData(); // 계산 }
 * 
 * 
 * private void calcData() { endPage = (int)Math.ceil(pgvo.getPage() / (double)
 * pageBlock) * pageBlock; startPage = (endPage - pageBlock) + 1;
 * 
 * // 임시 엔드페이지. int tmpEndPage = (int)Math.ceil(totalCount /
 * (double)pgvo.getPerPageNum()); if(endPage > tmpEndPage) { endPage =
 * tmpEndPage; }
 * 
 * // 이전과 다음 prev = startPage == 1 ? false : true; next = endPage *
 * pgvo.getPerPageNum() >= totalCount? false : true;
 * System.out.println("UserPageMaker 페이지메이커: " + endPage); } }
 * 
 * }
 */