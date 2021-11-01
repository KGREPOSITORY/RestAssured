package Froms;

import com.fasterxml.jackson.annotation.*;



@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VoteForm extends Form {
    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("id")
    private int id;

    @JsonProperty("image_id")
    private String imageId;

    @JsonProperty("sub_id")
    private String sub_id;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("value")
    private int value;


    public VoteForm(String imageId, String sub_id, int value){
        this.imageId = imageId;
        this.sub_id = sub_id;
        this.value = value;
    }

    @JsonCreator()
    public VoteForm(@JsonProperty("country_code") String countryCode,
                    @JsonProperty("created_at") String createdAt,
                    @JsonProperty("id") int id,
                    @JsonProperty("image_id") String imageId,
                    @JsonProperty("sub_id") String sub_id,
                    @JsonProperty("user_id") String userId,
                    @JsonProperty("value") int value) {
        this.countryCode = countryCode;
        this.createdAt = createdAt;
        this.id = id;
        this.imageId = imageId;
        this.sub_id = sub_id;
        this.userId = userId;
        this.value = value;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getSub_id() {
        return sub_id;
    }

    public void setSub_id(String sub_id) {
        this.sub_id = sub_id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null)return false;
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;
        VoteForm voteFormToCompare = (VoteForm) obj;
        return id == voteFormToCompare.getId();
    }
}
