package com.wpg.pumpmis.webview.soap.service;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SoapNetworkService {
	
	private final static String NAEM_SPACE = "http://tempuri.org/";
	
	public static SoapObject  sendSoapRequest(String url,String action,String method,Map<String,String> params){
		try {	
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            SOAPMessage soapRequest = createSoapMessage(action,method,params);
            SOAPMessage soapResponse = soapConnection.call(soapRequest, url);
            soapConnection.close();
            return new SoapObject(soapResponse);
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
	}

	private static SOAPMessage createSoapMessage(String action, String method,Map<String, String> params) {
		try {
			MessageFactory messageFactory = null;
			messageFactory = MessageFactory.newInstance();
			SOAPMessage soapMessage = messageFactory.createMessage();
			SOAPPart soapPart = soapMessage.getSOAPPart();
			SOAPEnvelope envelope = soapPart.getEnvelope();
			// add request body
			SOAPBody soapBody = envelope.getBody();
			SOAPElement soapBodyElem = soapBody.addChildElement(method, "",NAEM_SPACE);
			if (params != null) {
				Iterator<Entry<String, String>> pairIter = params.entrySet().iterator();
				while (pairIter.hasNext()) {
					Entry<String, String> entry = pairIter.next();
					SOAPElement element = soapBodyElem.addChildElement(entry.getKey());
					element.addTextNode(entry.getValue());
				}
			}
			// add action
			MimeHeaders headers = soapMessage.getMimeHeaders();
			headers.addHeader("SOAPAction", action);	
			return soapMessage;
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

//	
	public static <T> List<T> parserList(SoapObject soapObject,	Class<T> objClass){
		List<T> objectList = new ArrayList<T>();
		Node parentNode = null;
		try {
			parentNode = (Node) soapObject.getMsg().getSOAPBody().getFirstChild().getFirstChild();
		} catch (SOAPException e) {
			e.printStackTrace();
		}
		NodeList nodeList = parentNode.getChildNodes();
		for( int i = 0 ; i < nodeList.getLength(); ++i){
			Node chidNode = nodeList.item(i);
			T obj = parser(chidNode,objClass);
			objectList.add(obj);
		}
		return objectList;	
	}
	
	public static <T> T parserSimpleSoapObject(SoapObject soapResponse,Class<T> objClass) {
		try {
			return parser(soapResponse.getMsg().getSOAPBody().getFirstChild().getFirstChild(), objClass);
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	private  static String  getValueByTag(String tag,	Node node){
		for (int i = 0; i < node.getChildNodes().getLength(); ++i) {
			Node childNode = (Node) node.getChildNodes().item(i);
			if(tag.equals(childNode.getLocalName())){
				return childNode.getTextContent();
			}
		}
	  return null;
	}
	private static <T> T parser(Node node,Class<T> objClass){
		try {
			T obj = objClass.newInstance();
			Field[] fields = objClass.getDeclaredFields();
			Node parentNode = (Node) node;
			for (int i = 0; i < fields.length; ++i) {
				String fieldName = fields[i].getName();
				Class<?> classType = fields[i].getType();
				String fieldValue = getValueByTag(fieldName,parentNode);
				String methodName = "set" + fieldName;
				try {
					Method method = objClass.getMethod(methodName, classType);
					method.invoke(obj, fieldValue);
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return obj;
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		return  null;	
	}

	public static class SoapObject {

		private SOAPMessage msg;

		public SOAPMessage getMsg() {
			return msg;
		}

		public void setMsg(SOAPMessage msg) {
			this.msg = msg;
		}

		public SoapObject(SOAPMessage msg) {
			this.msg = msg;
		}
	}
}
