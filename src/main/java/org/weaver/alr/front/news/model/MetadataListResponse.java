package org.weaver.alr.front.news.model;

import java.util.List;

import org.weaver.alr.front.common.model.Response;

public class MetadataListResponse extends Response {
	private Integer metadataCount;
	private List<Metadata> metadataList;

	public Integer getMetadataCount() {
		return metadataCount;
	}
	public void setMetadataCount(Integer metadataCount) {
		this.metadataCount = metadataCount;
	}
	public List<Metadata> getMetadataList() {
		return metadataList;
	}
	public void setMetadataList(List<Metadata> metadataList) {
		this.metadataList = metadataList;
	}
	
}
