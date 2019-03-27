package org.hrms.service.impl;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hrms.common.context.State;
import org.hrms.common.request.EmployeeTransferRequest;
import org.hrms.common.response.Response;
import org.hrms.common.search.Attribute;
import org.hrms.common.search.BetweenDate;
import org.hrms.domain.Department;
import org.hrms.domain.EmployeeTransfer;
import org.hrms.service.IEmployeeTransferService;
import org.hrms.util.DateUtil;
import org.hrms.util.ListUtil;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.stereotype.Service;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 员工调动业务实现类
 * 
 * @author VIC
 *
 */
@Service
public class EmployeeTransferServiceImpl extends BaseServiceImpl<EmployeeTransfer, Integer, EmployeeTransferRequest> implements IEmployeeTransferService {
	
	public Response generate(EmployeeTransferRequest employeeTransferRequest) {
		
		Response response = Response.getInstance();
		// 查询数据
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		List<EmployeeTransfer> employeeTransferList = employeeTransferReadWrite.selectByMonth(new BetweenDate(employeeTransferRequest.getStartTime(), employeeTransferRequest.getEndTime()));
		if(ListUtil.isNotEmpty(employeeTransferList)){
			// 获取部门
			List<Department> departmentList = departmentReadWrite.selectByAttributes(new Attribute("state", State.ENABLED.toString()));
			// 计算月份
			Date startDate = DateUtil.parse(employeeTransferRequest.getStartTime());
			Date endDate = DateUtil.parse(employeeTransferRequest.getEndTime());
			List<Date> betweenDates = DateUtil.getBetweenDateMonth(startDate, endDate);
			// 填充报表数据
			for(int i = 0; i < departmentList.size(); i++) {
				String departmentName = departmentList.get(i).getDepartmentName();
				// 过滤月份数据
				List<Map<String, Integer>> departmentMonthDataList = filterDepartmentData(departmentName, betweenDates, employeeTransferList);
				// 填充月份数据
				for(Map<String, Integer> data : departmentMonthDataList) {
					String key = data.keySet().iterator().next();
					dataset.addValue(data.get(key), departmentName, key);
				}
			}
			// 构建报表填充数据
			JFreeChart jFreeChart = buildChartAndFullData(dataset);
			try {
				// 存储图形报表
		        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + ".jpg";
		        String savePath = employeeTransferRequest.getFilePath() + systemConfiguraction.report + File.separator + fileName;
				ChartUtilities.saveChartAsJPEG(new File(savePath), jFreeChart, 1024, 400);
		        response.setData(systemConfiguraction.website + systemConfiguraction.report + File.separator + fileName);
		        response.setState(true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return response;
	}
	
	/**
	 * 创建报表模板并填充数据
	 * 
	 * @param dataset
	 * @return
	 */
	private JFreeChart buildChartAndFullData(CategoryDataset dataset) {
		JFreeChart chart = ChartFactory.createLineChart("员工调动统计图", // 图表标题
				"月份", // X轴标题
				"数量(人)", // Y轴标题
				dataset, // 数据集
				PlotOrientation.VERTICAL, // 绘制方向
				true, // 是否显示图例
				false, // 是否采用标准生成器
				false // 是否支持超链接
		);

		// 通过JFreeChart对象的 setTitle方法，修改统计图表的标题部分（包括修改图表标题内容、字体大小等）
		chart.setTitle(new TextTitle("员工调动统计图", new Font("黑体", Font.ITALIC, 22)));
		// 调用 JFreeChart对象的 getLegend(int index)方法，取得该图表的指定索引的图例对象，通过
		// LegendTitle对象来修改统计图表的图例
		LegendTitle legend = chart.getLegend(0);
		// 设置图例的字体和字体大小，即位于下方的字的字体和大小
		legend.setItemFont(new Font("宋体", Font.BOLD, 14));
		// 设置画布背景色
		chart.setBackgroundPaint(new Color(192, 228, 106));
		// 取得折线图的绘图(plot)对象
		CategoryPlot plot = chart.getCategoryPlot();
		// 设置数据区的背景透明度，范围在0.0～1.0间
		plot.setBackgroundAlpha(0.5f);
		// 设置数据区的前景透明度，范围在0.0～1.0间
		plot.setForegroundAlpha(0.5f);
		// 设置横轴字体
		plot.getDomainAxis().setLabelFont(new Font("黑体", Font.BOLD, 14));
		// 设置坐标轴标尺值字体
		plot.getDomainAxis().setTickLabelFont(new Font("宋体", Font.BOLD, 12));
		// 设置纵轴字体
		plot.getRangeAxis().setLabelFont(new Font("黑体", Font.BOLD, 14));
		// 设置绘图区背景色
		plot.setBackgroundPaint(Color.WHITE);
		// 设置水平方向背景线颜色
		plot.setRangeGridlinePaint(Color.BLACK);
		// 设置是否显示水平方向背景线,默认值为true
		plot.setRangeGridlinesVisible(true);
		// 设置垂直方向背景线颜色
		plot.setDomainGridlinePaint(Color.BLACK);
		// 设置是否显示垂直方向背景线,默认值为false
		plot.setDomainGridlinesVisible(true);
		// 没有数据时显示的消息
		plot.setNoDataMessage("没有相关统计数据");
		plot.setNoDataMessageFont(new Font("黑体", Font.CENTER_BASELINE, 16));
		plot.setNoDataMessagePaint(Color.RED);

		// 获取折线对象
		LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();

		// 设置折点处以某种形状凸出
		renderer.setShapesVisible(true);
		renderer.setDrawOutlines(true);
		renderer.setUseFillPaint(true);
		renderer.setFillPaint(java.awt.Color.WHITE);

		// 设置显示折点处的数据值
		// renderer.setBaseItemLabelGenerator (new
		// StandardCategoryItemLabelGenerator ());
		// renderer.setItemLabelFont (new Font ("黑体", Font.PLAIN, 12));
		// renderer.setItemLabelsVisible (true);

		BasicStroke realLine = new BasicStroke(2.0f); // 设置实线
		float dashes[] = { 8.0f }; // 定义虚线数组
		BasicStroke brokenLine = new BasicStroke(2.0f, // 线条粗细
				BasicStroke.CAP_SQUARE, // 端点风格
				BasicStroke.JOIN_MITER, // 折点风格
				8.f, // 折点处理办法
				dashes, // 虚线数组
				0.0f); // 虚线偏移量
		// 利用虚线绘制
		renderer.setSeriesStroke(0, brokenLine);
		// 利用虚线绘制
		renderer.setSeriesStroke(1, brokenLine);
		// 利用实线绘制
		renderer.setSeriesStroke(2, realLine);
		// 利用实线绘制
		renderer.setSeriesStroke(3, realLine);

		// 设置折线的颜色
		renderer.setSeriesPaint(0, Color.BLACK);
		renderer.setSeriesPaint(1, Color.RED);
		renderer.setSeriesPaint(2, Color.BLUE);
		renderer.setSeriesPaint(3, Color.MAGENTA);
		return chart;
	}

	/**
	 * 过滤部门数据
	 * 
	 * @param departmentName
	 * @param datas
	 * @param employeeTransferList
	 * @return
	 */
	private List<Map<String, Integer>> filterDepartmentData(String departmentName, List<Date> datas,
			List<EmployeeTransfer> employeeTransferList) {
		
		List<Map<String, Integer>> departmentMonthDataList = Lists.newArrayList();
		for(int i = 0; i < datas.size(); i++){
			if(i < datas.size() - 1){
				Long startTime = datas.get(i).getTime();
				Long endTime = datas.get(i + 1).getTime();
				String key = DateUtil.converterMonthName(datas.get(i));
				Map<String, Integer> data = Maps.newHashMap();
				Integer value = 0;
				for(EmployeeTransfer employeeTransfer : employeeTransferList){
					if(employeeTransfer.getOriginalDepartment().equals(departmentName) && 
					   employeeTransfer.getTransferTime() > startTime && 
					   employeeTransfer.getTransferTime() < endTime){
						value++;
					}
				}
				data.put(key, value);
				departmentMonthDataList.add(data);
			}
		}
		return departmentMonthDataList;
	}
}
