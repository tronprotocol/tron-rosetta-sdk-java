package org.tron.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * OperationStatus is utilized to indicate which Operation status are considered successful.
 */
@ApiModel(description = "OperationStatus is utilized to indicate which Operation status are considered successful.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-07-17T15:25:41.238219+08:00[Asia/Shanghai]")

public class OperationStatus   {
  @JsonProperty("status")
  private String status;

  @JsonProperty("successful")
  private Boolean successful;

  public OperationStatus status(String status) {
    this.status = status;
    return this;
  }

  /**
   * The status is the network-specific status of the operation.
   * @return status
  */
  @ApiModelProperty(required = true, value = "The status is the network-specific status of the operation.")
  @NotNull


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public OperationStatus successful(Boolean successful) {
    this.successful = successful;
    return this;
  }

  /**
   * An Operation is considered successful if the Operation.Amount should affect the Operation.Account. Some blockchains (like Bitcoin) only include successful operations in blocks but other blockchains (like Ethereum) include unsuccessful operations that incur a fee. To reconcile the computed balance from the stream of Operations, it is critical to understand which Operation.Status indicate an Operation is successful and should affect an Account.
   * @return successful
  */
  @ApiModelProperty(required = true, value = "An Operation is considered successful if the Operation.Amount should affect the Operation.Account. Some blockchains (like Bitcoin) only include successful operations in blocks but other blockchains (like Ethereum) include unsuccessful operations that incur a fee. To reconcile the computed balance from the stream of Operations, it is critical to understand which Operation.Status indicate an Operation is successful and should affect an Account.")
  @NotNull


  public Boolean getSuccessful() {
    return successful;
  }

  public void setSuccessful(Boolean successful) {
    this.successful = successful;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OperationStatus operationStatus = (OperationStatus) o;
    return Objects.equals(this.status, operationStatus.status) &&
        Objects.equals(this.successful, operationStatus.successful);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, successful);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OperationStatus {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    successful: ").append(toIndentedString(successful)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
