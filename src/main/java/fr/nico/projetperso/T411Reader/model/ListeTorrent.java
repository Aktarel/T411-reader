
package fr.nico.projetperso.T411Reader.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "query",
    "offset",
    "limit",
    "total",
    "torrents"
})
public class ListeTorrent {

    @JsonProperty("query")
    private String query;
    @JsonProperty("offset")
    private Integer offset;
    @JsonProperty("limit")
    private Integer limit;
    @JsonProperty("total")
    private String total;
    @JsonProperty("torrents")
    private List<Torrent> torrents = new ArrayList<Torrent>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The query
     */
    @JsonProperty("query")
    public String getQuery() {
        return query;
    }

    /**
     * 
     * @param query
     *     The query
     */
    @JsonProperty("query")
    public void setQuery(String query) {
        this.query = query;
    }

    /**
     * 
     * @return
     *     The offset
     */
    @JsonProperty("offset")
    public Integer getOffset() {
        return offset;
    }

    /**
     * 
     * @param offset
     *     The offset
     */
    @JsonProperty("offset")
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * 
     * @return
     *     The limit
     */
    @JsonProperty("limit")
    public Integer getLimit() {
        return limit;
    }

    /**
     * 
     * @param limit
     *     The limit
     */
    @JsonProperty("limit")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * 
     * @return
     *     The total
     */
    @JsonProperty("total")
    public String getTotal() {
        return total;
    }

    /**
     * 
     * @param total
     *     The total
     */
    @JsonProperty("total")
    public void setTotal(String total) {
        this.total = total;
    }

    /**
     * 
     * @return
     *     The torrents
     */
    @JsonProperty("torrents")
    public List<Torrent> getTorrents() {
        return torrents;
    }

    /**
     * 
     * @param torrents
     *     The torrents
     */
    @JsonProperty("torrents")
    public void setTorrents(List<Torrent> torrents) {
        this.torrents = torrents;
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
