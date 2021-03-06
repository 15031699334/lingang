var myChartA = echarts.init(document.getElementById('chart-trend'));
optionA = {
	title: {
		text: ''
	},
	tooltip : {
		trigger: 'axis',
	},
	legend: {
		data:['钢坯'],
		right:0,
	},
	grid: {
		left: '1%',
		right: '4%',
		bottom: '1%',
		containLabel: true
	},
	xAxis : [
		{
			type : 'category',
			boundaryGap : false,
			data : [10.29,10.30,10.31,11.01,11.02,11.03,11.04,11.05]
		}
	],
	yAxis : [
		{
			scale: true,
			type : 'value'
		}
	],
	series : [
		{
			name:'钢坯',
			type:'line',
			itemStyle: {
				normal: {
					color: '#a76af7',
					
				}
			},
			data : [800,500,200,900,200,200,200,900]
		}
	]
};
myChartA.setOption(optionA);
// myChartB.setOption(optionB);

 
window.addEventListener("resize",function (){
	myChartA.resize();
	// myChartB.resize();

})