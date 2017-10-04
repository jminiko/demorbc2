package info.iniko.demo.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "robotId", "name", "category", "tags", "photos" })
public class Robot {

	@JsonProperty("robotId")
	private Integer robotId;
	@JsonProperty("name")
	private String name;
	@JsonProperty("category")
	private Category category;
	@JsonProperty("tags")
	private List<Object> tags = null;
	@JsonProperty("photos")
	private List<Object> photos = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("robotId")
	public Integer getRobotId() {
		return robotId;
	}

	@JsonProperty("robotId")
	public void setRobotId(Integer robotId) {
		this.robotId = robotId;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("category")
	public Category getCategory() {
		return category;
	}

	@JsonProperty("category")
	public void setCategory(Category category) {
		this.category = category;
	}

	@JsonProperty("tags")
	public List<Object> getTags() {
		return tags;
	}

	@JsonProperty("tags")
	public void setTags(List<Object> tags) {
		this.tags = tags;
	}

	@JsonProperty("photos")
	public List<Object> getPhotos() {
		return photos;
	}

	@JsonProperty("photos")
	public void setPhotos(List<Object> photos) {
		this.photos = photos;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
}