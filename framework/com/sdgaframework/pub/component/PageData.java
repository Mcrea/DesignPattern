package com.sdgaframework.pub.component;


public class PageData {
	private long totalRecordCount;// 总记录数
	private long itemCountPerPage = 12;// 每页显示的记录数
	private long pageNumber = 1;// 页码
	private long beginRowNum;// 开始的ROWNUM
	private long endRowNum;// 结束的ROWNUM
	private long lastPageNumber;// 最后一页的页面,可作页面总数
	private long itemCountInPage;// 这一页的记录数
	private boolean hasPrevious;// 是否有上一页
	private boolean hasNext;// 是否有下一页

	public PageData(long totalRecordCount, long itemCountPerPage, long pageNumber) {
		if (pageNumber > totalRecordCount) {
			pageNumber = totalRecordCount;
		}
		setTotalRecordCount(totalRecordCount);
		setItemCountPerPage(itemCountPerPage);
		setPageNumber(pageNumber);
		setRowNums(totalRecordCount, itemCountPerPage, pageNumber);
		setTotalPageNumber(totalRecordCount, itemCountPerPage);
		setItemCountInPage(totalRecordCount, itemCountPerPage, pageNumber);
		setHasNext();
		setHasPrevious();
	}

	public PageData() {

	}

	public void setRowNums(long totalRecordCount,

	long itemCountPerPage, long pageNumber) {

		long tempBegin = (pageNumber - 1) * itemCountPerPage + 1;

		long tempEnd = pageNumber * itemCountPerPage;

		if (totalRecordCount >= tempBegin) {

			beginRowNum = tempBegin;

			if (totalRecordCount >= tempEnd) {

				endRowNum = tempEnd;

			} else {

				endRowNum = totalRecordCount;

			}

		} else {

			beginRowNum = 0;

			endRowNum = 0;

		}

	}

	/**
	 * @return
	 */
	public long getBeginRowNum() {
		return beginRowNum;
	}

	/**
	 * @return
	 */
	public long getEndRowNum() {
		return endRowNum;
	}

	/**
	 * @return
	 */
	public boolean isHasNext() {
		return hasNext;
	}

	/**
	 * @return
	 */
	public boolean isHasPrevious() {
		return hasPrevious;
	}

	/**
	 * @return
	 */
	public long getItemCountInPage() {
		return itemCountInPage;
	}

	/**
	 * @return
	 */
	public long getItemCountPerPage() {
		return itemCountPerPage;
	}

	/**
	 * @return
	 */
	public long getLastPageNumber() {
		return lastPageNumber;
	}

	/**
	 * @return
	 */
	public long getPageNumber() {
		return pageNumber;
	}

	/**
	 * @return
	 */
	public long getTotalRecordCount() {
		return totalRecordCount;
	}

	/**
	 * @param i
	 */
	public void setBeginRowNum(long i) {
		beginRowNum = i;
	}

	/**
	 * @param i
	 */
	public void setEndRowNum(long i) {
		endRowNum = i;
	}

	/**
	 * @param b
	 */
	public void setHasNext(boolean b) {
		hasNext = b;
	}

	public void setHasNext() {

		if (pageNumber < lastPageNumber) {

			this.hasNext = true;

		} else {

			this.hasNext = false;

		}
	}

	/**
	 * @param b
	 */
	public void setHasPrevious(boolean b) {
		hasPrevious = b;
	}

	/**
	 * @param i
	 */
	public void setItemCountInPage(long i) {
		itemCountInPage = i;
	}

	/**
	 * 
	 * @param itemCountInPage
	 *            The itemCountInPage to set.
	 */

	public void setItemCountInPage(long totalRecordCount,

	long itemCountPerPage, long pageNumber) {

		long temp = pageNumber * itemCountPerPage;

		if (temp <= totalRecordCount) {

			this.itemCountInPage = itemCountPerPage;

		} else {

			this.itemCountInPage = (totalRecordCount - ((pageNumber - 1) * itemCountPerPage));

		}

	}

	/**
	 * 
	 * @param hasPrevious
	 *            The hasPrevious to set.
	 */

	public void setHasPrevious() {

		if (pageNumber == 1) {

			this.hasPrevious = false;

		} else {

			this.hasPrevious = true;

		}

	}

	/**
	 * @param i
	 */
	public void setItemCountPerPage(long i) {
		itemCountPerPage = i;
	}

	/**
	 * @param i
	 */
	public void setLastPageNumber(long i) {
		lastPageNumber = i;
	}

	/**
	 * @param i
	 */
	public void setPageNumber(long i) {
		pageNumber = i;
	}

	/**
	 * @param i
	 */
	public void setTotalRecordCount(long i) {
		totalRecordCount = i;
	}

	/**
	 * 
	 * @param lastPageNumber
	 *            The lastPageNumber to set.
	 */

	public void setTotalPageNumber(long totalRecordCount, long itemCountPerPage) {

		if (totalRecordCount % itemCountPerPage == 0) {

			this.lastPageNumber = totalRecordCount / itemCountPerPage;

		} else {

			this.lastPageNumber = totalRecordCount / itemCountPerPage + 1;

		}
	}
}
