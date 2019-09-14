package eu.bittrade.libs.steemj.base.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import eu.bittrade.libs.steemj.interfaces.HasJsonAnyGetterSetter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a Steem "tag_api_obj" object.
 * 
 * @author <a href="http://steemit.com/@dez1337">dez1337</a>
 */
public class Tag implements HasJsonAnyGetterSetter, Serializable {
	private final Map<String, Object> _anyGetterSetterMap = new HashMap<>();
	@Override
	public Map<String, Object> _getter() {
		return _anyGetterSetterMap;
	}

	@Override
	public void _setter(String key, Object value) {
		_getter().put(key, value);
	}

    /** The name of the tag. */
    private String name;
    @JsonProperty("total_payouts")
    /** The total payouts for posts and comments using this tag. */
    private Asset totalPayouts;
    // Original type is "int32_t" so we use long here.
    @JsonProperty("net_votes")
    /** The number of votes made for posts and comments which used this tag. */
    private long netVotes;
    // Original type is "int32_t" so we use long here.
    @JsonProperty("top_posts")
    /** The number of posts that made it to a "top post" and used this tag. */
    private long topPosts;
    // Original type is "int32_t" so we use long here.
    private long comments;
    // Original type is "fc::uint128" so we use BigInteger here.
    private BigInteger trending;

    /**
     * This object is only used to wrap the JSON response in a POJO, so
     * therefore this class should not be instantiated.
     */
    private Tag() {
    }

    /**
     * @return The tag name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return The sum of the paid amounts for posts using this tag.
     */
    public Asset getTotalPayouts() {
        return totalPayouts;
    }

    /**
     * @return The number of votes.
     */
    public long getNetVotes() {
        return netVotes;
    }

    /**
     * @return The number of top posts.
     */
    public long getTopPosts() {
        return topPosts;
    }

    /**
     * @return The number of comments.
     */
    public long getComments() {
        return comments;
    }

    /**
     * @return Trending.
     */
    public BigInteger getTrending() {
        return trending;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
