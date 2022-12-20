package utilities.restOperations.requestPayloads;

import lombok.Getter;
import lombok.Setter;

public class AddTestResultsPayload {

    @Getter @Setter private String status_id;
    @Getter @Setter private String custom_comment;

    public AddTestResultsPayload(String statusId, String customComment) {
        this.status_id = statusId;
        this.custom_comment = customComment;
    }
}
