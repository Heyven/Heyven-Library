package org.hrms.common.search;

/**
 * 分页对象
 * 
 * @author VIC
 *
 */
public class Pageing {
	
	/** 总页数 */
	private int sumPage;
	
	/** 当前页(页码) */
	private int currentPage;
	
	/** 起始行 */
	private int startIndex;
	
	/** 每页显示的行数 */
	private int pageSize = 2;
	
	/** 查询关键字 */
	private Attribute keywords;
	
	/** 操作类型: 
	 * first: 首页/第一页 
	 * last: 尾页/最后一页
	 * up: 上一页
	 * nx: 下一页  
	 * */
	private String operate;
	
	public int getSumPage() {
		return sumPage;
	}
	public void setSumPage(int sumPage) {
		this.sumPage = sumPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public Attribute getKeywords() {
		return keywords;
	}
	public void setKeywords(Attribute keywords) {
		this.keywords = keywords;
	}
	public String getOperate() {
		return operate;
	}
	public void setOperate(String operate) {
		this.operate = operate;
	}
	
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	/**
	 * 计算总页数
	 * @param sumLine 总行数
	 */
	public void calculatorSumPage(int sumLine) {
		sumPage = sumLine / pageSize;
		if(sumLine % pageSize != 0){
			sumPage+=1;
		}
	}
	
	/**
	 * 计算当前页面
	 */
	public void calculatorCurrentPage() {
		
		if("first".equals(operate)){
			// 如果查询操作类型是first则当前页面直接设置为0,表示查询第一页
			currentPage = 0;
		}else if("last".equals(operate)){
			// 如果查询操作类型是last则当前页面直接设置为最大页-1,表示查询最后一页
			currentPage = sumPage - 1;
		}else if("up".equals(operate)){
			if(currentPage <= 0){
				// 如果查询操作类型是up,先判断当前页是否为1,为1则表示已经翻到第一页,
				// 前面已经没有了，则将当前页码设置到最后一页
				currentPage = sumPage - 1; 
			}else{
				// 否则将当前页面-1
				currentPage-=1;
			}
		}else if("nx".equals(operate)){
			// 如果查询操作类型是nx,先判断当前页是否已经是最大页,如果是最大页则将当前页面设置为1,表示第一页,
			if(currentPage >= (sumPage -1)){
				currentPage = 0;
			}else{
				// 否则将当前页码+=1
				currentPage += 1;
			}
		}
		
		// 计算起始行
		startIndex = currentPage * pageSize;
	}
	
	public static Pageing getInstance(){
		return new Pageing();
	}
	
}
