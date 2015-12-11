package com.wpg.pumpmis.webview.soap.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;




import org.springframework.stereotype.Component;

import com.wpg.pumpmis.webview.DO.AlarmType;
import com.wpg.pumpmis.webview.DO.Area;
import com.wpg.pumpmis.webview.DO.Project;
import com.wpg.pumpmis.webview.DO.Provinces;
import com.wpg.pumpmis.webview.DO.PumpDeviceBaseInfo;
import com.wpg.pumpmis.webview.DO.PumpDeviceOpcItem;
import com.wpg.pumpmis.webview.DO.User;
import com.wpg.pumpmis.webview.DO.VAreaProvincePumpTreeNode;
import com.wpg.pumpmis.webview.DO.VPumpSensorDataDay;
import com.wpg.pumpmis.webview.DO.VPumpSensorDataMinute;
import com.wpg.pumpmis.webview.soap.service.SoapNetworkService.SoapObject;





@Component
public class WebService {
	
	private static final String BASE_URL = "http://124.65.77.146:88/";
    private static final String NAME_SAPCE = "http://tempuri.org/";
	public User login(String userName, String password) {
		String  method =  "GetUser";
		String  url = BASE_URL +"InnerUserService.asmx";
		String  action = NAME_SAPCE+ "GetUser";
		Map<String,String> params = new HashMap<String,String>();
		params.put("userName", userName);
		params.put("password", password);
		SoapObject response = SoapNetworkService.sendSoapRequest(url, action, method, params);
		User user = SoapNetworkService.parserSimpleSoapObject(response, User.class);
		return user;
	}

	

	public List<Area> getAreas(){
		String  method =  "GetAreas";
		String  url = BASE_URL + "DictionaryService.asmx";
		String  action = NAME_SAPCE+ "GetAreas";
		SoapObject response = SoapNetworkService.sendSoapRequest(url, action, method, null);
		List<Area> areaList = SoapNetworkService.parserList(response, Area.class);
		return areaList;	
	}
	
	public List<Project>getProjects(String provinceId){
		String  method =  "GetAreas";
		String  url = BASE_URL + "DictionaryService.asmx";
		String  action = NAME_SAPCE+ "GetProjects";
		Map<String,String> params = new HashMap<String,String>();
		params.put("provinceId", provinceId);
		SoapObject response = SoapNetworkService.sendSoapRequest(url, action, method, params);
		List<Project> areaList = SoapNetworkService.parserList(response, Project.class);
		return areaList;
	}
	
	public List<Provinces> getProvinces(String ereaId){
		
		String  method =  "GetProvinces";
		String  url = BASE_URL + "DictionaryService.asmx";
		String  action = NAME_SAPCE + "GetProvinces";
		Map<String,String> params = new HashMap<String,String>();
		params.put("areaId", ereaId);
		SoapObject response = SoapNetworkService.sendSoapRequest(url, action, method, params);
		List<Provinces> provinceList = SoapNetworkService.parserList(response, Provinces.class);
		return provinceList;
		
	}
	/**
	 * 
	 * @param parentId
	 * @param uuid
	 * @return
	 * 
	 *   <nodeName>string</nodeName>
      <type>int</type>
      <userId>string</userId>
	 */
	
	public List<VAreaProvincePumpTreeNode> getProvincePumTreeNodes(String parentId,String uuid){
		String  method =  "QueryProvincePumpTreeInfo";
		String  url = BASE_URL + "ProvincePumpTreeService.asmx";
		String  action = NAME_SAPCE + "QueryProvincePumpTreeInfo";
		Map<String,String> params = new HashMap<String,String>();
		params.put("nodeName", "");
		params.put("type", "0");
		params.put("userId", uuid);
		SoapObject response = SoapNetworkService.sendSoapRequest(url, action, method, params);
		List<VAreaProvincePumpTreeNode> provinceList = SoapNetworkService.parserList(response, VAreaProvincePumpTreeNode.class);
		return provinceList;
	}
	
