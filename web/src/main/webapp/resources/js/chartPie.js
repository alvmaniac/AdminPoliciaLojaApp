
function cargaPieChart(url) {

// Themes begin
am4core.useTheme(am4themes_animated);
// Themes end

var chart = am4core.create("chartPiediv", am4charts.PieChart3D);
chart.hiddenState.properties.opacity = 0; // this creates initial fade-in

var auxDataPie = getJson(url);

//var auxDataPie  = [
//  {
//    country: "Lithuania",
//    litres: 501.9
//  },
//  {
//    country: "Czech Republic",
//    litres: 301.9
//  },
//  {
//    country: "Ireland",
//    litres: 201.1
//  },
//  {
//    country: "Germany",
//    litres: 165.8
//  },
//  {
//    country: "Australia",
//    litres: 139.9
//  },
//  {
//    country: "Austria",
//    litres: 128.3
//  }
//];

chart.data = auxDataPie;

chart.innerRadius = am4core.percent(40);
chart.depth = 120;

chart.legend = new am4charts.Legend();

var series = chart.series.push(new am4charts.PieSeries3D());
series.dataFields.value = "valor";
series.dataFields.depthValue = "valor";
series.dataFields.category = "clave";
series.slices.template.cornerRadius = 5;
series.colors.step = 3;

}; // end am4core.ready()


function getJson(url) {
	 var result = null;
	 jQuery.ajax({
	        async: false,
	        url: url,
	        dataType: "json",
	        success: function(data){
	            result = data;
	        }});
	return result;
}