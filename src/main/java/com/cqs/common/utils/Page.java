package com.cqs.common.utils;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Collections;
import java.util.List;

/**
 * 与具体ORM实现无关的分页参数及查询结果封装.
 * 
 * @param <T> Page中记录的类型.
 * @author 
 */
public class Page<T> {
	
	// 排序参数
	public static final String ASC = "asc"; //升序
	public static final String DESC = "desc";//降序

	//每页显示记录数量
	public static final int MIN_PAGESIZE = 1;//最小值
	public static final int MAX_PAGESIZE =65535;//最大值
	public static final int NORMAL_PAGESIZE = 10;//采用值


	//分页参数
	protected int pageNo = 1;//当前页码 默认为1
    protected int pageSize =NORMAL_PAGESIZE; //每页显示记录数
	protected String orderBy = null;//排序
	protected String order = ASC;//升序
	protected boolean autoCount = true;//是否自动计算总记录数 默认计算总记录数
	protected String countCheck = "1";  //是否限制最小页记录数 '1'限制，'0'不限制

	//返回结果
	protected List<T> result = null;//记录
	protected int totalCount = 0;//总记录数
    protected int pages;//翻页数
	
	/**
	 * 构造函数
	 */
	public Page() {
		super();
	}

	/**
	 * 带参构造函数
	 * 
	 * @param pageSize  每页显示记录数量
	 */
	public Page(final int pageSize) {
		setPageSize(pageSize);
	}

	/**
	 * 带参构造函数
	 * 
	 * @param pageSize  每页显示记录数量
	 * @param autoCount 是否计算总记录数
	 */
	public Page(final int pageSize, final boolean autoCount) {
		setPageSize(pageSize);
		this.autoCount = autoCount;
	}
	
	/**
	 * 带参构造函数
	 * 
	 * @param pageSize  每页显示记录数量
	 * @param countCheck 是否限制最小页记录数 '1'限制，'0'不限制
	 */
	public Page(final int pageSize, final String countCheck) {
		this.pageSize = pageSize;
		this.countCheck = countCheck;
	}

	/**
	 * 获得当前页的页号,序号从1开始,默认为1.
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * 设置当前页的页号,序号从1开始,低于1时自动调整为1.
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo > 1 ? pageNo : 1;
	}

    /**
     *
     * @param pageNo
     */
    public void setPageNo(String pageNo) {
        this.pageNo = NumberUtils.toInt(pageNo,1);
        System.out.println(this.pageNo);
    }


	/**
	 * 获得每页的记录数量,默认为12.
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 设置每页的记录数量,超出MIN_PAGESIZE与MAX_PAGESIZE范围时会自动调整.
	 */
	public void setPageSize(final int pageSize) {
		this.pageSize = pageSize;

		if (pageSize < MIN_PAGESIZE) {
			this.pageSize = MIN_PAGESIZE;
		}
		if (pageSize > MAX_PAGESIZE) {
			this.pageSize = MAX_PAGESIZE;
		}
	}

    public void setPageSize(String pageSize) {
      this.pageSize = NumberUtils.toInt(pageSize,NORMAL_PAGESIZE);
    }

	/**
	* 根据pageNo和pageSize计算当前页第一条记录在总结果集中的位置,序号从0开始.
	*/
	public int getFirst() {
		return ((pageNo - 1) * pageSize);
	}

	/**
	 * 获得排序字段,无默认值.多个排序字段时用','分隔,仅在Criterion查询时有效.
	 */
	public String getOrderBy() {
		return orderBy;
	}

	/**
	 * 设置排序字段.多个排序字段时用','分隔.仅在Criterion查询时有效.
	 */
	public void setOrderBy(final String orderBy) {
		this.orderBy = orderBy;
	}

	/**
	 * 是否已设置排序字段,仅在Criterion查询时有效.
	 */
	public boolean isOrderBySetted() {
		return StringUtils.isNotBlank(orderBy);
	}

	public String getOrder() {
		return order;
	}

