package org.weaver.alr.front.news;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.weaver.alr.front.common.Constants;
import org.weaver.alr.front.common.Result;
import org.weaver.alr.front.common.model.Response;
import org.weaver.alr.front.common.service.ElasticSearchService;
import org.weaver.alr.front.news.model.Metadata;
import org.weaver.alr.front.news.model.MetadataListResponse;
import org.weaver.alr.front.news.model.MetadataResponse;

@RestController
@RequestMapping("/news")
@Api(tags="News")
public class NewsController {
	
	@Autowired
	private ElasticSearchService esService;
	
	@RequestMapping(method=RequestMethod.GET)
	@ApiOperation("get metadata list")
	public @ResponseBody MetadataListResponse getMetadataList() {

		List<Metadata> metadataList = esService.searchDocument(Constants.ES_INDEX,
				Constants.ES_TYPE_NEWS, null, 0, 30, "publishedDate", ElasticSearchService.SORT_DESC, Metadata.class);

		MetadataListResponse resp = new MetadataListResponse();
		resp.setMetadataCount(metadataList.size());
		resp.setMetadataList(metadataList);
		return resp;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ApiOperation("get metadata")
	public @ResponseBody MetadataResponse getMetadata(@PathVariable("id")String id) {
		Metadata m = esService.getDocument(Constants.ES_INDEX,
				Constants.ES_TYPE_NEWS, id, Metadata.class);

		MetadataResponse resp = new MetadataResponse();
		if(m != null) {
			resp.setMetadata(m);
		}
		else {
			resp.fail(Result.NOT_FOUND, "not found metadata");
		}
		return resp;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	@ApiOperation("create metadata")
	public @ResponseBody Response createMetadata(@PathVariable("id")String id, @RequestBody()Metadata m) {
		m.setId(id);
		esService.putDocument(Constants.ES_INDEX, Constants.ES_TYPE_NEWS, id, m);
		
		Response resp = new Response();
		return resp;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@ApiOperation("delete metadata")
	public @ResponseBody Response deleteMetadata(@PathVariable("id")String id) {
		esService.deleteDocument(Constants.ES_INDEX, Constants.ES_TYPE_NEWS, id);
		
		Response resp = new Response();
		return resp;
	}

}
