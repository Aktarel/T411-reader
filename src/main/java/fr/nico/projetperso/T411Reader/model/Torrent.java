
package fr.nico.projetperso.T411Reader.model;

import java.util.HashMap;
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
    "id",
    "name",
    "category",
    "rewritename",
    "seeders",
    "leechers",
    "comments",
    "isVerified",
    "added",
    "size",
    "times_completed",
    "owner",
    "categoryname",
    "categoryimage",
    "username",
    "privacy"
})
public class Torrent {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("category")
    private String category;
    @JsonProperty("rewritename")
    private String rewritename;
    @JsonProperty("seeders")
    private String seeders;
    @JsonProperty("leechers")
    private String leechers;
    @JsonProperty("comments")
    private String comments;
    @JsonProperty("isVerified")
    private String isVerified;
    @JsonProperty("added")
    private String added;
    @JsonProperty("size")
    private String size;
    @JsonProperty("times_completed")
    private String timesCompleted;
    @JsonProperty("owner")
    private String owner;
    @JsonProperty("categoryname")
    private String categoryname;
    @JsonProperty("categoryimage")
    private String categoryimage;
    @JsonProperty("username")
    private String username;
    @JsonProperty("privacy")
    private String privacy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The category
     */
    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    /**
     * 
     * @param category
     *     The category
     */
    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * 
     * @return
     *     The rewritename
     */
    @JsonProperty("rewritename")
    public String getRewritename() {
        return rewritename;
    }

    /**
     * 
     * @param rewritename
     *     The rewritename
     */
    @JsonProperty("rewritename")
    public void setRewritename(String rewritename) {
        this.rewritename = rewritename;
    }

    /**
     * 
     * @return
     *     The seeders
     */
    @JsonProperty("seeders")
    public String getSeeders() {
        return seeders;
    }

    /**
     * 
     * @param seeders
     *     The seeders
     */
    @JsonProperty("seeders")
    public void setSeeders(String seeders) {
        this.seeders = seeders;
    }

    /**
     * 
     * @return
     *     The leechers
     */
    @JsonProperty("leechers")
    public String getLeechers() {
        return leechers;
    }

    /**
     * 
     * @param leechers
     *     The leechers
     */
    @JsonProperty("leechers")
    public void setLeechers(String leechers) {
        this.leechers = leechers;
    }

    /**
     * 
     * @return
     *     The comments
     */
    @JsonProperty("comments")
    public String getComments() {
        return comments;
    }

    /**
     * 
     * @param comments
     *     The comments
     */
    @JsonProperty("comments")
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * 
     * @return
     *     The isVerified
     */
    @JsonProperty("isVerified")
    public String getIsVerified() {
        return isVerified;
    }

    /**
     * 
     * @param isVerified
     *     The isVerified
     */
    @JsonProperty("isVerified")
    public void setIsVerified(String isVerified) {
        this.isVerified = isVerified;
    }

    /**
     * 
     * @return
     *     The added
     */
    @JsonProperty("added")
    public String getAdded() {
        return added;
    }

    /**
     * 
     * @param added
     *     The added
     */
    @JsonProperty("added")
    public void setAdded(String added) {
        this.added = added;
    }

    /**
     * 
     * @return
     *     The size
     */
    @JsonProperty("size")
    public String getSize() {
        return size;
    }

    /**
     * 
     * @param size
     *     The size
     */
    @JsonProperty("size")
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * 
     * @return
     *     The timesCompleted
     */
    @JsonProperty("times_completed")
    public String getTimesCompleted() {
        return timesCompleted;
    }

    /**
     * 
     * @param timesCompleted
     *     The times_completed
     */
    @JsonProperty("times_completed")
    public void setTimesCompleted(String timesCompleted) {
        this.timesCompleted = timesCompleted;
    }

    /**
     * 
     * @return
     *     The owner
     */
    @JsonProperty("owner")
    public String getOwner() {
        return owner;
    }

    /**
     * 
     * @param owner
     *     The owner
     */
    @JsonProperty("owner")
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * 
     * @return
     *     The categoryname
     */
    @JsonProperty("categoryname")
    public String getCategoryname() {
        return categoryname;
    }

    /**
     * 
     * @param categoryname
     *     The categoryname
     */
    @JsonProperty("categoryname")
    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    /**
     * 
     * @return
     *     The categoryimage
     */
    @JsonProperty("categoryimage")
    public String getCategoryimage() {
        return categoryimage;
    }

    /**
     * 
     * @param categoryimage
     *     The categoryimage
     */
    @JsonProperty("categoryimage")
    public void setCategoryimage(String categoryimage) {
        this.categoryimage = categoryimage;
    }

    /**
     * 
     * @return
     *     The username
     */
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @param username
     *     The username
     */
    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * @return
     *     The privacy
     */
    @JsonProperty("privacy")
    public String getPrivacy() {
        return privacy;
    }

    /**
     * 
     * @param privacy
     *     The privacy
     */
    @JsonProperty("privacy")
    public void setPrivacy(String privacy) {
        this.privacy = privacy;
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
