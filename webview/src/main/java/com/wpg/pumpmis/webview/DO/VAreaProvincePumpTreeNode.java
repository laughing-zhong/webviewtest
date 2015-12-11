package com.wpg.pumpmis.webview.DO;

public class VAreaProvincePumpTreeNode {
	
	/**
	 *      <NodeId>string</NodeId>
          <NodeName>string</NodeName>
          <ParentNodeId>string</ParentNodeId>
          <TreeLevel>string</TreeLevel>
          <IsLeaf>string</IsLeaf>
          <OriginalXh>string</OriginalXh>
        </VAreaProvincePumpTree>
	 */
	
	private String NodeId;
	private String NodeName;
	public String getNodeId() {
		return NodeId;
	}
	public void setNodeId(String nodeId) {
		NodeId = nodeId;
	}
	public String getNodeName() {
		return NodeName;
	}
	public void setNodeName(String nodeName) {
		NodeName = nodeName;
	}
	public String getParentNodeId() {
		return ParentNodeId;
	}
	public void setParentNodeId(String parentNodeId) {
		ParentNodeId = parentNodeId;
	}
	public String getTreeLevel() {
		return TreeLevel;
	}
	public void setTreeLevel(String treeLevel) {
		TreeLevel = treeLevel;
	}
	public String getIsLeaf() {
		return IsLeaf;
	}
	public void setIsLeaf(String isLeaf) {
		IsLeaf = isLeaf;
	}
	public String getOriginalXh() {
		return OriginalXh;
	}
	public void setOriginalXh(String originalXh) {
		OriginalXh = originalXh;
	}
	
	@Override
	public String toString(){
		String result = "NodeId = "+NodeId +" originalXh = "+OriginalXh + " TreeLevel= "+TreeLevel
		+" IsLeaf = "+IsLeaf +" NodeName = "+NodeName ;
		return result;
		
	}
	private String ParentNodeId;
	private String TreeLevel;
	private String IsLeaf;
	private String OriginalXh;

}