	public PumpDeviceBaseInfo  getPumpDeviceBaseInfoByProjectId(String projectId){	
		String  method =  "QueryPumpDeviceBaseInfo";
		String  url = BASE_URL + "PumpDeviceService.asmx";
		String  action = NAME_SAPCE + "QueryPumpDeviceBaseInfo";
		Map<String,String> params = new HashMap<String,String>();
		params.put("deviceId", projectId);
		SoapObject response = SoapNetworkService.sendSoapRequest(url, action, method, params);
		PumpDeviceBaseInfo pumpDeviceBaseInfo = SoapNetworkService.parserSimpleSoapObject(response, PumpDeviceBaseInfo.class);
		return pumpDeviceBaseInfo;	
	}
	
	public List<PumpDeviceOpcItem>  getPumDeviceOpcItes(String deviceId){
		String  method =  "QueryDeviceOPCItems";
		String  url = BASE_URL + "PumpDeviceService.asmx";
		String  action = NAME_SAPCE + "QueryDeviceOPCItems";
		Map<String,String> params = new HashMap<String,String>();
		params.put("deviceId", deviceId);
		SoapObject response = SoapNetworkService.sendSoapRequest(url, action, method, params);
		List<PumpDeviceOpcItem> pumpDeviceOpcItem = SoapNetworkService.parserList(response, PumpDeviceOpcItem.class);
		return pumpDeviceOpcItem;	
	}
	
	
	public List<AlarmType> getAlarmTypes(){	
		String  method =  "GetAlarmTypes";
		String  url = BASE_URL + "DictionaryService.asmx";
		String  action = NAME_SAPCE + "GetAlarmTypes";
		SoapObject response = SoapNetworkService.sendSoapRequest(url, action, method, null);
		List<AlarmType> alarmTypes = SoapNetworkService.parserList(response, AlarmType.class);
		return alarmTypes;	
	}
	
   public List<VPumpSensorDataDay> getHistoryDayData(String deviceNo,String opcItemName,String startDate,String endDate){
		String  method =  "GetDeviceHistoryDayDatas";
		String  url = BASE_URL + "PumpDeviceHistoryService.asmx";
		String  action = NAME_SAPCE + method;
		Map<String,String> params = new HashMap<String,String>();
		params.put("deviceNo", deviceNo);
		params.put("opcItemName", opcItemName);
		params.put("startDate", startDate);
		params.put("endDate", endDate);
		SoapObject response = SoapNetworkService.sendSoapRequest(url, action, method, params);
		List<VPumpSensorDataDay> dayDatas = SoapNetworkService.parserList(response, VPumpSensorDataDay.class);
		return dayDatas;	
   }
   
   
   public List<VPumpSensorDataMinute>getHisttoryMinuteData(String deviceNo,String opcItemName,String startDate,String endDate){   
		String  method =  "GetDeviceHistoryMinuteDatas";
		String  url = BASE_URL + "PumpDeviceHistoryService.asmx";
		String  action = NAME_SAPCE + method;
		
		Map<String,String> params = new HashMap<String,String>();
		params.put("deviceNo", deviceNo);
		params.put("opcItemName", opcItemName);
		params.put("startDate", startDate);
		params.put("endDate", endDate);
		SoapObject response = SoapNetworkService.sendSoapRequest(url, action, method, params);
		List<VPumpSensorDataMinute> munuteDatas = SoapNetworkService.parserList(response, VPumpSensorDataMinute.class);
		return munuteDatas;	
   }
   
   /**
    * 
    * @param opcItemName
    * @返回一个字符串数组，其中第一个元素为1表示获取成功，第二个元素表示变量值，第三个元素表示时间戳
    */
   public List<String> getRealtimeOpcItemData(String opcItemName){
		String  method =  "GetVarString";
		String  url = BASE_URL + "datawebservice.asmx";
		String  action = NAME_SAPCE + method;
		
		Map<String,String> params = new HashMap<String,String>();
		params.put("VarName", opcItemName);

		SoapObject response = SoapNetworkService.sendSoapRequest(url, action, method, params);
		List<String> munuteDatas = SoapNetworkService.parserList(response, String.class);
		return munuteDatas;	
   }
	
}
