package org.weaver.alr.front.news;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.weaver.alr.front.common.model.Response;
import org.weaver.alr.front.news.model.Metadata;
import org.weaver.alr.front.news.model.MetadataListResponse;
import org.weaver.alr.front.news.model.MetadataResponse;

@Controller
@RequestMapping("/news")
public class NewsController {

	private Map<String,Metadata> metadataMap = new HashMap<String,Metadata>();
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody MetadataListResponse getMetadataList() {
		List<Metadata> metadataList = new ArrayList<Metadata>();
		for(Entry<String,Metadata> e: metadataMap.entrySet()) {
			metadataList.add(e.getValue());
		}

		MetadataListResponse resp = new MetadataListResponse();
		resp.setMetadataCount(metadataList.size());
		resp.setMetadataList(metadataList);
		return resp;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody MetadataResponse getMetadata(@PathVariable("id")String id) {
		Metadata m = metadataMap.get(id);

		MetadataResponse resp = new MetadataResponse();
		if(m != null) {
			resp.setMetadata(m);
		}
		else {
			resp.setCode("0001");
			resp.setMessage("not found metadata");
		}
		return resp;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public @ResponseBody Response createMetadata(@PathVariable("id")String id, @RequestBody()Metadata m) {
		m.setId(id);
		metadataMap.put(id, m);
		
		Response resp = new Response();
		return resp;
	}

}
