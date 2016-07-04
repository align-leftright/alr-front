package org.weaver.alr.front.news.model;

import org.weaver.alr.front.common.model.Page;
import org.weaver.alr.front.common.model.Response;

public class MetadataListResponse extends Response {
	private Integer metadataCount;
	private Page<Metadata> metadataList;

	public Integer getMetadataCount() {
		return metadataCount;
	}
	public void setMetadataCount(Integer metadataCount) {
		this.metadataCount = metadataCount;
	}
	public Page<Metadata> getMetadataList() {
		return metadataList;
	}
	public void setMetadataList(Page<Metadata> metadataList) {
		this.metadataList = metadataList;
	}
	
}
