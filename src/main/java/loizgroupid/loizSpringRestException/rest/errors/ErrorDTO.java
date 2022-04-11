package loizgroupid.loizSpringRestException.rest.errors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * DTO for transfering error message with a list of field errors.
 */
public class ErrorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message;
    private String description;


    public ErrorDTO() {
        this(null, null);
    }

    public ErrorDTO(String message) {
        this(message, null);
    }

    public ErrorDTO(String message, String description) {
        this.setMessage(message);
        this.setDescription(description);
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}




}
