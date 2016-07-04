package org.weaver.alr.front.news.model;

import org.weaver.alr.front.common.model.Page;
import org.weaver.alr.front.common.model.Response;

public class MetadataListResponse extends Response {
	private Page<Metadata> metadataList;

	public Page<Metadata> getMetadataList() {
		return metadataList;
	}
	public void setMetadataList(Page<Metadata> metadataList) {
		this.metadataList = metadataList;
	}
	
}
