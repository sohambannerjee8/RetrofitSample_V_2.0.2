package com.indus.retrofitsample.response;

import java.util.List;

import lombok.Data;

/**
 * Created by Soham on 25-01-2016.
 */
@Data
public class StateResponse {
    private int responseCode;
    private String responseMsg;
    private List<States> states;
    @Data
    public class States{
        private int stateid;
        private String state;
    }
}