	/**
	 * 设置排序方式向,仅在Criterion查询时有效.
	 * 
	 * @param order 可选值为desc或asc,多个排序字段时用','分隔.
	 */
	public void setOrder(final String order) {
		//检查order字符串的合法值
		String[] orders = StringUtils.split(order, ',');
		for (String orderStr : orders) {
			if (!StringUtils.equalsIgnoreCase(DESC, orderStr) && !StringUtils.equalsIgnoreCase(ASC, orderStr))
				throw new IllegalArgumentException("排序方向" + orderStr + "不是合法值");
		}
		this.order = order.toLowerCase();
	}

	/**
	 * 取得分页参数的组合字符串.
	 * 将多个分页参数组合成一个字符串方便在页面上的传递,格式为pageNo|orderBy|order.
	 */
	public String getPageRequest() {
		return getPageNo() + "|" + StringUtils.defaultString(getOrderBy()) + "|" + getOrder();
	}

	/**
	 * 设置分页参数的组合字符串.
	 * 将多个分页参数组合成一个字符串方便在页面上的传递,格式为pageNo|orderBy|order.
	 */
	public void setPageRequest(final String pageRequest) {

		if (StringUtils.isBlank(pageRequest))
			return;

		String[] params = StringUtils.splitPreserveAllTokens(pageRequest, '|');

		if (StringUtils.isNumeric(params[0])) {
			setPageNo(Integer.valueOf(params[0]));
		}

		if (StringUtils.isNotBlank(params[1])) {
			setOrderBy(params[1]);
		}

		if (StringUtils.isNotBlank(params[2])) {
			setOrder(params[2]);
		}
	}

	/**
	 * 查询对象时是否自动另外执行count查询获取总记录数,默认为false,仅在Criterion查询时有效.
	 */
	public boolean isAutoCount() {
		return autoCount;
	}

	/**
	 * 查询对象时是否自动另外执行count查询获取总记录数,仅在Criterion查询时有效.
	 */
	public void setAutoCount(final boolean autoCount) {
		this.autoCount = autoCount;
	}

	/**
	 * 取得页内的记录列表.
	 */
	public List<T> getResult() {
		if (result == null)
			return Collections.emptyList();
		return result;
	}

	public void setResult(final List<T> result) {
		this.result = result;
	}

	/**
	 * 取得总记录数,默认值为-1.
	 */
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(final int totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * 根据pageSize与totalCount计算总页数,默认值为-1.
	 */
	public int getPages() {
		return pages > 1 ? pages  :  1 ;
	}
	
	/**
	 * 设置总页数
	 * 
	 * @param pages 总页数
	 */
	public void setTotalPages(int pages) {
		this.totalCount = pages;
	}

    public void setTotalPages2(int totalCount){
       this.pages = totalCount / getPageSize();
        if(0  != totalCount % getPageSize()){
            ++pages;
        }
    }

	/**
	 * 是否还有下一页.
	 */
	public boolean isHasNext() {
		return (pageNo + 1 <= getPages());
	}

	/**
	 * 取得下页的页号,序号从1开始.
	 */
	public int getNextPage() {
        return isHasNext() ? pageNo + 1 : pageNo;
	}

	/**
	 * 是否还有上一页. 
	 */
	public boolean isHasPre() {
		return (pageNo - 1 >= 1);
	}

	/**
	 * 取得上页的页号,序号从1开始.
	 */
	public int getPrePage() {
		return isHasPre() ? pageNo  - 1 : pageNo;
	}

	/**
	 * 取得反转的排序方向.
	 * 如果有以','分隔的多个排序方向,逐一进行反转.
	 */
	public String getInverseOrder() {
		String[] orders = StringUtils.split(order, ',');

		for (int i = 0; i < orders.length; i++) {
			if (DESC.equals(orders[i])) {
				orders[i] = ASC;
			} else {
				orders[i] = DESC;
			}
		}
		return StringUtils.join(orders);
	}
}
