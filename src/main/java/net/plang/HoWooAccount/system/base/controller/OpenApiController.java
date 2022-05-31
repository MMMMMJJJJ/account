package net.plang.HoWooAccount.system.base.controller;

import com.tobesoft.xplatform.data.PlatformData;
import net.plang.HoWooAccount.system.base.to.OpenApiBean;
import net.plang.HoWooAccount.system.base.to.OpenApiBean2;
import net.plang.HoWooAccount.system.common.mapper.DatasetBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;

@RestController
public class OpenApiController {

	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

	//로그인>Main 문화정보 오픈API
	@RequestMapping(value="SpringBoot_Account/base/openApi")
	public void openApiHandler(@RequestAttribute("reqData") PlatformData reqData,
							   @RequestAttribute("resData") PlatformData resData) throws Exception {

		ArrayList<OpenApiBean> openApiList= new ArrayList<>();
		OpenApiBean openApiBean = null;

		String url =
				"http://apis.data.go.kr/6260000/BusanCulturePlayService/getBusanCulturePlay?"
						+ "serviceKey=QbPbpRJRMZzNQzcRPCAE5bPbUvO2AobUc%2FYdprC83fBjQuL9Inj7ZPKng9ZYcPDG5ZId4xz7iHMJ%2FWqXkcKUsw%3D%3D"
						+ "&numOfRows=10"
						+ "&pageNo=1";

		System.out.println(url);

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder(); // xml데이터를 파싱할 수 있는 객체
		Document doc = dBuilder.parse(url);   // url의 xml데이터를 분석하여 DOM문서객체 반환
		doc.getDocumentElement().normalize();   // DOM트리가 XML문서의 구조대로 완성된다

		NodeList nList = doc.getElementsByTagName("item"); // item 태그 리스트 반환

		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp); // 각각의 item태그

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {   // 해당 노드가 요소노드이면
				Element eElement = (Element) nNode;  // Element객체로 형변환

				openApiBean = new OpenApiBean();
				// 해당 태그의 텍스트노드 값을 가져와 세팅
				openApiBean.setResNo(getTagValue("res_no", eElement)); // 공연번호
				openApiBean.setTitle(getTagValue("title", eElement)); // 제목
				openApiBean.setOpStDt(getTagValue("op_st_dt", eElement)); // 공연시작일
				openApiBean.setOpEdDt(getTagValue("op_ed_dt", eElement)); // 공연종료일
				openApiBean.setOpAt(getTagValue("op_at", eElement)); // 오픈런
				openApiBean.setPlaceNm(getTagValue("place_nm", eElement)); // 시설명
				openApiBean.setPayAt(getTagValue("pay_at", eElement)); // 유무료 구분

			}
			openApiList.add(openApiBean);
		}
		datasetBeanMapper.beansToDataset(resData, openApiList, OpenApiBean.class);
	}

	private static String getTagValue(String tag, Element eElement) {  // 자식 태그명, item태그
		NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes(); // item태그의 자식태그 중 해당 태그의 리스트.중 0번째 인덱스.의 모든 자식노드 / 즉 해당 tag의 자식노드 리스트
		Node nValue = (Node) nlList.item(0);
		// 하위 노드 리스트의 첫 번째 노드(item index 0) / 즉 텍스트 노드다
		if (nValue == null) {
			return null;
		}
		return nValue.getNodeValue(); // 노드의 값 반환
	}
}

