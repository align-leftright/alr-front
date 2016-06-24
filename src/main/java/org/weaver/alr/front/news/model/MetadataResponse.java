package org.weaver.alr.front.news.model;

import org.weaver.alr.front.common.model.Response;

public class MetadataResponse extends Response {
	private Metadata metadata;

	public Metadata getMetadata() {
		return metadata;
	}
	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}
}
