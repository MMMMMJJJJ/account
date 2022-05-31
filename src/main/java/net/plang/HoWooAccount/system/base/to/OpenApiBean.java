package net.plang.HoWooAccount.system.base.to;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.plang.HoWooAccount.system.common.annotation.Dataset;

@EqualsAndHashCode(callSuper=false)
@Data
@Dataset(name="gds_api")
public class OpenApiBean {

	String resultCode;
	String resultMsg;
	String numOfRows;
	String pageNo;
	String totalCount;
	String resNo;
	String title;
	String opStDt;
	String opEdDt;
	String opAt;
	String placeNm;
	String payAt;

}
