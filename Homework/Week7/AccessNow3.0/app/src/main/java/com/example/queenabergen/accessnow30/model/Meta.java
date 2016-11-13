package com.example.queenabergen.accessnow30.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by queenabergen on 11/13/16.
 */

public class Meta {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("response_id")
    @Expose
    private String responseId;

    /**
     *
     * @return
     * The status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     *
     * @param msg
     * The msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     *
     * @return
     * The responseId
     */
    public String getResponseId() {
        return responseId;
    }

    /**
     *
     * @param responseId
     * The response_id
     */
    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }

}

