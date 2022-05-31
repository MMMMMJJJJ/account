package net.plang.HoWooAccount.system.common.configuration;

import com.tobesoft.xplatform.data.DataSetList;
import com.tobesoft.xplatform.data.Debugger;
import com.tobesoft.xplatform.data.PlatformData;
import com.tobesoft.xplatform.data.VariableList;
import com.tobesoft.xplatform.tx.HttpPlatformRequest;
import com.tobesoft.xplatform.tx.HttpPlatformResponse;
import com.tobesoft.xplatform.tx.PlatformType;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("deprecation")
@Component
public class XplatformInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("xplatformIntercepot 실행");
        HttpPlatformRequest httpPlatformRequest = new HttpPlatformRequest(request); //tobesoft에서 재공한 xplatform을 사용하기 위한 객체
        httpPlatformRequest.receiveData();
        PlatformData reqData = httpPlatformRequest.getData();
        PlatformData resData = new PlatformData(); //tobesoft에서 재공한 xplatform을 사용하기 위한 객체

        request.setAttribute("reqData",reqData);
        request.setAttribute("resData",resData);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {

        PlatformData resData = (PlatformData) request.getAttribute("resData");//tobesoft에서 재공한 xplatform을 사용하기 위한 객체
        if(resData == null){
            return;
        }
        VariableList variableList = resData.getVariableList(); //tobesoft에서 재공한 xplatform을 사용하기 위한 객체
        if (exception != null) {
            exception.printStackTrace();
            variableList.add("ErrorCode", -1);
            variableList.add("ErrorMsg", exception.getMessage());
        } else {
            variableList.add("ErrorCode", 0);
            variableList.add("ErrorMsg", "success");
        }
        HttpPlatformResponse httpPlatformResponse = new HttpPlatformResponse(response, PlatformType.CONTENT_TYPE_XML, "UTF-8"); //tobesoft에서 재공한 xplatform을 사용하기 위한 객체
        httpPlatformResponse.setData(resData);
        httpPlatformResponse.sendData();

        debug(resData.getDataSetList(), resData.getVariableList());

    }

    private void debug(DataSetList dataSetList, VariableList variableList) {

        Debugger debugger = new Debugger();//tobesoft에서 재공한 xplatform debug를 위한 객체
        // DEBUG - DataSet
        for (int n = 0; n < dataSetList.size(); n++) {

            System.out.println(debugger.detail(dataSetList.get(n)));
        }
        // DEBUG - VariableList
        for (int n = 0; n < variableList.size(); n++) {
            System.out.println(debugger.detail(variableList.get(n)));
        }
    }
}
