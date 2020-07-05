package com.hangtian.candlestickdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Magic;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Candlestick;
import com.github.abel533.echarts.series.Line;
import com.hangtian.candlestickdemo.util.EnhancedOption;

public class MainActivity extends AppCompatActivity {

    private EchartView lineChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lineChart = findViewById(R.id.lineChart);
        lineChart.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //最好在h5页面加载完毕后再加载数据，防止html的标签还未加载完成，不能正常显示
                refreshLineChart2();
            }
        });

//        Candlestick
//        EnhancedOption option = new EnhancedOption();
//        option.legend("高度(km)与气温(°C)变化关系");
//
//        option.toolbox().show(true).feature(Tool.mark, Tool.dataView, new MagicType(Magic.line, Magic.bar), Tool.restore, Tool.saveAsImage);
//
//        option.calculable(true);
//        option.tooltip().trigger(Trigger.axis).formatter("Temperature : <br/>{b}km : {c}°C");
//
//        ValueAxis valueAxis = new ValueAxis();
//        valueAxis.axisLabel().formatter("{value} °C");
//        option.xAxis(valueAxis);
//
//        CategoryAxis categoryAxis = new CategoryAxis();
//        categoryAxis.axisLine().onZero(false);
//        categoryAxis.axisLabel().formatter("{value} km");
//        categoryAxis.boundaryGap(false);
//        categoryAxis.data(0, 10, 20, 30, 40, 50, 60, 70, 80);
//        option.yAxis(categoryAxis);
//
//        Line line = new Line();
//        line.smooth(true).name("高度(km)与气温(°C)变化关系").data(15, -50, -56.5, -46.5, -22.1, -2.5, -27.7, -55.7, -76.5).itemStyle().normal().lineStyle().shadowColor("rgba(0,0,0,0.4)");
//        option.series(line);
//        option.exportToHtml("line5.html");
//        option.view();
    }

//    private void refreshLineChart(){
//        Object[] x = new Object[]{
//                "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
//        };
//        Object[] y = new Object[]{
//                820, 932, 901, 934, 1290, 1330, 1320
//        };
//        lineChart.refreshEchartsWithOption(EchartOptionUtil.getLineChartOptions(x, y));
//    }

    public void refreshLineChart2() {
        Object[] xAxis = new Object[]{
                "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
        };
        Object[] yAxis = new Object[]{
                820, 932, 901, 934, 1290, 1330, 1320
        };

        GsonOption option = new GsonOption();
        option.title("折线图");
        option.legend("销量");
        option.tooltip().trigger(Trigger.axis);

        ValueAxis valueAxis = new ValueAxis();
        option.yAxis(valueAxis);

        CategoryAxis categorxAxis = new CategoryAxis();
        categorxAxis.axisLine().onZero(false);
        categorxAxis.boundaryGap(true);
        categorxAxis.data(xAxis);
        option.xAxis(categorxAxis);


        Candlestick candlestick = new Candlestick();
//        candlestick.name("k线").data(yAxis).itemStyle().normal();
//        Line line = new Line();
//        line.smooth(false).name("销量").data(yAxis).itemStyle().normal().lineStyle().shadowColor("rgba(0,0,0,0.4)");
        candlestick.data(3776.0, 3781.0, 3775.0, 5000.0);
        candlestick.data(3776.0, 3781.0, 3775.0, 5000.0);
        candlestick.data(3776.0, 3781.0, 3775.0, 5000.0);
        candlestick.data(3776.0, 3781.0, 3775.0, 5000.0);
        candlestick.data(3776.0, 3781.0, 3775.0, 5000.0);
        candlestick.data(3776.0, 3781.0, 3775.0, 5000.0);
        candlestick.data(3776.0, 3781.0, 3775.0, 5000.0);
        candlestick.name("dfdf");
        option.series(candlestick);

    }
}
