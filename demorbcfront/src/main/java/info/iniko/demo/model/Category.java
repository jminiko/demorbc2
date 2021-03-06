package info.iniko.demo.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "categoryIdId" })
public class Category {

	@JsonProperty("name")
	private String name;
	@JsonProperty("categoryIdId")
	private int categoryIdId;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	public Category withName(String name) {
		this.name = name;
		return this;
	}

	@JsonProperty("categoryIdId")
	public int getCategoryIdId() {
		return categoryIdId;
	}

	@JsonProperty("categoryIdId")
	public void setCategoryIdId(int categoryIdId) {
		this.categoryIdId = categoryIdId;
	}

	public Category withCategoryIdId(int categoryIdId) {
		this.categoryIdId = categoryIdId;
		return this;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public Category withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(name).append(categoryIdId).append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Category) == false) {
			return false;
		}
		Category rhs = ((Category) other);
		return new EqualsBuilder().append(name, rhs.name).append(categoryIdId, rhs.categoryIdId)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

}